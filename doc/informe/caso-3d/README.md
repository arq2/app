## Prueba de stress con un CPU y 3 nodos de MongoDB en réplica

(eliminando un nodo Master durante el tope de carga y luego reintegrándolo al Cluster después de varios minutos)

### Ejecución

* Docker:
  * Mongo DB Slave 1: `docker run -i --memory-swap 200M  --memory 200M  --cpuset-cpus="0" -p 27018:27018 --net=host -t arq2ag/mirar-para-cuidar-mongo ./mongo-run-slave-2a.sh`
  * Mongo DB Slave 2: `docker run -i --memory-swap 200M  --memory 200M  --cpuset-cpus="0" -p 27019:27019 --net=host -t arq2ag/mirar-para-cuidar-mongo ./mongo-run-slave-2b.sh`
  * Mongo DB Master:
    * `docker run -i --memory-swap 200M  --memory 200M  --cpuset-cpus="0" -p 27017:27017 --net=host -t arq2ag/mirar-para-cuidar-mongo /bin/bash`
    * `> ./mongo-run-master-2.sh`
    * `> Ctrl+C script anterior`
    * `> mongod --port 27017 --replSet mpc2`
  * Aplicación:       `docker run -i --memory-swap 1200M --memory 1200M --cpuset-cpus="0" -p 8080:8080   --net=host -t arq2ag/mirar-para-cuidar-app   ./app-run-rs2.sh`
* Máquina host: `mvn gatling:execute -Ploadtest`

### Resultados

* Boot app  : 10/07 14:28
* Iniciado  : 10/07 14:34
* Eliminado nodo: 10/07 14:39
* Reincorporado nodo: 10/07 14:44
* Finalizado: 10/07 14:45
* Stop app  : 10/07 14:48
* Simulación Gatling \#1468172056977

Web transactions
![Web transactions](imagenes/web-transactions.png)
<iframe src="https://rpm.newrelic.com/public/charts/1OFzqFTsvMM" width="500" height="300" scrolling="no" frameborder="no"></iframe>

Error rate
![Error rate](imagenes/error-rate.png)
<iframe src="https://rpm.newrelic.com/public/charts/eehU9uvC5bs" width="500" height="300" scrolling="no" frameborder="no"></iframe>

GC
![GC](imagenes/gc.png)
<iframe src="https://rpm.newrelic.com/public/charts/axLTW0KI7Rs" width="500" height="300" scrolling="no" frameborder="no"></iframe>

Average memory usage
![Average memory usage](imagenes/avg-mem-usage.png)
<iframe src="https://rpm.newrelic.com/public/charts/7i3Vxw3p7bq" width="500" height="300" scrolling="no" frameborder="no"></iframe>

Memory usage
![Memory usage](imagenes/mem-usage.png)
<iframe src="https://rpm.newrelic.com/public/charts/1kR21OiIV5s" width="500" height="300" scrolling="no" frameborder="no"></iframe>

CPU usage
![CPU usage](imagenes/cpu-usage.png)
<iframe src="https://rpm.newrelic.com/public/charts/agCrtmlrUrU" width="500" height="300" scrolling="no" frameborder="no"></iframe>

Throughput
![Throughput](imagenes/throughput.png)
<iframe src="https://rpm.newrelic.com/public/charts/2hIx9lyF2oT" width="500" height="300" scrolling="no" frameborder="no"></iframe>

Response time
![Response time](imagenes/response-time.png)
<iframe src="https://rpm.newrelic.com/public/charts/bF8e3guVnVm" width="500" height="300" scrolling="no" frameborder="no"></iframe>

### Análisis
