FROM maven:3.6.0-jdk-11-slim as BUILD_IMAGE
RUN java --version
COPY . .
RUN mvn clean
RUN mvn package -Dmaven.test.skip=true

EXPOSE 8080

# FROM openjdk:11-jre
RUN ls -l ./target
