FROM openjdk:17

WORKDIR /app

COPY target/my-report*.jar /app/my-report.jar

ENTRYPOINT ["java", "-jar", "my-report.jar"]
