#!/usr/bin/env bash

/etc/init.d/newrelic-sysmond start

mongod --port 27017 --replSet mpc1 --logpath /var/log/mongodb/mongo.log &
sleep 5
mongo --eval 'rs.initiate({_id:"mpc1", members: [{"_id":1, "host":"localhost:27017"}, {"_id":2, "host":"localhost:27018"}]})'
sleep 2
tail -f /var/log/mongodb/mongo.log
