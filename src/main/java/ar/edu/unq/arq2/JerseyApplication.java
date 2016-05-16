package ar.edu.unq.arq2;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api/*")
public class JerseyApplication extends ResourceConfig {
    public JerseyApplication() {
        packages(true, "ar.edu.unq.arq2.api");

        property(ServerProperties.LOCATION_HEADER_RELATIVE_URI_RESOLUTION_DISABLED, true);
    }
}
