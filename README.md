# MindWell — full-stack wellness journal

A responsive website inspired by the pastel-blue reference: React + TypeScript, Java 21 / Spring Boot, PostgreSQL, Flyway, JWT bearer authentication, and Docker Compose.

## Start it (Windows)
1. Install and start Docker Desktop.
2. Extract this ZIP to a normal folder.
3. Copy `.env.example` to `.env`. Change `POSTGRES_PASSWORD` and `JWT_SECRET` before any non-local use.
4. Open Command Prompt in the extracted folder and run: `docker compose up --build`
5. Open `http://localhost:5173`.

The first build needs internet access to download Maven/npm dependencies. Stop with Ctrl+C, or run `docker compose down` in another terminal.

## API
- `GET /api/health`
- `POST /api/auth/register` body `{ "name": "...", "email": "...", "password": "at-least-10-chars" }`
- `POST /api/auth/login` body `{ "email": "...", "password": "..." }`
- `GET /api/users/me` bearer token required
- `GET|POST /api/moods` bearer token required
- `GET|POST /api/journal` bearer token required

## Notes
User records are scoped by the authenticated JWT subject. Passwords are BCrypt-hashed. Flyway manages schema. This is a solid local MVP, not a security-audited production deployment: add HTTPS, secret management, rate limiting, account recovery, monitoring, backup/restore, and automated security review before public launch. MindWell is not a substitute for professional mental-health care.
