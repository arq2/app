FROM arq2ag/ubuntu15.10-java8-maven-mongo3.2:latest

VOLUME /tmp

# TODO: extraer la versión a alguna variable de entorno
ADD https://bintray.com/arq2ag/maven/download_file?file_path=ar%2Fedu%2Funq%2Farq2%2Fapp%2F0.0.2%2Fapp-0.0.2-jar-with-dependencies.jar app-0.0.2-jar-with-dependencies.jar

ENTRYPOINT ["java", "-jar", "/app-0.0.2-jar-with-dependencies.jar"]

# TODO solucionar problemas de ClassNotFound al correr
# TODO configurar variables de entorno
# TODO levantar el server

EXPOSE 3000