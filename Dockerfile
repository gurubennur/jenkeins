# Build the executable Spring Boot jar with Java 21.
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY pom.xml .
RUN mvn -B -q dependency:go-offline
COPY src ./src
RUN mvn -B -q clean package -DskipTests

# Run the application on a small Java 21 runtime image.
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /workspace/target/springboot-rest-api.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
