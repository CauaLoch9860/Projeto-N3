FROM openjdk:17-jdk-slim
WORKDIR /app

COPY target/climate-app-0.0.1-SNAPSHOT.jar climate-app.jar
EXPOSE 8080

# Comando pra executar
ENTRYPOINT ["java", "-jar", "climate-app.jar"]

