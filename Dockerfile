FROM amazoncorretto:17
MAINTAINER icruzelizondo
COPY target/portfolioback-0.0.1-SNAPSHOT.jar cruz-app.jar
ENTRYPOINT ["java","-jar","/cruz-app.jar"]
