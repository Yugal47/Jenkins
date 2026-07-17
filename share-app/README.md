# Share App

A minimal full-stack app: click a button in the React UI, it calls a Spring Boot
API, which returns a message and logs the click in PostgreSQL.

## Structure
```
share-app/
├── backend/    Spring Boot (Java 17, Maven)
└── frontend/   React
```

## 1. Database (PostgreSQL)
Make sure PostgreSQL is running locally, then create the database:
```bash
psql -U postgres -f backend/schema.sql
```
Update credentials in `backend/src/main/resources/application.properties` if yours differ
from `postgres` / `postgres`.

The `click_log` table is created automatically on first run (`ddl-auto=update`).

## 2. Backend (Spring Boot)
```bash
cd backend
mvn spring-boot:run
```
Runs on **http://localhost:8081**.

Endpoints:
- `GET /api/message` — returns a message and logs the click
- `GET /api/history` — returns all logged clicks

## 3. Frontend (React)
```bash
cd frontend
npm install
npm start
```
Runs on **http://localhost:3000** and calls the backend at `http://localhost:8080/api`.

## How it works
1. You click the button in the browser.
2. React calls `GET http://localhost:8080/api/message`.
3. Spring Boot saves a row to `click_log` in PostgreSQL and returns a JSON message.
4. React displays the message on screen.

## Notes
- CORS is enabled in `MessageController` for `http://localhost:3000` only — update the
  `@CrossOrigin` origin if you serve the frontend elsewhere.
- To switch to MySQL: swap the `postgresql` dependency in `pom.xml` for
  `mysql-connector-j`, and change the `spring.datasource.url` / dialect in
  `application.properties`.
