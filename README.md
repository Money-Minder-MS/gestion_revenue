# Revenue Service — Income & Categories

Manages user **revenue** entries and their **categories** for Money Minder MS.

## Tech stack
Java · Spring Boot · Spring Data JPA · H2 (file) · Spring Cloud (Eureka, Config, OpenFeign) · RabbitMQ (AMQP) · springdoc-openapi · Actuator

## API — port `8090`
Base paths `/revenues` and `/categories` (full CRUD), plus lookups by user. Swagger UI at `/swagger-ui.html`.

## Data & messaging
H2 file database · publishes events over RabbitMQ · calls the user service via OpenFeign.

## Run
```bash
mvn spring-boot:run
```

## Configuration
Settings live in `src/main/resources/application.properties`. Override datasource and RabbitMQ credentials with environment variables for shared environments.

## Part of Money Minder MS

One service of the **Money Minder MS** Spring Cloud platform. Full architecture and
the other services: [API-Gateway README](https://github.com/Money-Minder-MS/API-Gateway).
Start EurekaServer (8761) and Config-Server (8099) first.

