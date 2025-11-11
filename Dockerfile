# Use a lightweight JRE base image
FROM openjdk:8-jre-alpine

# Set working directory
WORKDIR /usr/app

# Copy the built JAR file into the container
COPY ./target/java-maven-app-*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
