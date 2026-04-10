# Context Preservation Guide

This file captures project context so future iterations do not lose direction.

## Current Scope
- Monorepo with `/backend`, `/frontend`, `/helm`, and root orchestration files.
- Security model based on Keycloak JWT with roles `ADMIN`, `CUSTOMER`.
- Domain entities: categories, products, cart_items, orders, order_items.

## Next Priorities
1. Generate a full Angular workspace and wire real API services.
2. Add update/delete endpoints and pagination/filtering.
3. Add integration tests with Testcontainers + PostgreSQL.
4. Add Keycloak realm export JSON and bootstrap script.
5. Harden Helm with probes, envs, persistence, and ingress TLS.

## Operational Notes
- Backend expects env vars `DB_URL`, `DB_USER`, `DB_PASSWORD`, `KEYCLOAK_ISSUER`.
- Liquibase baseline changelog file: `001-initial-schema.yaml`.
- Docker Compose is primary local dev entry point.
