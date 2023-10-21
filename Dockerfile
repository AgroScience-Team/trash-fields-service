FROM openjdk:17

WORKDIR /app

COPY target/field_service-0.0.1-SNAPSHOT.jar field_service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "field_service-0.0.1-SNAPSHOT.jar"]