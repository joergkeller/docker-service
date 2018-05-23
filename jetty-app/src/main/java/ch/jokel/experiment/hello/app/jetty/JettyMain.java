package ch.jokel.experiment.hello.app.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * To compile this class, the following dependencies are needed:
     compile group: 'org.eclipse.jetty', name: 'jetty-server', version: '9.4.10.v20180503'
     compile group: 'org.eclipse.jetty', name: 'jetty-servlet', version: '9.4.10.v20180503'
     compile group: 'org.glassfish.jersey.core', name: 'jersey-server', version: '2.27'
     compile group: 'org.glassfish.jersey.inject', name: 'jersey-hk2', version: '2.27'
     compile group: 'org.glassfish.jersey.containers', name: 'jersey-container-servlet', version: '2.27'
 */
public class JettyMain {

    public static void main(String[] args ) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setResourceBase(System.getProperty("java.io.tmpdir"));
        server.setHandler(context);

        // Add Jersey servlet
        ServletHolder jersey = context.addServlet(ServletContainer.class, "/rest/*");
        jersey.setInitParameter("jersey.config.server.provider.packages", "ch.jokel.experiment.hello.app.rest");

        // Add default servlet
        context.addServlet(DefaultServlet.class, "/");

        try {
            server.start();
            server.join();
        } catch (Exception e){
            e.printStackTrace();
            server.stop();
            server.destroy();
        }
    }
}