# Stage 1: Build and test with Maven
FROM maven:3.9-eclipse-temurin-23 AS builder
WORKDIR /app
COPY . .
RUN mvn clean verify -Dspring.profiles.active=test

# Stage 2: Run with Java 23
FROM eclipse-temurin:23-jre-alpine
WORKDIR /app

# Copy the built JAR from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Create non-root user 'appuser'
RUN addgroup -S appuser && adduser -S appuser -G appuser
USER appuser

# Expose Spring Boot default port
EXPOSE 8080

# Load environment variables from mounted volume
ENTRYPOINT ["java", "-jar", "app.jar"]

