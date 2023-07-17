package org.acme;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.couchbase.client.java.json.*;

import io.quarkus.logging.Log;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/hello")
@ApplicationScoped  
public class MainResource {


    private DbInterface dbInterface;


    @Inject
    public MainResource(@ConfigProperty(name = "db.type") String dbType) {
        Log.info("MainResource constructor" + dbType);
        this.dbInterface = DbFactory.getDbInterface(dbType);
    }

    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
       return dbInterface.greet();
    }
}
