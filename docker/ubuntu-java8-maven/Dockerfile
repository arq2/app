FROM ubuntu:15.10

# Download latest package list (required)
RUN apt-get update

# Install add-apt-repository utility
RUN apt-get -y install software-properties-common python-software-properties

# Automagically accept Oracle's license (for oracle-java8-installer)
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections

# Install Java8
RUN add-apt-repository ppa:webupd8team/java
RUN apt-get update
RUN apt-get install -y oracle-java8-installer

# Install Maven
RUN apt-get -y install maven
