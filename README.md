# Mirar para Cuidar

## Setup ambiente

### Pre-requisitos

*. [Heroku Toolbelt](https://toolbelt.heroku.com/)
*. [MongoDB](http://www.mongodb.org/)
*  [Maven](https://maven.apache.org/)

### Setup del proyecto

1. Check out de este repositorio: `git clone https://github.com/arq2/app.git`
2. Si se desea, cambiar los valores de las variables de entorno en el archivo `.env`
3. Ejecutar `mvn package`.
4. Para levantar el server, ejecutar `heroku local`. Esto debería levantar la aplicación en el puerto por defecto (`8080`).

**Nota**: Al usar `heroku local` se utiliza exactamente la misma forma de ejecución que Heroku utiliza en la versión deployada, con diferente configuración.

### Empaquetar JAR

Estamos utilizando el plugin Assembly de Maven.

`mvn clean compile assembly:single`

### Variables de entorno:

* `MONGO_URI`: el string de conexión a MongoDB, en la forma `mongodb://[user@password]host:post/database`.
* `PORT`: el puerto en donde se levanta el server.
* `ENV`: el entorno en donde va a correr la aplicación: por defecto `development`, y en los servidores de Heroku `production` y `staging` para cada respectivo servidor.
* `HOST`: el host en el que va a levanta

## Pruebas de API:

* Url: `http://localhost:8080/arq2/api/v1/products`
* GET -> json con lista de productos
* POST: agregar header `Content-Type` con valor `application/json` y el cuerpo del request es:

```
{
    "description": "lalalala",
    "name": "mi producto",
    "value": "10"
}
```

## Documentación de desarrollo

### Crear un resource REST 
