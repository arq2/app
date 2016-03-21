package ar.edu.unq.arq2;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;

import static org.junit.Assert.assertEquals;

public class CuentasResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(CuentasResource.class);
    }

    @Test
    public void testGetUltimaCuenta() {
        final CuentaBean response = target().path("cuentas/ultima").request().get(CuentaBean.class);

        CuentaBean cuenta = new CuentaBean(456, "cosme fulanito", 100L);
        assertEquals(cuenta, response);
    }
}
