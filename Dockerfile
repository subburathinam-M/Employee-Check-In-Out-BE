# Java runtime use pannu
FROM openjdk:17-jdk-slim

# Container-la work folder set pannu
WORKDIR /app

# Local target folder-la irukra jar ah container-kulla copy pannu
COPY target/*.jar app.jar

# Spring Boot port open pannu
EXPOSE 8080

# Jar run pannu
ENTRYPOINT ["java", "-jar", "app.jar"]
