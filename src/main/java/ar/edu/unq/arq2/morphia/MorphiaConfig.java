package ar.edu.unq.arq2.morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.example.Employee;

public class MorphiaConfig {
    private static Morphia morphia;
    private static MongoClient client;
    private static Logger log = LogManager.getRootLogger();
    private static String database;

    public static void initialize(String mongoUri) {
        morphia = new Morphia();
        morphia.mapPackage("org.mongodb.morphia.example");
        MongoClientURI mongoClientURI = new MongoClientURI(mongoUri);
        database = mongoClientURI.getDatabase();
        client = new MongoClient(mongoClientURI);
    }

    public static void test() {
        // create the Datastore connecting to the default portNumber on the local host
        log.info("morphia - empezando test");

        final Datastore datastore = morphia.createDatastore(client, database);
        datastore.ensureIndexes();
        log.info("morphia - creado el datastore");

        final Employee elmer = new Employee("Elmer Fudd", 50000.0);
        datastore.save(elmer);
        log.info("registro guardado");

        final Employee daffy = new Employee("Daffy Duck", 40000.0);
        datastore.save(daffy);
        log.info("registro guardado");

        final Employee pepe = new Employee("Pepé Le Pew", 25000.0);
        datastore.save(pepe);
        log.info("registro guardado");

        elmer.getDirectReports().add(daffy);
        elmer.getDirectReports().add(pepe);

        datastore.save(elmer);
        log.info("registro guardado");
    }
}
