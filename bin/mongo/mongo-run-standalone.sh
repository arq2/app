#!/usr/bin/env bash

/etc/init.d/newrelic-sysmond start

mongod --logpath /var/log/mongodb/mongo.log &
tail -f /var/log/mongodb/mongo.log
