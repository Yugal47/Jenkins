FROM maven:latest AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DSkipTests

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar App.jar

EXPOSE 8081

CMD ["java", "-jar", "App.jar"]
