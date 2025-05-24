# Use an official OpenJDK runtime as the base image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/ecs-fargate-demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Set environment variables
ENV SPRING_PROFILES_ACTIVE=prod
ENV SPRING_PROFILES_DEFAULT=prod
ENV SPRING_PROFILES_INCLUDE=prod
ENV SPRING_PROFILES_EXCLUDE=local

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]