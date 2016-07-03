## Prueba de stress con un CPU y 2 nodos de MongoDB en réplica

### Ejecución

* Docker: `docker run -i --memory-swap 500M --memory 500M --cpuset-cpus="0" -p 8080:8080 --net=host -t arq2ag/mirar-para-cuidar ./docker-run-replica-set-1.sh`
* Máquina host: `mvn gatling:execute -Dloadtest=true`

### Resultados

### Análisis
