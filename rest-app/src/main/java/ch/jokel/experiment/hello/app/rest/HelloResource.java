package ch.jokel.experiment.hello.app.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {

    @GET
    public Response hello() {
        return Response.ok("Hello World, how are you today?").build();
    }
}
