package ar.edu.unq.arq2.heroku;

import ar.edu.unq.arq2.JerseyApplication;
import ar.edu.unq.arq2.util.Environment;
import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import org.glassfish.jersey.servlet.ServletContainer;
import org.jboss.weld.environment.servlet.Listener;

import javax.servlet.ServletException;

import static io.undertow.servlet.Servlets.listener;
import static io.undertow.servlet.Servlets.servlet;

public class Main {
    private static Undertow server;

    public static void main(String[] args) throws ServletException {
        startContainer();
    }

    public static void stopContainer(){
        server.stop();
    }

    public static void startContainer() throws ServletException {
        int port = Environment.portNumber();
        DeploymentInfo servletBuilder = Servlets.deployment();

        servletBuilder
                .setClassLoader(Main.class.getClassLoader())
                .setContextPath("/")
                .setDeploymentName("arq2.war")
                .addListeners(listener(Listener.class))
                .addServlets(servlet("jerseyServlet", ServletContainer.class)
                        .setLoadOnStartup(1)
                        .addInitParam("javax.ws.rs.Application", JerseyApplication.class.getName())
                        .addMapping("/api/*"));

        DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
        manager.deploy();

        server =
                Undertow
                        .builder()
                        .addHttpListener(port, Environment.host())
                        .setHandler(manager.start())
                        .build();

        server.start();
    }
}
