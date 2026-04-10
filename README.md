# Computer Parts Store

Full-stack starter for a computer parts ecommerce system using Spring Boot, Angular, Keycloak, PostgreSQL, Liquibase, Docker Compose, and Helm.

## Modules
- `backend/` Spring Boot API with layered architecture (controller/service/repository), DTOs, MapStruct mappers, validation, exception handling, OAuth2 resource server, and Liquibase.
- `frontend/` Angular app shell with product listing and API integration.
- `helm/computer-parts-store/` Kubernetes chart templates.

## Run with Docker Compose
```bash
docker compose up --build
```
Services:
- Frontend: http://localhost:4200
- Backend: http://localhost:8080
- Keycloak: http://localhost:8081
- PostgreSQL: localhost:5432

## Keycloak setup
1. Create realm: `computer-store`.
2. Create client for frontend/backend and configure JWT with `realm_access.roles`.
3. Create roles: `ADMIN`, `CUSTOMER`.
4. Assign users to roles.

## API endpoints
- Products: `GET/POST/PUT/DELETE /api/products`
- Categories: `GET/POST/PUT/DELETE /api/categories`
- Cart: `GET/POST/DELETE /api/cart`
- Orders: `POST /api/orders/checkout`, `GET /api/orders/me`

## Testing
Backend tests include Mockito unit test and Testcontainers integration test:
```bash
cd backend && mvn test
```

## Helm deployment
```bash
helm install computer-parts-store ./helm/computer-parts-store
```

## Security and quality notes
- No secrets hardcoded in Java code; runtime env vars are used.
- Spring Security enforces role-based access.
- Liquibase controls schema evolution.
