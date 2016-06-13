#!/usr/bin/env bash

sudo mkdir -p /var/lib/mongodb/
sudo mkdir -p /var/lib/mongodb2/

sudo mongod --port 27017 --dbpath /var/lib/mongodb/ --replSet rs0
sudo mongod --port 27018 --dbpath /var/lib/mongodb2/ --replSet rs0

# creacion del replica set:
# rs.initiate()
# rs.add("cosmigonon:27018")
# rs.status()

# conexion de cliente:
# mongo --host cosmigonon --port 27017
# mongo --host cosmigonon --port 27018
