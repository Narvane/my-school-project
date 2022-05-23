FROM openjdk:17

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY target/my-school*.jar /app/my-school.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8081
EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar my-school.jar
## --spring.profiles.active=${PROFILE}

