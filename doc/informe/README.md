## Arquitectura 2: Trabajo Final

### Test de carga

El test realiza lo siguiente:

* Conecta 20 usuarios de una vez
* Hace un ramp up de 20 usuarios a 50 usuarios por segundo en los 2 primeros minutos
* Mantiene 50 usuarios por segundo en los próximos 8 minutos

### Parámetros generales

* Memoria RAM: 2G (cualquier cantidad menor detenía el server java)
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

### Cosas a ver (TODO)

- uso de CPU
- uso de memoria
- comportamiento de la JVM con diferentes GC (mark and sweep vs. G1)
+ requests per minute
+ tiempos de respuesta (promedio/percentiles)
- IO red + latencia
- cuanto cuesta la réplica?
- puedo minimizar el impacto de perder el master?

+: los provee gatling
