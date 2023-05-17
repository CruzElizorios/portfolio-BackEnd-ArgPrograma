FROM amazoncorretto:17-alpine-jdk
MAINTAINER icruzelizondo
COPY target/portfolioback-0.0.1-SNAPSHOT.jar cruz-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/cruz-app.jar"]
