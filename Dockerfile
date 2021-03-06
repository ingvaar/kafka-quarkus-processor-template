# Stage 1 : build
FROM quay.io/quarkus/ubi-quarkus-native-s2i:22.1-java11 AS build

COPY --chown=quarkus:quarkus . /usr/src/app

ARG MAVEN_USERNAME
ENV MAVEN_USERNAME $MAVEN_USERNAME

ARG MAVEN_PASSWORD
ENV MAVEN_PASSWORD $MAVEN_PASSWORD

WORKDIR /usr/src/app

RUN ./gradlew build -Dquarkus.package.type=native --no-daemon

# Stage 2 : run
FROM quay.io/quarkus/quarkus-micro-image:1.0

WORKDIR /work/
    
COPY --from=build /usr/src/app/build/*-runner /work/application

EXPOSE 8080

CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]