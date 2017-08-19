FROM frolvlad/alpine-oraclejdk8:slim
COPY target/spring-boot-docker-0.1.0.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]