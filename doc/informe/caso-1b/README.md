## Prueba de stress con dos CPUs y un nodo de MongoDB

### Ejecución

* Docker:
  * Mongo DB:   `docker run -i --memory-swap 500M  --memory 500M  --cpuset-cpus="0,1" -p 27017:27017 --net=host -t arq2ag/mirar-para-cuidar-mongo ./mongo-run-standalone.sh`
  * Aplicación: `docker run -i --memory-swap 1200M --memory 1200M --cpuset-cpus="0,1" -p 8080:8080   --net=host -t arq2ag/mirar-para-cuidar-app   ./app-run.sh`
* Máquina host: `mvn gatling:execute -Ploadtest`

### Resultados

* Iniciado  : dd/mm hh:mm am/pm
* Finalizado: dd/mm hh:mm am/pm
* Simulación Gatling \#xxx

### Análisis
