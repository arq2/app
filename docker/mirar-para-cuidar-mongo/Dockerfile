FROM arq2ag/ubuntu15.10-java8-maven-mongo3.2:latest

VOLUME /tmp

RUN echo 'deb http://apt.newrelic.com/debian/ newrelic non-free' | tee /etc/apt/sources.list.d/newrelic.list
RUN wget -O- https://download.newrelic.com/548C16BF.gpg | apt-key add -
RUN apt-get update && apt-get install -y newrelic-sysmond
RUN nrsysmond-config --set license_key=c01e7811be29d1665be98a1ae6e5ad581d0d5b8e

ADD https://bintray.com/arq2ag/generic/download_file?file_path=mongo-run-standalone.sh mongo-run-standalone.sh
ADD https://bintray.com/arq2ag/generic/download_file?file_path=mongo-run-master-1.sh mongo-run-master-1.sh
ADD https://bintray.com/arq2ag/generic/download_file?file_path=mongo-run-slave-1.sh mongo-run-slave-1.sh
ADD https://bintray.com/arq2ag/generic/download_file?file_path=mongo-run-master-2.sh mongo-run-master-2.sh
ADD https://bintray.com/arq2ag/generic/download_file?file_path=mongo-run-slave-2a.sh mongo-run-slave-2a.sh
ADD https://bintray.com/arq2ag/generic/download_file?file_path=mongo-run-slave-2b.sh mongo-run-slave-2b.sh
RUN chmod +x mongo-run*
