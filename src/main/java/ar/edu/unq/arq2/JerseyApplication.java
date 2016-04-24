package ar.edu.unq.arq2;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api/*")
public class JerseyApplication extends ResourceConfig {
    public JerseyApplication() {
        packages(true, "ar.edu.unq.arq2.api");
    }
}
