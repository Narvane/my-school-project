FROM openjdk:17

WORKDIR /app

COPY /target/my-service-discovery*.jar /app/my-service-discovery.jar

ENTRYPOINT ["java", "-jar", "my-service-discovery.jar"]
