FROM openjdk:17
#VOLUME /tmp
#EXPOSE 8081
MAINTAINER baeldung.com
COPY target/SchoolSite-0.0.1-SNAPSHOT.jar school-server.jar
ENTRYPOINT ["java", "-jar", "/school-server.jar"]

##FROM maven:3.8.2-jdk-8

##WORKDIR /bezkoder-app
##COPY . .
##RUN mvn clean install

##CMD mvn SCHOOL_SITE_SERVER:run





##
##FROM mysql:8

## The maintainer name and email
##MAINTAINER Ashraf Sharif

## List all packages that we want to install
##ENV PACKAGE percona-xtrabackup-23

# Install requirement (wget)
##RUN apt-get update && \
##    apt-get install -y wget

# Install Percona apt repository and Percona Xtrabackup
##RUN wget https://repo.percona.com/apt/percona-release_0.1-3.jessie_all.deb && \
##    dpkg -i percona-release_0.1-3.jessie_all.deb && \
##    apt-get update && \
##    apt-get install -y $PACKAGE

# Create the backup destination
##RUN mkdir -p /backup/xtrabackups

# Allow mountable backup path
##VOLUME ["/backup/xtrabackup"]