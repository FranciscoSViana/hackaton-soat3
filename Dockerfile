FROM openjdk:17

WORKDIR /app

COPY target/atendmed-0.0.1-SNAPSHOT.jar /app/atendmed.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "atendmed.jar" ]