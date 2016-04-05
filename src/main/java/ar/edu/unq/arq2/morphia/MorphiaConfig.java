package ar.edu.unq.arq2.morphia;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.example.Employee;

public class MorphiaConfig {
    private static Morphia morphia;
    private static MongoClient client;

    public static void initialize(String mongoUri) {
        morphia = new Morphia();
        morphia.mapPackage("org.mongodb.morphia.example");
        client = new MongoClient(mongoUri);
    }

    public static void test() {
        // create the Datastore connecting to the default port on the local host
        final Datastore datastore = morphia.createDatastore(client, "morphia_example");
        datastore.ensureIndexes();

        final Employee elmer = new Employee("Elmer Fudd", 50000.0);
        datastore.save(elmer);

        final Employee daffy = new Employee("Daffy Duck", 40000.0);
        datastore.save(daffy);

        final Employee pepe = new Employee("Pepé Le Pew", 25000.0);
        datastore.save(pepe);

        elmer.getDirectReports().add(daffy);
        elmer.getDirectReports().add(pepe);

        datastore.save(elmer);
    }
}
