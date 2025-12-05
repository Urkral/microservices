FROM eclipse-temurin:24_36-jre-noble AS builder
WORKDIR /app
COPY build/libs/*.jar app.jar
FROM eclipse-temurin:24_36-jre-noble
WORKDIR /app
COPY --from=builder /app/app.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
