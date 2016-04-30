FROM arq2ag/ubuntu-java8-maven:latest

RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv EA312927
RUN echo 'deb http://repo.mongodb.org/apt/ubuntu trusty/mongodb-org/3.2 multiverse' | tee /etc/apt/sources.list.d/mongodb-org-3.2.list
RUN apt-get update && apt-get install -y mongodb-org \
			 mongodb-org-server \
			 mongodb-org-shell \
			 mongodb-org-mongos \
			 mongodb-org-tools

RUN mkdir -p /data/db

EXPOSE 27017
CMD ["mongod"]
