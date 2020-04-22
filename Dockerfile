FROM openjdk:8-jdk-alpine
MAINTAINER Narendra jaggi
VOLUME /tmp
COPY build/libs/gcp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]