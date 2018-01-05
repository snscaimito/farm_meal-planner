FROM openjdk:jdk-alpine
MAINTAINER sns@caimito.net

ARG JAR_VERSION

COPY target/meal-planner-web-$JAR_VERSION.jar /opt/app.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]