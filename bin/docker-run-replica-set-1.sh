#!/usr/bin/env bash

mkdir -p /data/db/rs0/mongo1/ && mkdir -p /data/db/rs0/mongo2/
mongod --port 27017 --dbpath /data/db/rs0/mongo1/ --replSet rs0 --logpath /var/log/mongodb/mongo1.log &
mongod --port 27018 --dbpath /data/db/rs0/mongo2/ --replSet rs0 --logpath /var/log/mongodb/mongo2.log &
sleep 5
mongo --port 27017 --eval 'rs.initiate({_id:"rs0", members: [{"_id":1, "host":"localhost:27017"}, {"_id":2, "host":"localhost:27018"}]})'

/etc/init.d/newrelic-sysmond start

export MONGO_URI=mongodb://localhost:27017,localhost:27018/app_dev?replicaSet=rs0

java -javaagent:/newrelic.jar -jar /app-jar-with-dependencies.jar
