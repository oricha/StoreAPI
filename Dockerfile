FROM openjdk:8-jdk-alpine
MAINTAINER yourname@example.com
COPY target/docker-message-server-1.0.0.jar message-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/message-server-1.0.0.jar"]