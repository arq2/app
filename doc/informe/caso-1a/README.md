## Prueba de stress con un CPU y un nodo de MongoDB

### Ejecución

* Docker: `docker run -i --memory-swap 2G --memory 2G --cpuset-cpus="0" -p 8080:8080 --net=host -t arq2ag/mirar-para-cuidar ./docker-run.sh`
* Máquina host: `mvn gatling:execute -Dloadtest=true`

### Resultados

### Análisis
