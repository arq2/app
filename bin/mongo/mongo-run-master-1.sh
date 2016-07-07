#!/usr/bin/env bash

/etc/init.d/newrelic-sysmond start

mongod --replSet mpc1 --logpath /var/log/mongodb/mongo.log &
sleep 5
mongo --eval 'rs.initiate({_id:"mpc1", members: [{"_id":1, "host":"mpc.mongo.one:27017"}, {"_id":2, "host":"mpc.mongo.two:27017"}]})'
tail -f /var/log/mongodb/mongo.log
