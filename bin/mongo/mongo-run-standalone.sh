#!/usr/bin/env bash

/etc/init.d/newrelic-sysmond start

mongod --port 27017
