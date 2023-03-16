FROM eclipse-temurin:17-jre-focal

VOLUME /tmp

COPY build/libs/guitartuner-0.0.1-SNAPSHOT.jar guitartuner.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "guitartuner.jar" ]