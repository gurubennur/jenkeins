# Spring Boot REST API demo

A small Java 21 Spring Boot application with Swagger UI. It has no database or persistence layer.

## Endpoints

| Method | Path | Example |
| --- | --- | --- |
| GET | `/api/greeting?name=Guruprasad` | Returns a greeting and timestamp |
| GET | `/api/status` | Returns the API status |
| GET | `/swagger-ui/index.html` | Interactive Swagger UI |
| GET | `/v3/api-docs` | OpenAPI JSON |

## Run on Ubuntu

Install Java 21 and Maven, then from this project directory:

```bash
mvn clean package
java -jar target/springboot-rest-api.jar
```

Open `http://localhost:8080/swagger-ui/index.html` or try the API:

```bash
curl "http://localhost:8080/api/greeting?name=Guruprasad"
curl "http://localhost:8080/api/status"
```

## Build and run the Docker image

The Dockerfile builds the app and image using Java 21:

```bash
docker build -t springboot-rest-api:latest .
docker run --rm -p 8080:8080 springboot-rest-api:latest
```

Then visit `http://localhost:8080/swagger-ui/index.html`. On a remote Ubuntu machine, use its reachable IP address and make sure inbound TCP port 8080 is allowed in its firewall and cloud security rules.
