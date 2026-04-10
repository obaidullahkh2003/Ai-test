# Computer Parts Store

Production-ready scaffold for a full-stack **Computer Parts Store** using Spring Boot, Angular, Keycloak, PostgreSQL, Docker, and Helm.

## What is included

- Backend (Java 21 + Spring Boot + JPA + Liquibase + OAuth2 Resource Server)
- Frontend placeholder package for Angular + Material
- Dockerfiles for backend/frontend
- Docker Compose stack (backend/frontend/postgres/keycloak)
- Helm chart (Deployment, Service, ConfigMap, Secret, Ingress)
- CI/CD workflow (`.github/workflows/ci-cd.yml`)
- Unit and Testcontainers integration test examples

## Quick start

```bash
docker compose up --build
```

Services:
- Frontend: http://localhost:4200
- Backend: http://localhost:8080
- Keycloak: http://localhost:8081
- PostgreSQL: localhost:5432

## Keycloak setup

1. Login with `admin/admin`.
2. Create realm: `computer-parts`.
3. Create roles: `ADMIN`, `CUSTOMER`.
4. Create users and assign roles.
5. Configure client for frontend/backend tokens.

## Backend API

- `GET/POST/DELETE /api/products`
- `GET/POST/PUT/DELETE /api/categories`
- `GET/POST /api/orders`
- `GET/POST/DELETE /api/cart/{customerId}`

## Testing

```bash
cd backend
mvn test
```

## Deployment (Helm)

```bash
helm lint ./helm/computer-parts-store
helm install cps ./helm/computer-parts-store
```

## Security notes

- No hardcoded production secrets in code.
- Override secrets via env vars / CI secret store / K8s Secret.
- OAuth2 JWT issuer points to Keycloak realm.
