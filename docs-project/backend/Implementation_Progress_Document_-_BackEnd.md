# Gestão Colégio Colibri — Implementation Progress Document (Backend)

## 1. Current Status

Baseline snapshot of the existing code, before refactoring. The API covers CRUD for logins, students, staff, classes, subjects, terms and grades, with HTTP Basic authentication and role-based access. There are no active tests and no changes in progress.

The architecture and the open refactoring points are in `Context_Document_-_BackEnd.md`, sections 2 and 7.

## 2. Database Migrations

* `V1__db_estrutura.sql`: creates `aluno`, `disciplina`, `funcionario`, `login`, `nota`, `periodo`, `turma` with primary keys and foreign keys. Generated from a MySQL 8.0.34 dump.
* `V2__db_dados.sql`: sample data (7 `INSERT` statements) for all tables, including sample logins with plain-text passwords.

Schema decisions as they stand:

* Table names are singular and in Portuguese.
* `login.role` is an enum (`ALUNO`, `PROFESSOR`, `DIRETOR`).
* Primary keys are `INT` auto-increment (`id_<table>`).

## 3. Application Configuration

* `application.yaml`: active profile `local`; Flyway enabled with `baselineOnMigrate` and `validateOnMigrate`; `spring.jpa.hibernate.ddl-auto: validate`.
* `application-local.yaml`: Docker Compose support enabled (`docker/docker-compose.yaml`); datasource on `localhost:3306`, database `bd_projeto_colegio_colibri`, hardcoded local credentials.
* `application-db.yaml`: datasource from `MYSQL_HOST`, `MYSQL_USERNAME`, `MYSQL_PASSWORD`; Docker Compose disabled. Not active by default.
* `docker/docker-compose.yaml`: one service, `mysql:8.0` (pinned; it was `mysql:latest`, which resolves to MySQL 26.x and is not verified by Flyway), port 3306, named volume `data` (`docker_data`). The previous volume, first initialized by MySQL 26.10, was deleted and recreated, because MySQL 8.0 cannot open data from a newer version.

## 4. Endpoints

All under the base paths below. Authorization rules are in `Context_Document_-_BackEnd.md`, section 4.

| Base path | Operations |
| --- | --- |
| `/logins` | list, get, create, update, delete |
| `/alunos` | list, get, create, update, delete |
| `/funcionarios` | list, get, create, update, delete |
| `/turmas` | list, get, create, update, delete |
| `/disciplinas` | list, get, create, update, delete |
| `/periodos` | list, get, create, update, delete |
| `/notas` | list, get, create, update, delete |

Responses are DTOs (`controller/dtos/response/`); requests are DTOs with Bean Validation (`controller/dtos/request/`).

## 5. Dependencies

* Spring Boot 4.0.5 starters: data-jpa, webmvc, validation, security, test, flyway; `spring-boot-docker-compose`
* MySQL Connector/J (runtime), `flyway-mysql`
* MapStruct 1.6.3 with processor, Lombok managed by the Boot parent (annotation processing configured in `pom.xml`)
* springdoc-openapi 2.8.8 (Swagger UI)
* jjwt removed from the POM (it was not used by any code)

## 6. Test Coverage

* One test class, `ProjetoColegioColibriApplicationTests`, with `contextLoads()`. It is annotated `@Disabled`.
* No unit or integration tests exist.

## 7. Known Issues

Found in review of the current code. They match the open points in `Context_Document_-_BackEnd.md`, section 7.

* Passwords are stored and compared in plain text (`NoOpPasswordEncoder`).
* Every exception returns HTTP 500 with the exception message in `detail` (`RestExceptionHandler`). Not-found errors (for example, the `RuntimeException` "Registo não Encontrado!" in `LoginModel`) are also 500.
* `GET /alunos/{id}` and `GET /notas/{id}` have no ownership check.
* PROFESSOR can update and delete any nota (`NotaService.updateNota`, `deleteNota`), not only those of their class.
* ALUNO can list all students of their class (`AlunoService.getAlunos`).
* `jjwt` dependencies are unused.
* `SecurityUtils.getRole()` returns only the first granted authority.
* No active tests.

## 8. In Progress

Stack upgrade: the POM now targets Spring Boot 4.0.5, Java 26, MapStruct 1.6.3 and springdoc-openapi 2.8.8, following the `order-flow` backend. Baseline before the change: `mvn clean compile` failed on JDK 26 with `ExceptionInInitializerError: TypeTag :: UNKNOWN` (Lombok 1.18.32). After the change: `mvn clean compile` succeeds and `mvn test` passes (the single test is still `@Disabled`). Code change needed: `WebSecurityConfig` uses the lambda DSL (`csrf(csrf -> csrf.disable())`, `httpBasic(Customizer.withDefaults())`), because Spring Security 7 removed the no-argument forms. Startup against MySQL 8.0 was verified: the application starts, Flyway validates and applies migrations V1 and V2 on an empty schema, and Tomcat listens on 8080.

Problems found along the way:
* Spring Boot's Docker Compose integration failed in some runs with `No host port mapping found for container port 3306`. The cause is not confirmed. The port mapping was correct when inspected while the container was running, and the failure did not reproduce on the last run. `SPRING_DOCKER_COMPOSE_ENABLED=false` avoids the integration if it returns.
* The previous volume `docker_data` was created by MySQL 26.10. MySQL 8.0 refused it (`Cannot downgrade from 261000 to 80045`). The volume was deleted by decision; the schema and sample data were recreated from migrations V1 and V2.
* The `mysql:latest` tag had resolved to MySQL 26.x, which Flyway (verified up to 8.1) warned about. The `mysql:8.0` pin removes that warning. Security is out of scope: it will be replaced by OAuth2 with Keycloak later.

## 9. Pending Decisions

Each item from `Context_Document_-_BackEnd.md`, section 7, is an open decision. Record the chosen option here when one is made.
