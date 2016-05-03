package ar.edu.unq.arq2.producers;

import ar.edu.unq.arq2.producers.qualifiers.InjectableProperties;
import ar.edu.unq.arq2.producers.qualifiers.Property;
import ar.edu.unq.arq2.util.Environment;
import ar.edu.unq.arq2.util.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ApplicationProducer {
    @Produces
    public ObjectMapper objectMapper() {
        return ObjectMapperFactory.get();
    }

    @Produces
    @ApplicationScoped
    public Datastore datastore() throws Exception {
        String mongoDbUri = Environment.databaseConnectionUri();
        MongoClientURI uri = new MongoClientURI(mongoDbUri);
        String database = uri.getDatabase();
        final MongoClient mongoClient = new MongoClient(uri);

        final Morphia morphia = new Morphia();
        morphia.mapPackage("ar.edu.unq.arq2.entities");

        final Datastore datastore = morphia.createDatastore(mongoClient, database);
        datastore.ensureIndexes();
        return datastore;
    }

    @Produces
    @Property(value = "")
    public String property(@InjectableProperties Map<String, String> properties, InjectionPoint injectionPoint){
        final Property property = injectionPoint.getAnnotated().getAnnotation(Property.class);
        return properties.get(property.value());
    }

    @ApplicationScoped
    @Produces
    @InjectableProperties
    public Map<String, String> properties() throws IOException {
        Map<String, String> map = new HashMap<>();
        final ResourceBundle bundle = ResourceBundle.getBundle("application");
        bundle.keySet().forEach(key -> map.put(key, bundle.getString(key)));
        return map;
    }
}
