## Prueba de stress con un CPU y 2 nodos de MongoDB en réplica

### Ejecución

* Docker:
  * Mongo DB Master: `docker run -i --memory-swap 200M  --memory 200M  --cpuset-cpus="0" -p 27017:27017 --net=host -t arq2ag/mirar-para-cuidar-mongo ./mongo-run-master-1.sh`
  * Mongo DB Slave:  `docker run -i --memory-swap 200M  --memory 200M  --cpuset-cpus="0" -p 27018:27018 --net=host -t arq2ag/mirar-para-cuidar-mongo ./mongo-run-slave-1.sh`
  * Aplicación:      `docker run -i --memory-swap 1200M --memory 1200M --cpuset-cpus="0" -p 8080:8080   --net=host -t arq2ag/mirar-para-cuidar-app   ./app-run-rs1.sh`
* Máquina host: `mvn gatling:execute -Ploadtest`

### Resultados

* Iniciado  : dd/mm hh:mm am/pm
* Finalizado: dd/mm hh:mm am/pm
* Simulación Gatling \#xxx

### Análisis
