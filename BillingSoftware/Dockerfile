# Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the Spring Boot jar into the container
COPY target/BillingSoftware-0.0.1-SNAPSHOT.jar app.jar

# Expose port (same as Spring Boot default)
EXPOSE 8080

# Command to run the jar
CMD ["java", "-jar", "app.jar"]
]

