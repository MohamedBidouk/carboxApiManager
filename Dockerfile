FROM eclipse-temurin:17.0.5_8-jdk-alpine

WORKDIR /apigateway

COPY target/apimanager-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]