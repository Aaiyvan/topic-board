FROM gradle:8-alpine AS build
WORKDIR /topic/app
COPY src /topic/app/src
COPY build.gradle settings.gradle /topic/app/
RUN gradle clean build -x test --no-daemon

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /topic/app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]