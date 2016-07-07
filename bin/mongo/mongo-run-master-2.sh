#!/usr/bin/env bash

/etc/init.d/newrelic-sysmond start

mongod --replSet mpc2 --logpath /var/log/mongodb/mongo.log &
sleep 5
mongo --eval 'rs.initiate({_id:"mpc2", members: [{"_id":1, "host":"mpc.mongo.one:27017"}, {"_id":2, "host":"mpc.mongo.two:27017"}, {"_id":3, "host":"mpc.mongo.three:27017"}]})'
tail -f /var/log/mongodb/mongo.log
