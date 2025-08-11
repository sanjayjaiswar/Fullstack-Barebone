# Technical Overview

## Architecture
```
[Angular SPA] <-> [Spring Boot API] <-> [Database]
```

## Request Flow
A client request includes a JWT in the `Authorization` header. `JwtRequestFilter` validates the token and populates the security context before the request reaches the controller.

## Security Model
The application uses JWT for stateless auth. Roles (`ADMIN`, `USER`) are enforced with `@PreAuthorize` on controller methods.

## Database Schema
Tables `organizations` and `users` with a foreign key from users to organizations.

## Extensibility
To add a new entity like `Product`:
1. Create the JPA entity and migration.
2. Add repository, service, and DTO.
3. Expose CRUD endpoints in a controller with security annotations.
4. Add Angular components and routes for UI management.
