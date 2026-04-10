# Computer Parts Store

Full-stack starter for a computer parts store with Spring Boot + Angular + Keycloak + PostgreSQL.

## Included
- Backend (Java 21, Spring Boot, Spring Security OAuth2 Resource Server, Liquibase, JPA, MapStruct)
- Frontend skeleton (Angular routes/pages, Angular Material-ready)
- Dockerfiles and docker-compose for backend/frontend/postgres/keycloak
- Helm chart templates for deployment/service/config/secret/ingress
- Unit test example with JUnit5 + Mockito

## Run locally
```bash
docker compose up --build
```

Services:
- Frontend: http://localhost:4200
- Backend API: http://localhost:8080/api
- Keycloak: http://localhost:8081
- PostgreSQL: localhost:5432

## Keycloak setup
1. Create realm `parts-store`.
2. Create client for backend API (bearer-only or confidential).
3. Add roles `ADMIN` and `CUSTOMER`.
4. Add users and assign roles.
5. Configure issuer to `http://localhost:8081/realms/parts-store`.

## API overview
- `GET/POST /api/products`
- `GET/POST /api/categories`
- `GET/POST /api/cart`
- `POST /api/orders/checkout`
- `GET /api/orders`

## Testing
```bash
cd backend
mvn test
```

## Deployment
```bash
helm install parts-store ./helm/computer-parts-store
```

## Security and quality
- No hardcoded production secrets (env vars used)
- Layered architecture with DTOs, mappers, services, repositories
- Global exception handler and bean validation
