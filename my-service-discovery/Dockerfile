FROM openjdk:17

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY /target/my-service-discovery*.jar /app/my-service-discovery.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8761
EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar my-service-discovery.jar
## --spring.profiles.active=${PROFILE}
