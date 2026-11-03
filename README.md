# Gestão Colégio Colibri

> A school management portfolio project: a Spring Boot REST API for students, staff, classes, subjects, terms, grades and logins, with role-based access. Originally built as a course-completion project and now being refactored.

---

## What it does

- Manages the school's records: logins, students (`alunos`), staff (`funcionarios`), classes (`turmas`), subjects (`disciplinas`), terms (`periodos`) and grades (`notas`).
- Authenticates with HTTP Basic against the `login` table.
- Restricts each operation by role:
  - **DIRETOR** manages everything (logins, students, staff, classes, subjects, terms, grades).
  - **PROFESSOR** reads students and grades, and creates, updates and deletes grades.
  - **ALUNO** reads students and grades.

The full rules are in [`docs-project/backend/Context_Document_-_BackEnd.md`](docs-project/backend/Context_Document_-_BackEnd.md), section 4.

---

## Tech stack

### Backend
| Technology | Purpose |
|---|---|
| Java 26, Spring Boot 4.0.5 | Application framework |
| Spring Security | Authentication (HTTP Basic) and roles |
| Spring Data JPA, MySQL 8 | Persistence |
| Flyway | Database migrations |
| MapStruct 1.6.3, Lombok | Mapping between DTOs, domain and entities |
| SpringDoc OpenAPI 2.8.8 | API documentation (Swagger UI) |
| Docker Compose | Local MySQL |

### Frontend
Not started. The frontend will live in its own folder at the root of this repository.

---

## Repository layout

```
gestaoColegioColibri/
├── projetoColegioColibriApi/   # Spring Boot REST API (Maven project)
│   ├── pom.xml
│   ├── docker/                 # docker-compose.yaml for the local MySQL
│   └── src/main/
│       ├── java/pt/colegio/colibri/
│       │   ├── controller/     # REST controllers and DTOs
│       │   ├── business/       # Services and domain classes
│       │   ├── model/          # JPA entities, repositories and model mappers
│       │   └── config/         # Security and error handling
│       └── resources/
│           ├── application*.yaml
│           └── db/migration/   # Flyway scripts (V1 schema, V2 sample data)
├── docs-project/               # Context and progress documents (backend, and frontend later)
└── bd/                         # Reference SQL scripts and the database diagram
```

### Backend layers

Each entity follows the same chain, from the outside in:

```
controller  →  business/service  →  business/core (domain)  →  model  →  model/entity (JPA)
```

Controllers receive and return DTOs. MapStruct converts between DTOs, domain classes and JPA entities at each boundary.

---

## Getting started

### Prerequisites
- Docker and Docker Compose, with the Docker daemon running
- Java 26
- Maven 3.8 or newer

### Run the API

```bash
cd projetoColegioColibriApi
mvn spring-boot:run
```

With the default `local` profile, Spring Boot starts the MySQL container from `docker/docker-compose.yaml` on its own. Flyway then creates the schema and loads the sample data. The database is `bd_projeto_colegio_colibri` on port 3306; the local credentials are in `src/main/resources/application-local.yaml`.

The API listens on `http://localhost:8080`. Swagger UI is at `http://localhost:8080/swagger-ui.html`.

To log in, use HTTP Basic with one of the logins from the sample data in `src/main/resources/db/migration/V2__db_dados.sql`.

### Run the tests

```bash
cd projetoColegioColibriApi
mvn test
```

The only test class is currently `@Disabled`, so this runs no active tests.

---

## Documentation

- [`docs-project/backend/Context_Document_-_BackEnd.md`](docs-project/backend/Context_Document_-_BackEnd.md): architecture, domain model, authorization rules, persistence, and the open points for the refactoring.
- [`docs-project/backend/Implementation_Progress_Document_-_BackEnd.md`](docs-project/backend/Implementation_Progress_Document_-_BackEnd.md): current status, migrations, configuration, endpoints, dependencies, known issues, and pending decisions.

---

## Known limitations

The API is a portfolio baseline and has known gaps, listed in the progress document (section 7). The main ones:

- Passwords are stored and compared in plain text.
- Every error returns HTTP 500.
- Any authenticated user can read a student or grade by id.

Security is planned to move to OAuth2 with Keycloak.
