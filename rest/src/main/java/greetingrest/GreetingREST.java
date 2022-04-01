package greetingrest;

import greetingejb.GreetingEJB;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("message")
public class GreetingREST {

    @EJB
    private GreetingEJB greetingEJB;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(@QueryParam("name") String name) {
        return greetingEJB.getGreeting(name);
    }

}
