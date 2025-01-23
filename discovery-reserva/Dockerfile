FROM eclipse-temurin:21
EXPOSE 5050
ARG JAR_FILE=target/discovery.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
