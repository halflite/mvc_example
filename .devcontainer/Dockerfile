# Amazon Corretto with Java 17 / Debian 12
FROM maven:3.9.6-amazoncorretto-17-debian-bookworm
RUN apt update && apt -y install git && \
    unlink /etc/localtime && \
    ln -s /usr/share/zoneinfo/Asia/Tokyo /etc/localtime
 