# Getting Started

### Reference Documentation
For further reference, please consider the following sections:


## Prerequisites
- Docker
- Java 17

## Setup
1. Build the application:

Start PostgreSQL with Docker:
```
docker run -p 5432:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_USER=postgres -e POSTGRES_DB=storeapi -d postgres
```
Run the Spring Boot Application:
```
./gradlew bootRun
```
Access the application at http://localhost:8080

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

