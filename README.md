# Computer Parts Store

Full-stack template with Spring Boot, Angular, Keycloak, PostgreSQL, Docker Compose, and Helm.

## Run locally
1. `docker compose up --build`
2. Backend: `http://localhost:8080`
3. Frontend: `http://localhost:4200`
4. Keycloak: `http://localhost:8081` (`admin/admin`)

## Keycloak setup
- Realm imported from `keycloak/realm-export.json`.
- Roles: `ADMIN`, `CUSTOMER`.
- Configure client `parts-ui` for SPA login.

## Backend development
```bash
cd backend
mvn spring-boot:run
```

## Testing
```bash
cd backend
mvn test
```

## Deployment
```bash
helm upgrade --install parts-store ./helm/computer-parts-store
```

## Notes
- Do not commit secrets; use env vars or Kubernetes Secret.
- Liquibase migrations are under `backend/src/main/resources/db/changelog`.
