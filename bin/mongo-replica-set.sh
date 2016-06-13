#!/usr/bin/env bash

sudo mkdir -p /data/db/rs0/mongo1/
sudo mkdir -p /data/db/rs0/mongo2/
sudo mkdir -p /data/db/rs0/mongo3/

sudo mongod --port 27017 --dbpath /data/db/rs0/mongo1/ --replSet rs0 --logpath /var/log/mongodb/mongo1.log
sudo mongod --port 27018 --dbpath /data/db/rs0/mongo2/ --replSet rs0 --logpath /var/log/mongodb/mongo2.log
sudo mongod --port 27019 --dbpath /data/db/rs0/mongo3/ --replSet rs0 --logpath /var/log/mongodb/mongo3.log

tail -f /var/log/mongodb/mongo1.log
tail -f /var/log/mongodb/mongo2.log
tail -f /var/log/mongodb/mongo3.log

# creacion del replica set:
# mongo --host cosmigonon --port 27017
# > rs.initiate()
# > rs.add("cosmigonon:27018")
# > rs.add('cosmigonon:27019')
# > rs.status()

# conexion de cliente:
# mongo --host cosmigonon --port 27017
# mongo --host cosmigonon --port 27018

# prueba - ejecucion numero 1465857987988
# salida de server primario
# 2016-06-13T19:46:42.314-0300 I CONTROL  [signalProcessingThread] dbexit:  rc: 0
# server secundario elegido
# 2016-06-13T19:46:54.214-0300 I REPL     [rsSync] transition to primary complete; database writes are now permitted
#
# los tiempos de respuesta de la aplicación no fueron muy diferentes respecto
# del tiempo de transición de un server mongo a otro.
# La herramienta de tests de carga sólo reporta respuestas con una granularidad
# de un segundo
