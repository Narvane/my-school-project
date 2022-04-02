FROM openjdk:17

WORKDIR /app

COPY target/my-school*.jar /app/my-school.jar

ENTRYPOINT ["java", "-jar", "my-school.jar"]
