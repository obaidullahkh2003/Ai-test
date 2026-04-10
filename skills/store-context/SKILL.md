---
name: store-context
description: Use when continuing work on the Computer Parts Store repo to preserve architecture, runbook, and delivery checklist context across sessions.
---

# Store Context

Use this skill when asked to extend or debug the Computer Parts Store platform.

## Snapshot
- Backend: Spring Boot 3 + Java 21 + PostgreSQL + Liquibase + Keycloak resource server.
- Frontend: Angular + Angular Material.
- Infra: Docker Compose + Helm chart.

## Workflow
1. Validate backend compiles/tests: `cd backend && mvn test`.
2. Confirm migrations exist in `backend/src/main/resources/db/changelog`.
3. Ensure security constraints are preserved (ADMIN for catalog writes, CUSTOMER for cart/checkout).
4. Keep API shape RESTful under `/api/*`.
5. Update `README.md` whenever setup steps or ports change.

## References
- Architecture and commands: `references/project-map.md`.
- Delivery checklist: `references/checklist.md`.
