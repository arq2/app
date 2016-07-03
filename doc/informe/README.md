## Arquitectura 2: Trabajo Final

### Test de carga

El test realiza lo siguiente:

* Conecta 20 usuarios de una vez
* Hace un ramp up de 20 usuarios a 50 usuarios por segundo en los 2 primeros minutos
* Mantiene 50 usuarios por segundo en los próximos 8 minutos

### Build

* Imagen Docker: `docker build -t arq2ag/mirar-para-cuidar --build-arg appversion=0.0.6 .`
* Máquina host: `mvn clean package`

### Casos de prueba

* [Caso 1a](caso-1a/README.md)
* [Caso 1b](caso-1b/README.md)
* [Caso 2a](caso-2a/README.md)
* [Caso 2b](caso-2b/README.md)
* [Caso 3a](caso-3a/README.md)
* [Caso 3b](caso-3b/README.md)
* [Caso 3c](caso-3c/README.md)
