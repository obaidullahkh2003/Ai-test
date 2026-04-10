# Context Keeper

Use this file as persistent context so future sessions do not lose project intent.

## Product vision
Computer Parts Store full-stack app with secure auth, role-based access, and deployment-ready infrastructure.

## Completed baseline
- Spring Boot backend scaffolded with layered architecture, CRUD APIs, cart and checkout flow.
- Keycloak JWT resource-server integration with roles `ADMIN` and `CUSTOMER`.
- PostgreSQL + Liquibase migrations for `categories`, `products`, `orders`, `order_items`, `cart_items`.
- Angular frontend shell with product list view.
- Dockerfiles, docker-compose, Helm chart templates.

## Next priority tasks
1. Add full Angular pages for login, admin dashboard, cart, and checkout.
2. Add refresh-token and Keycloak JS integration on frontend.
3. Add pagination/filtering and stock decrement in checkout transaction.
4. Increase test coverage (service/controller/integration).
5. Add CI pipeline and vulnerability scanning.

## Conventions
- Keep backend layered (controller/service/repository) with DTO boundaries.
- Keep schema changes only through Liquibase files.
- Never commit secrets; use env vars and Kubernetes secrets.
