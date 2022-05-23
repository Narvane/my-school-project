FROM openjdk:17

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY target/my-user*.jar /app/my-user.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8082
EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar my-user.jar
## --spring.profiles.active=${PROFILE}
