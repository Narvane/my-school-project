FROM openjdk:17

WORKDIR /app

COPY target/my-user*.jar /app/my-user.jar

ENTRYPOINT ["java", "-jar", "my-user.jar"]
