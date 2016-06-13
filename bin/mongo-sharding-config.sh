#!/usr/bin/env bash
# crear directorio de logs
sudo mkdir -p /var/lib/mongodb/shardedcluster

# config servers
sudo mongod --configsvr --port 26050 --logpath /var/lib/mongodb/shardedcluster/log.cfg0 --logappend --dbpath /var/lib/mongodb/shardedcluster/cfg0 --fork
sudo mongod --configsvr --port 26051 --logpath /var/lib/mongodb/shardedcluster/log.cfg1 --logappend --dbpath /var/lib/mongodb/shardedcluster/cfg1 --fork
sudo mongod --configsvr --port 26052 --logpath /var/lib/mongodb/shardedcluster/log.cfg2 --logappend --dbpath /var/lib/mongodb/shardedcluster/cfg2 --fork

# mongod's
sudo mongod --shardsvr --replSet a --dbpath /var/lib/mongodb/shardedcluster/a0 --logpath /var/lib/mongodb/shardedcluster/log.a0 --port 27000 --fork --logappend --smallfiles --oplogSize 50
sudo mongod --shardsvr --replSet a --dbpath /var/lib/mongodb/shardedcluster/a1 --logpath /var/lib/mongodb/shardedcluster/log.a1 --port 27001 --fork --logappend --smallfiles --oplogSize 50
sudo mongod --shardsvr --replSet a --dbpath /var/lib/mongodb/shardedcluster/a2 --logpath /var/lib/mongodb/shardedcluster/log.a2 --port 27002 --fork --logappend --smallfiles --oplogSize 50

# mongos
sudo mongos --configdb cosmigonon:26050,cosmigonon:26051,cosmigonon:26052 --fork --logappend --logpath /var/lib/mongodb/shardedcluster/log.mongos0
sudo mongos --configdb cosmigonon:26050,cosmigonon:26051,cosmigonon:26052 --fork --logappend --logpath /var/lib/mongodb/shardedcluster/log.mongos1 --port 26061

# TODO: armar un replica set con dos nodos, un master y un slave, no es necesario sharding para la primer prueba
