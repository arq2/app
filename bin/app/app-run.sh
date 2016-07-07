#!/usr/bin/env bash

/etc/init.d/newrelic-sysmond start

export MONGO_URI=mongodb://localhost:27017/app_dev

java -javaagent:/newrelic.jar -jar /app-jar-with-dependencies.jar
