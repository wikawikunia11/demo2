
FROM eclipse-temurin:25-jdk-alpine AS build
WORKDIR /app

COPY gradlew .
COPY gradle gradle


COPY build.gradle .
COPY settings.gradle .
RUN ./gradlew dependencies --no-daemon


RUN chmod +x gradlew
COPY src src
RUN ./gradlew bootJar --no-daemon


FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
