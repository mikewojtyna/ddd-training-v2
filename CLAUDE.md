# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build and Test Commands

```bash
# Build
./mvnw clean compile

# Run all tests
./mvnw clean test

# Run a single test class
./mvnw test -Dtest=StartFundraisingTest

# Run a single test method
./mvnw test -Dtest=BikeStationTest#test0

# Build JAR
./mvnw clean package -DskipTests
```

Requires Java 21.

## Project Overview

**CrowdSorcery** is a DDD training project built with Spring Boot 3.1.5. It teaches Domain-Driven Design concepts through a progressive series of tasks (`/tasks/task-0.md` through `task-6.md`). The domain models a crowdfunding/investment platform with fundraising, deposits, investments, and payments.

## Architecture

### Bounded Contexts

Each subdomain under `src/main/java/pl/wojtyna/trainings/ddd/crowdsorcery/` is a bounded context:
- **fundraising** — project fundraising lifecycle
- **deposit** — investor deposit accounts (most complete hexagonal example)
- **investment** — investor and investment records
- **profile** — user profiles (JPA)
- **payment**, **interest**, **simulation** — additional domain modules

### Hexagonal Architecture (Ports & Adapters)

The `deposit` module demonstrates the canonical structure:
```
deposit/
├── api/          # contracts: events, queries, use cases
├── domain/       # pure domain logic (aggregates, policies, events)
└── infra/        # Spring/JPA adapters
    ├── adapters/primary/    # inbound (controllers)
    └── adapters/secondary/  # outbound (repositories, external)
```

Domain logic in `domain/` must not depend on `infra/`. Infrastructure implements domain interfaces.

### DDD Building Blocks

The codebase uses [jMolecules](https://github.com/xmolecules/jmolecules) annotations to mark DDD constructs:
- `@AggregateRoot`, `@Entity`, `@ValueObject` — tactical building blocks
- `@SecondaryPort`, `@PrimaryPort` — hexagonal architecture markers

Key patterns:
- **Aggregates** publish domain events via a `DomainEvents` collection (collected internally, not dispatched directly)
- **Policies** implement `DomainPolicy` interface
- **Fluent APIs** express domain intent: `FundraisingSystem.startFundraising().by(investor).basedOn(form)`
- **Bounded context markers** (e.g., `FundraisingBoundedContextMarker`) enforce context boundaries

### Reference Implementations

- `src/main/java/pl/wojtyna/trainings/ddd/citybike/` — CitiBike rental domain with `bad/` (anti-patterns) and `good/` (proper DDD) subdirectories
- `src/main/java/pl/wojtyna/trainings/recipes/` — task problems and solutions

### Tech Stack

| Concern | Technology |
|---------|-----------|
| Framework | Spring Boot 3.1.5 |
| Persistence | Spring Data JPA + H2 (in-memory) |
| DDD annotations | jMolecules DDD 1.6.0 + Hexagonal 1.7.0 |
| Money | Joda Money 1.0.3 |
| Context mapping | ContextMapper 1.2.1 |
| Testing | JUnit 5, AssertJ |
