FROM amazoncorretto:21-alpine-jdk
EXPOSE 5051
ARG JAR_FILE=target/gateway.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]