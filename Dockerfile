


FROM amazoncorretto:17-alpine-jdk

MAINTAINER emaaristimuno

COPY target/0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/0.0.1-SNAPSHOT.jar"]



