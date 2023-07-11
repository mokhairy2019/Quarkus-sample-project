package org.acme;
import com.couchbase.client.java.json.*;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Named;


@Path("/hello")
@ApplicationScoped  
public class MainResource {

    private DbInterface dbInterface;
    private static Integer key = 0;

    @Inject
    public MainResource(DbInterface dbInterface) {
        this.dbInterface = dbInterface;
    }

    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void hello() {
        key++;
        dbInterface.store( Integer.toString(key) , JsonObject.create().put("name", "mike"));
    }
}
