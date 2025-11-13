# Use maintained lightweight JRE base
FROM eclipse-temurin:8-jre-alpine

# Set working directory
WORKDIR /usr/app

# Copy the built JAR into container
COPY ./target/java-maven-app-*.jar app.jar

# Expose application port:
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "app.jar"]
