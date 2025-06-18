# Etapa 1: build com Maven + Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagem final com apenas o JAR e Java 21
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta 8081 dentro do container
EXPOSE 8081

# Define a porta com argumento de linha de comando
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=8081"]

