# Fullstack Barebone

## Overview
This project provides a baseline fullstack application with a Spring Boot backend and Angular frontend packaged into a single executable JAR.

## Tech Stack
- Java 21 / Spring Boot 3.3
- Angular 17 with TailwindCSS
- MySQL or H2 database

## Prerequisites
- JDK 21
- Maven 3
- Docker (optional)

## Quick Start (H2)
```bash
mvn clean package
java -jar target/baseline-app-0.0.1-SNAPSHOT.jar
```

## Running with MySQL via Docker
```bash
docker-compose up --build
```

## API & UI Access
- API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui/index.html
