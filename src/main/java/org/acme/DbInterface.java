package org.acme;

import com.couchbase.client.java.json.*;

public interface DbInterface {
    
    public abstract void store(String key, JsonObject value);
    public abstract String greet();
}