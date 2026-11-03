# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Idioma

Responda sempre em português do Brasil (pt-BR) ao usuário. Isso vale para as respostas no chat. Código, nomes de classes e métodos (já em português no projeto), mensagens de commit e a documentação técnica seguem o padrão já existente no repositório.

## Backend: autorização explícita

- Não execute nada automaticamente. Isso inclui iniciar, parar ou reiniciar a aplicação, rodar `mvn` (build, test ou `spring-boot:run`), subir ou parar containers Docker, e gravar no banco.
- Alterar código também exige autorização para aquela mudança.
- Antes de qualquer ação dessas, diga o que pretende fazer e espere a resposta explícita do usuário. Uma autorização vale só para a ação descrita. Ela não vale para as próximas.
- Leitura de código e de documentação é permitida sem autorização.

## Fluxo de trabalho

- O projeto é um portfólio, originalmente um trabalho de conclusão de curso. Está sendo refatorado. Não há deploy previsto, então não planeje configuração de produção além do necessário para rodar.
- Não há problema se uma mudança quebrar algo e for refeita, nem se a refatoração ficar um pouco diferente do planejado. O que importa é que o usuário esteja a par das mudanças e autorize cada ação sensível (ver seção de backend). Não é preciso ser conservador com a estabilidade do código.
- Trabalhe em partes. Cada parte aplica um conjunto de mudanças do mesmo tipo, atualiza a documentação afetada (`../docs-project/backend/`) e termina com um commit.
- Antes do commit, compile e rode os testes (`mvn test`) somente depois de autorização (ver seção acima).
- Não inclua no commit alterações não relacionadas à parte.
- Mensagens de commit em inglês, no padrão `type(backend): ...`, com a linha de coautoria definida no ambiente.

## Modelo de execução

- Codificação de algo já definido (implementar, editar, refatorar, escrever testes) e execução de comandos (`git`, `mvn`, `docker` e similares) devem rodar no modelo Haiku.
- Isso vale também para subagentes: ao usar a ferramenta Agent para essas tarefas, passe `model: "haiku"`.
- Só as questões de análise (arquitetura, decisões de design, revisão mais profunda) podem usar outro modelo, e apenas quando necessário.

## Documentação do projeto

Consulte estes arquivos sob demanda, em vez de depender de memória. O status atual fica no progress document, então não o copie para este arquivo:

- Contexto do backend (arquitetura atual, modelo de domínio, autorização, persistência, pontos abertos da refatoração): `../docs-project/backend/Context_Document_-_BackEnd.md`
- Progresso do backend (migrações, configuração, endpoints, dependências, problemas conhecidos, decisões pendentes): `../docs-project/backend/Implementation_Progress_Document_-_BackEnd.md`

## Commands

Java 26, Spring Boot 4.0.5, Maven (`mvn`). Não há README, nem configuração de lint ou formatação, e o único teste está `@Disabled`. Os comandos abaixo são de referência; só rode-os com autorização explícita.

- Rodar a aplicação (perfil `local`, sobe o MySQL via Docker Compose): `mvn spring-boot:run`
- Build: `mvn clean package`
- Todos os testes: `mvn test`
- Uma classe de teste: `mvn -Dtest=ProjetoColegioColibriApplicationTests test`
- Um método de teste: `mvn -Dtest=ProjetoColegioColibriApplicationTests#contextLoads test`
- Subir só o banco: `docker compose -f docker/docker-compose.yaml up -d db`
- Swagger UI (springdoc), com a aplicação rodando: `/swagger-ui.html`

Banco: MySQL `bd_projeto_colegio_colibri` na porta 3306. As credenciais do perfil local estão em `src/main/resources/application-local.yaml`.

## Configuração e perfis

- `application.yaml` ativa o perfil `local` e configura o Flyway. O esquema é de responsabilidade do Flyway (`src/main/resources/db/migration`), com `ddl-auto: validate`. Mudanças nas entidades exigem uma nova migração `V{n}__*.sql`, não DDL do Hibernate.
- Perfil `local`: credenciais fixas e suporte do Spring Boot ao Docker Compose, que sobe `docker/docker-compose.yaml` na inicialização.
- Perfil `db` (`application-db.yaml`): não é ativado por padrão. Lê `MYSQL_HOST`, `MYSQL_USERNAME` e `MYSQL_PASSWORD` do ambiente e desativa o Docker Compose. Para usar um banco não local: `SPRING_PROFILES_ACTIVE=db`.

## Arquitetura

Pacote raiz: `pt.colegio.colibri`. Nomes e comentários estão em português (`aluno`, `turma`, `nota`, `professor`, `diretor`); mantenha o padrão em código novo.

As requisições passam por quatro camadas, e cada entidade tem a sua cadeia de classes:

1. **`controller/`**: `@RestController` com DTOs de `controller/dtos/`. Os mappers MapStruct em `controller/mapper` convertem DTO ↔ domínio.
2. **`business/service/`**: serviços finos que chamam a camada `model`. `NotaService` e `AlunoService` são a exceção: contêm a filtragem de leitura por papel.
3. **`business/core/`**: classes de domínio simples (Lombok `@Data`), como `Nota` e `Aluno`. Não são entidades JPA.
4. **`model/`**: componentes `*Model` que envolvem um `*Repository` (Spring Data JPA) e convertem `model/entity/*Entity` (JPA) ↔ domínio via `model/mapper` (MapStruct).

Ao adicionar um campo, normalmente é preciso alterá-lo no DTO de request/response, na classe de domínio, na entidade JPA, na migração e nos dois mappers. O MapStruct gera as implementações na compilação, então um mapeamento faltando aparece como aviso de build, não como erro em tempo de execução.

## Segurança

- Spring Security com HTTP Basic (`WebSecurityConfig`). Todas as requisições exigem autenticação; CSRF está desativado.
- Usuários são linhas de `Login`. O enum `role` (`ALUNO`, `PROFESSOR`, `DIRETOR`) vira a autoridade `ROLE_<role>`.
- A autorização é por método, com `@PreAuthorize` nos controllers. A tabela completa está em `../docs-project/backend/Context_Document_-_BackEnd.md`, seção 4.
- Há pontos de segurança conhecidos ainda não resolvidos (senhas em texto puro, leitura por id sem verificação de dono). Estão listados em `../docs-project/backend/Implementation_Progress_Document_-_BackEnd.md`, seção 7. Ao mexer nessas áreas, consulte a lista antes.

## Tratamento de erros

`config/error/RestExceptionHandler` captura toda `Exception` e a devolve como `ProblemDetail` com status 500, inclusive casos de "não encontrado". Isso é um problema conhecido e está no plano de refatoração, não é o comportamento desejado.
