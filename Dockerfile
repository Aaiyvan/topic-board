FROM eclipse-temurin:21-jre-alpine

EXPOSE 8085

ADD /build/libs/*.jar backend.jar

ENTRYPOINT ["java", "-jar", "backend.jar"]