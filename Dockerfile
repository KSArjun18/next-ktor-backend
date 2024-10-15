# Use the official Kotlin image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the built jar file into the container
COPY build/libs/*.jar app.jar

# Expose the port your Ktor server runs on (default is 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
