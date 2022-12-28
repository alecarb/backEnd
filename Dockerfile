


FROM amazoncorretto:17-alpine-jdk

MAINTAINER emaaristimuno

COPY target/alecarb-0.0.1-SNAPSHOT.jar alecarb-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/alecarb-0.0.1-SNAPSHOT.jar"]



