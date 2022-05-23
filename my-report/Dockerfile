FROM openjdk:17

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY target/my-report*.jar /app/my-report.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8083
EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar my-report.jar
## --spring.profiles.active=${PROFILE}

