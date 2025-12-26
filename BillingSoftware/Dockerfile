# Multi-stage build (Render ke liye perfect)
FROM openjdk:17-jdk-slim AS builder
WORKDIR /app
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Production stage
FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE $PORT
ENTRYPOINT ["sh", "-c", "java -jar /app/app.jar"]


