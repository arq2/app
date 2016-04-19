package ar.edu.unq.arq2.heroku;

import ar.edu.unq.arq2.morphia.MorphiaConfig;
import ar.edu.unq.arq2.util.ConfigVar;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {

    private static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) throws Exception {
        log.info("iniciando la aplicación");
        ConfigVar.initialize();
        log.info("inicializando las variables de entorno");
        startDatabaseClient();
        log.info("lanzando la conexión a la base de datos");
        startWebServer();
        log.info("lanzando el web server");
    }

    private static void startDatabaseClient() {
        MorphiaConfig.initialize(ConfigVar.get("MONGO_URI"));
    }

    private static void startWebServer() throws Exception {
        // The port that we should run on can be set into an environment variable
        // Look for that variable and default to 8080 if it isn't there.
        String webPort = ConfigVar.get("PORT");

        final Server server = new Server(Integer.valueOf(webPort));
        final WebAppContext root = new WebAppContext();

        root.setContextPath("/");
        // Parent loader priority is a class loader setting that Jetty accepts.
        // By default Jetty will behave like most web containers in that it will
        // allow your application to replace non-server libraries that are part of the
        // container. Setting parent loader priority to true changes this behavior.
        // Read more here: http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading
        root.setParentLoaderPriority(true);

        final String webappDirLocation = "src/main/webapp/";
        root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);

        server.setHandler(root);

        server.start();
        server.join();
    }
}
