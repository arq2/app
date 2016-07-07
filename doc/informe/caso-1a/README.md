## Prueba de stress con un CPU y un nodo de MongoDB (standalone)

### Ejecución

* Docker:
  * Mongo DB:   `docker run -i --memory-swap 500M  --memory 500M  --cpuset-cpus="0" -p 27017:27017 --net=host -t arq2ag/mirar-para-cuidar-mongo ./mongo-run-standalone.sh`
  * Aplicación: `docker run -i --memory-swap 1200M --memory 1200M --cpuset-cpus="0" -p 8080:8080   --net=host -t arq2ag/mirar-para-cuidar-app   ./app-run.sh`
* Máquina host: `mvn gatling:execute -Ploadtest`

### Resultados

* Boot app  : 07/07 2:50 am
* Iniciado  : 07/07 2:54 am
* Finalizado: 07/07 3:55 am
* Simulación Gatling \#1467870860226

### Análisis

Consumo de memoria de la aplicación subió más allá de que la carga se mantuvo desde el minuto 3 del test.
Claramente hay una optimización por hacer en la aplicación. Incluso después de finalizado el test el consumo
no bajó.

MongoDB no consumió más de 100MB de memoria en el pico de carga.

Consumo de CPU fue alto al inicio (booteo de la aplicación), pero muy aceptable durante la carga (25% aprox).

<iframe src="https://rpm.newrelic.com/public/charts/62mupi2SnzT" width="500" height="300" scrolling="no" frameborder="no"></iframe>

<iframe src="https://rpm.newrelic.com/public/charts/gIfnf7EedJF" width="500" height="300" scrolling="no" frameborder="no"></iframe>
