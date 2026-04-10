# Computer Parts Store

Full-stack template for a computer parts e-commerce system.

## Stack
- Backend: Java 21, Spring Boot, Spring Security OAuth2 Resource Server, Liquibase, PostgreSQL, MapStruct, Maven
- Frontend: Angular + Angular Material (starter scaffold)
- Infra: Docker, Docker Compose, Helm
- Auth: Keycloak realm `parts-store` with `ADMIN` and `CUSTOMER`

## Run locally
```bash
docker compose up --build
```

Services:
- Frontend: http://localhost:4200
- Backend: http://localhost:8080
- Keycloak: http://localhost:8081

## Keycloak setup
A realm import file is included at `keycloak/realm-export.json`.
Create users and assign realm roles (`ADMIN`, `CUSTOMER`) in Keycloak Admin UI.

## Backend API
- `GET/POST/PUT/DELETE /api/products`
- `GET/POST/PUT/DELETE /api/categories`
- `GET/POST/DELETE /api/cart`
- `POST /api/orders/checkout`
- `GET /api/orders`

## Testing
```bash
cd backend
mvn test
```

## Helm
```bash
helm install parts-store ./helm/computer-parts-store
```
