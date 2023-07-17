package org.acme;

import java.util.Collections;
import java.util.Map;

import io.quarkus.test.junit.QuarkusTestProfile;

public class MongoProfile implements QuarkusTestProfile {

     @Override
    public Map<String, String> getConfigOverrides() {
        return Collections.singletonMap("db.type", "mongo");
    }
    
}
