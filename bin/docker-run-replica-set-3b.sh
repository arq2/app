#!/usr/bin/env bash

mkdir -p /data/db/rs0/mongo1/ && mkdir -p /data/db/rs0/mongo2/ && mkdir -p /data/db/rs0/mongo3/
mongod --port 27017 --dbpath /data/db/rs0/mongo1/ --replSet rs0 --logpath /var/log/mongodb/mongo1.log &
pmaster=$!
mongod --port 27018 --dbpath /data/db/rs0/mongo2/ --replSet rs0 --logpath /var/log/mongodb/mongo2.log &
pslave1=$!
mongod --port 27019 --dbpath /data/db/rs0/mongo3/ --replSet rs0 --logpath /var/log/mongodb/mongo3.log &
pslave2=$!
sleep 5
mongo --port 27017 --eval 'rs.initiate({_id:"rs0", members: [{"_id":1, "host":"localhost:27017"}, {"_id":2, "host":"localhost:27018"}, {"_id":3, "host":"localhost:27019"}]})'

/etc/init.d/newrelic-sysmond start

export MONGO_URI=mongodb://localhost:27017,localhost:27018,localhost:27019/app_dev?replicaSet=rs0

java -javaagent:/newrelic.jar -jar /app-jar-with-dependencies.jar &

sleep 3m

kill -9 $pmaster

cat
