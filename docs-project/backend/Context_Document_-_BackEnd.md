# Gestão Colégio Colibri — Backend Context Document

## 1. Overview

REST API for managing a school: students (`aluno`), staff (`funcionario`), classes (`turma`), subjects (`disciplina`), terms (`periodo`), grades (`nota`) and logins. Originally built as a course-completion project (TCC) and now being refactored.

Stack: Java 26, Spring Boot 4.0.5, Spring Data JPA, MySQL, Flyway, Spring Security (HTTP Basic), MapStruct 1.6.3, Lombok (managed by the Boot parent), springdoc-openapi 2.8.8. The stack was upgraded from Java 17 / Spring Boot 3.2.5 / MapStruct 1.5.5 / springdoc 2.1.0. The local environment starts MySQL through Docker Compose.

This document describes the code as it is now (the baseline before refactoring). Refactoring decisions go in section 7 and in the progress document.

## 2. Architecture (as-is)

Layered, package root `pt.colegio.colibri`. Each entity has the same chain of classes:

| Layer | Package | Role |
| --- | --- | --- |
| Controller | `controller/` | `@RestController`, `@PreAuthorize` per method, request/response DTOs (`controller/dtos/`) |
| Controller mapper | `controller/mapper/` | MapStruct, DTO ↔ domain |
| Service | `business/service/` | Business logic and read scoping by role. Calls only the `model` layer |
| Domain | `business/core/` | Plain Lombok classes (`@Data`), not JPA entities. `Pessoa` is the base of `Aluno` and `Funcionario` |
| Model | `model/` | `*Model` components wrap a repository and translate entity ↔ domain |
| Model mapper | `model/mapper/` | MapStruct, entity ↔ domain |
| Entity | `model/entity/` | JPA entities mapped to the tables created by Flyway |
| Repository | `model/repository/` | Spring Data `JpaRepository` interfaces |

Cross-cutting pieces:

- `config/security/`: `WebSecurityConfig` (filter chain, password encoder), `SecurityUtils` (current user and role from `SecurityContextHolder`), `UserDetailsServiceImpl` (loads `Login` for authentication).
- `config/error/RestExceptionHandler`: handles all exceptions (see section 6).

Note: `NotaService` and `AlunoService` contain role-based read logic. The other services are pass-through.

## 3. Domain Model

| Concept | Table | Key fields | Relations |
| --- | --- | --- | --- |
| Login | `login` | `username`, `password`, `role` (`ALUNO`, `PROFESSOR`, `DIRETOR`) | Authority is `ROLE_<role>` |
| Aluno | `aluno` | nome, apelido, idade, email | `login` (1), `turma` (N:1) |
| Funcionario | `funcionario` | nome, apelido, idade, email | `login` (1:1) |
| Turma | `turma` | designacao | `professor` → Funcionario (N:1) |
| Disciplina | `disciplina` | designacao | — |
| Periodo | `periodo` | designacao | — |
| Nota | `nota` | valor (`nota`), `data_atribuicao` | `aluno`, `disciplina`, `periodo` (all N:1, all required) |

## 4. Authorization

Authentication is HTTP Basic against the `login` table. Passwords are compared as plain text (section 6). CSRF is disabled. All requests require authentication.

Per-method rules (`@PreAuthorize`):

| Resource | GET list / GET by id | POST / PUT / DELETE |
| --- | --- | --- |
| `/logins` | DIRETOR | DIRETOR |
| `/alunos` | DIRETOR, PROFESSOR, ALUNO | DIRETOR |
| `/funcionarios` | DIRETOR | DIRETOR |
| `/turmas` | DIRETOR | DIRETOR |
| `/disciplinas` | DIRETOR | DIRETOR |
| `/periodos` | DIRETOR | DIRETOR |
| `/notas` | DIRETOR, PROFESSOR, ALUNO | DIRETOR, PROFESSOR |

Scoping applied inside services, on the list endpoints only:

- `NotaService.getNotas()`: PROFESSOR gets the notes of students in the class (`turma`) they teach; ALUNO gets their own notes; any other role gets all notes.
- `AlunoService.getAlunos()`: PROFESSOR gets the students of their class; ALUNO gets the students of their own class (classmates included); any other role gets all students.

The scoping does not apply to the by-id endpoints or to writes (see section 6).

## 5. Persistence

- Schema is owned by Flyway (`src/main/resources/db/migration`). Hibernate runs with `ddl-auto: validate`, so entity changes need a new migration.
- Table and column names are Portuguese and in snake_case (`id_aluno`, `turma_id`, `data_atribuicao`).
- Relations are eager `@ManyToOne` in most entities; `AlunoEntity.turma` is lazy.
- MapStruct generates the mappers at compile time (`componentModel = "spring"`).

## 6. Key Architectural Decisions (as-is)

- Domain classes are separate from JPA entities. Mapping is done by MapStruct in both directions at the controller and model boundaries.
- Passwords are stored and compared in plain text. `NoOpPasswordEncoder` is the active bean; the BCrypt bean is commented out in `WebSecurityConfig`.
- `RestExceptionHandler` catches `Exception` and returns a `ProblemDetail` with status 500 for every error, including not-found and authentication-lookup failures. The exception message is returned in `detail`.
- Only the `local` profile is active by default. It has hardcoded local credentials and enables Docker Compose startup (`docker/docker-compose.yaml`). The `db` profile reads `MYSQL_HOST`, `MYSQL_USERNAME` and `MYSQL_PASSWORD` from the environment.
- `spring-boot-docker-compose` is on the classpath; this is what starts MySQL automatically with the local profile.

## 7. Open Points for the Refactoring

These are not decided yet. Each needs a decision before the code changes.

Decision (current): security will be replaced by OAuth2 with Keycloak. Items 1 to 3 are therefore deferred and will not be changed before that migration. The current stack upgrade (Spring Boot 4, Java 26, MapStruct 1.6, springdoc 2.8) comes first.

1. **Password storage.** Replace plain text with BCrypt (the commented bean already exists), and decide how existing rows are migrated. *Deferred: replaced by Keycloak.*
2. **Error mapping.** Map not-found to 404, validation to 400, auth to 401/403, and keep 500 for real failures. Stop returning raw exception messages.
3. **By-id ownership.** `GET /alunos/{id}` and `GET /notas/{id}` have no check, so any authenticated user can read any record. Decide the rule per role (for example: ALUNO only their own, PROFESSOR only their class). *Deferred: to be defined with Keycloak roles.*
4. **Write ownership.** A PROFESSOR can update or delete any nota, not only those of their class. Decide whether to restrict this.
5. **Classmate visibility.** ALUNO can list all students in their class, including email addresses. Decide whether this is intended.
6. **Unused dependencies.** The `jjwt` artifacts are declared in `pom.xml` but no code uses them. Remove them or start using them.
7. **Tests.** The only test class is `@Disabled` and has an empty body. Decide what the test baseline should be.
8. **Config secrets.** `application-local.yaml` holds local credentials in plain text and `V2__db_dados.sql` seeds sample logins with plain-text passwords. Decide how to handle both.
