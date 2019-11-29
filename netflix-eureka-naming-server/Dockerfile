FROM openjdk:latest
MAINTAINER Puneet Vashisht <puneetvashisht@gmail.com>
VOLUME /tmp
EXPOSE 8761
ARG JAR_FILE=target/netflix-eureka-naming-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} netflix-eureka-naming-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/netflix-eureka-naming-server.jar"]