package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import io.quarkus.logging.Log;


public class DbFactory {


    public static DbInterface getDbInterface(String dbType) {
        Log.info("dbType: " + dbType);
        if (dbType.equals("mongo")) {
            return new MongoImple();
        } else if (dbType.equals("couchbase")) {
            return new CouchbaseImple();
        } else {
            return null;
        }
    }
    
}
