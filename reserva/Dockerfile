FROM eclipse-temurin:21
EXPOSE 6060
ARG JAR_FILE=target/reserva.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
