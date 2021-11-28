FROM ubuntu:latest

MAINTAINER gdim "gm.dimitriadis@hotmail.com"

RUN apt-get update && apt-get install -y openjdk-8-jdk

ENV version=docker
ENV dbuser
ENV dbpass
ENV jdbcurl

WORKDIR /usr/local/bin 

ADD target/accepted.jar .

ENTRYPOINT ["java", "-jar", "accepted.jar"]
