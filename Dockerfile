FROM openjdk:17
WORKDIR /app
COPY target/FirstJenkins-0.0.1-SNAPSHOT.jar FirstJenkins-0.0.1-SNAPSHOT.jar
# Expose the application port (default 8080)
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "FirstJenkins-0.0.1-SNAPSHOT.jar"]