FROM maven:3.6.0-jdk-11-slim as BUILD_IMAGE

COPY . .
RUN mvn package

# FROM openjdk:11-jre
RUN ls -l ./target
