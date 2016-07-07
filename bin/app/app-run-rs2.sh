#!/usr/bin/env bash

/etc/init.d/newrelic-sysmond start

export MONGO_URI=mongodb://mpc.mongo.one:27017,mpc.mongo.two:27017,mpc.mongo.three:27017/app_dev

java -javaagent:/newrelic.jar -jar /app-jar-with-dependencies.jar
