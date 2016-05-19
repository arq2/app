FROM arq2ag/ubuntu15.10-java8-maven-mongo3.2:latest

VOLUME /tmp

RUN echo 'deb http://apt.newrelic.com/debian/ newrelic non-free' | tee /etc/apt/sources.list.d/newrelic.list
RUN wget -O- https://download.newrelic.com/548C16BF.gpg | apt-key add -
RUN apt-get update && apt-get install -y newrelic-sysmond
# TODO sacar license key a variable de entorno
RUN nrsysmond-config --set license_key=c01e7811be29d1665be98a1ae6e5ad581d0d5b8e
CMD /etc/init.d/newrelic-sysmond start

# TODO: extraer la versión a alguna variable de entorno
ADD https://bintray.com/arq2ag/maven/download_file?file_path=ar%2Fedu%2Funq%2Farq2%2Fapp%2F0.0.2%2Fapp-0.0.2-jar-with-dependencies.jar app-0.0.2-jar-with-dependencies.jar

# ENTRYPOINT ["java", "-jar", "/app-0.0.2-jar-with-dependencies.jar"]

# TODO configurar variables de entorno
# TODO levantar el server

EXPOSE 8080
