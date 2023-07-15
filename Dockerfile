FROM openjdk:17-jdk-alpine
LABEL authors="italosantana"
MAINTAINER github.com/ifsantana
COPY target/connect-four-0.0.1-SNAPSHOT.jar connect-four-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/connect-four-0.0.1.jar"]