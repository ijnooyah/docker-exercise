# BUILD stage
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app
COPY gradle gradle
COPY build.gradle settings.gradle gradlew ./
RUN ./gradlew --no-daemon dependencies
COPY src src
RUN ./gradlew --no-daemon clean build


# RUN stage
FROM eclipse-temurin:21-jre

COPY --from=builder /app/build/libs/*.jar /app/app.jar
ENTRYPOINT ["java"]
CMD ["-jar","/app/app.jar"]