FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy application jar
COPY target/order-service.jar /app.jar

# Expose port
EXPOSE 8082

# Start the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
