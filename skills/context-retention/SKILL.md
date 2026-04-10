---
name: context-retention
description: Preserve implementation context for long multi-step full-stack builds. Use when generating large systems that require stable architectural decisions, tracked TODOs, or continuity across backend/frontend/devops tasks.
---

# Context Retention Workflow

1. Start by writing a compact architecture snapshot with stack, modules, and constraints.
2. Keep a live TODO checklist grouped by backend, frontend, infra, security, and tests.
3. Update the checklist after each completed chunk.
4. Keep decisions deterministic: reuse existing DTO naming, endpoint conventions, and folder structure.
5. Before finishing, run a gap-check against required features and summarize missing items.

## Checklist Template

- Backend
  - Entities, repositories, services, controllers
  - Validation, error handling, mapping
  - Security and roles
- Frontend
  - Routes and page shells
  - API service integration
- Infra
  - Dockerfiles, compose, helm, secrets strategy
- QA
  - Unit tests
  - Integration tests
  - Runbook in README
