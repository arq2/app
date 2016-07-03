## Prueba de stress con un CPU y 3 nodos de MongoDB en réplica (eliminando un nodo Master durante el tope de carga)

### Ejecución

* Docker: `docker run -i --memory-swap 500M --memory 500M --cpuset-cpus="0" -p 8080:8080 --net=host -t arq2ag/mirar-para-cuidar ./docker-run-replica-set-2.sh`
* Máquina host: `mvn gatling:execute -Dloadtest=true`

### Resultados

### Análisis
