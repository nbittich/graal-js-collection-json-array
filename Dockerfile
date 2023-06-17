FROM eclipse-temurin:20-jdk as builder
WORKDIR /build

COPY . .
RUN bash mvnw clean install


FROM eclipse-temurin:20-jre-jammy

WORKDIR /java
COPY test.js test.js
COPY --from=builder /build/target/demo-0.0.1-SNAPSHOT-jar-with-dependencies.jar demo.jar

ENV PATH_TO_SCRIPT=/java/test.js
ENTRYPOINT ["java", "-jar", "demo.jar"]
