## Arquitectura 2: Trabajo Final

### Test de carga

El test realiza lo siguiente:

* Conecta 20 usuarios de una vez
* Hace un ramp up de 20 usuarios a 50 usuarios por segundo en los 2 primeros minutos
* Mantiene 50 usuarios por segundo en los próximos 8 minutos

### Parámetros generales

* Memoria RAM de aplicación: 1200M (cualquier cantidad menor detenía el server java)
* Memoria RAM de los nodos BD: 200M
* CPU: 2 x Intel i5-3120 2.50 GHz
* Swap: 0B
* New Relic: https://rpm.newrelic.com/accounts/1274131/applications/19340847

### Build

* Imágenes Docker
  * Aplicación: `cd docker/mirar-para-cuidar-app && docker build -t arq2ag/mirar-para-cuidar-app --build-arg appversion=0.0.7 .`
  * MongoDB: `cd docker/mirar-para-cuidar-mongo && docker build -t arq2ag/mirar-para-cuidar-mongo .`
* Máquina host: `mvn clean package`

### Casos de prueba

* [Caso 1a](caso-1a/README.md)
* [Caso 1b](caso-1b/README.md)
* [Caso 2a](caso-2a/README.md)
* [Caso 2b](caso-2b/README.md)
* [Caso 3a](caso-3a/README.md)
* [Caso 3b](caso-3b/README.md)
* [Caso 3c](caso-3c/README.md)
* [Caso 3c](caso-3d/README.md)
* [Caso 3d](caso-3d/README.md)

### Conclusiones generales

* Consumo de CPU fue alto al inicio (booteo de la aplicación), pero muy aceptable durante la carga (25% aprox).
* MongoDB no consumió más de 100MB de memoria en el pico de carga, incluso trabajando en réplica.
* No se observa una diferencia considerable en la performance de la aplicación cuando se utilizan más núcleos
de CPU, ya que hay muy poco "procesamiento" (búsqueda de shops) y mucho uso de I/O.
* Consideramos que, por el tipo de queries que realizamos, no llegamos a testear exhaustivamente cómo se comporta
una réplica, hay una cosa muy importante que se puede monitorear, que es el [replication lag](http://blog.mlab.com/2013/03/replication-lag-the-facts-of-life/)
y en nuestra aplicación no tenemos muchas queries complejas
* La carga que le aplicamos a los nodos, en cantidad de requests, podría haber sido mayor, para poder provocar
errores más interesantes. Pero hacer eso dificultaba el monitoreo de los resultados, ya que los nodos de Docker
se detenían, y por ende el test de Gatling terminaba sin éxito. Probamos con el parámetro de `--oom-disable-killer`
de Docker, pero de esa manera la máquina entera donde corrían los contenedores se colgaba.
* El servidor web que utilizamos (Undertow) es bastante pesado en términos de recursos de memoria. Como puede
observarse en los gráficos de cada caso de prueba, sólo el booteo del servidor consume más de 500MB. Esta es una de
las cosas que deberíamos haber tenido en cuenta al iniciar la investigación del web server.
