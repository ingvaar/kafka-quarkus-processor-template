# kafka-quarkus-processor Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its [website](https://quarkus.io/).

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 

```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 

```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/kafka-quarkus-processor-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult this [guide](https://quarkus.io/guides/gradle-tooling).

## Building the Docker image

You can create a standalone docker image using:

```shell script
docker build . -t kafka-quarkus-processor
```

## Configuration

On build configuration can be found in `src/main/resources/application.properties`.

Every configuration line can be set on runtime using env.

In this case, you have to replace every dots by an underscore: `topic.in` becomes `TOPIC_IN`.

## Related Guides

- Camel JSON Path ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/jsonpath.html)): Evaluate a JSONPath expression against a JSON message body
- Kotlin ([guide](https://quarkus.io/guides/kotlin)): Write your services in Kotlin
- Camel Protobuf ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/protobuf.html)): Serialize and deserialize Java objects using Google's Protocol buffers
- Apache Kafka Streams ([guide](https://quarkus.io/guides/kafka-streams)): Implement stream processing applications based on Apache Kafka
- Micrometer metrics ([guide](https://quarkus.io/guides/micrometer)): Instrument the runtime and your application with dimensional metrics using Micrometer.
