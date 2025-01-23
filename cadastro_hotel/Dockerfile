FROM eclipse-temurin:21
EXPOSE 8080
ARG JAR_FILE=target/cadastro-hotel.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]