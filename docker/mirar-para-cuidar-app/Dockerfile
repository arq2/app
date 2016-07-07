FROM arq2ag/ubuntu15.10-java8-maven-mongo3.2:latest

VOLUME /tmp

RUN echo 'deb http://apt.newrelic.com/debian/ newrelic non-free' | tee /etc/apt/sources.list.d/newrelic.list
RUN wget -O- https://download.newrelic.com/548C16BF.gpg | apt-key add -
RUN apt-get update && apt-get install -y newrelic-sysmond
RUN nrsysmond-config --set license_key=c01e7811be29d1665be98a1ae6e5ad581d0d5b8e

ADD https://bintray.com/arq2ag/generic/download_file?file_path=newrelic.yml newrelic.yml
ADD https://bintray.com/arq2ag/generic/download_file?file_path=newrelic.jar newrelic.jar
ADD https://bintray.com/arq2ag/generic/download_file?file_path=app-run.sh app-run.sh
ADD https://bintray.com/arq2ag/generic/download_file?file_path=app-run-rs1.sh app-run-rs1.sh
ADD https://bintray.com/arq2ag/generic/download_file?file_path=app-run-rs2.sh app-run-rs2.sh
RUN chmod +x app-run*

ARG appversion=0.0.7
ADD https://bintray.com/arq2ag/maven/download_file?file_path=ar%2Fedu%2Funq%2Farq2%2Fapp%2F$appversion%2Fapp-$appversion-jar-with-dependencies.jar app-jar-with-dependencies.jar

EXPOSE 8080
