package org.acme;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import io.quarkus.logging.Log;

import com.couchbase.client.java.json.*;
import com.couchbase.client.java.*;



@ApplicationScoped
@Named("mongo")
public class MongoImple implements DbInterface {

    MongoImple() {
        Log.info("MongoImple constructor");
    }

    @Override
    public void store(String key, JsonObject value) {
        Log.info("MongoImple.store");
    }

    @Override
    public String greet() {
        return "Hello from MongoImple";
    }

}
