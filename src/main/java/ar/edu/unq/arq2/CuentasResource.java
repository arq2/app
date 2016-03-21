package ar.edu.unq.arq2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cuentas")
public class CuentasResource {

    private static Logger log = LogManager.getRootLogger();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ultima")
    public CuentaBean ultimaCuenta() {
        log.info("en /cuentas/ultima");
        return new CuentaBean(456, "cosme fulanito", 100L);
    }
}
