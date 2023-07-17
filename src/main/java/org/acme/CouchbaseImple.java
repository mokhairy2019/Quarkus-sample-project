package org.acme;

import com.couchbase.client.java.json.*;

import io.quarkus.logging.Log;

import com.couchbase.client.java.*;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
@Named("couchbase")
public class CouchbaseImple implements DbInterface {

    static String connectionString = "couchbase://127.0.0.1";
    static String username = "Administrator";
    static String password = "password";
    static String bucketName = "test";

    private final Cluster cluster;
    private final Bucket bucket;
    private final Collection collection;

    CouchbaseImple() {
        Log.info("CouchbaseImple constructor");
        this.cluster = Cluster.connect(connectionString, username, password);
        this.bucket = cluster.bucket(bucketName);
        bucket.waitUntilReady(java.time.Duration.ofSeconds(10));
        this.collection = bucket.defaultCollection();
    }

    CouchbaseImple(Cluster cluster, Bucket bucket, Collection collection) {
        Log.info("CouchbaseImple constructor");
        this.cluster = cluster;
        this.bucket = bucket;
        this.collection = collection;
    }

    @Override
    public void store(String key, JsonObject value) {
        Log.info("CouchbaseImple.store");
        collection.upsert(key, value);
    }

    @Override
    public String greet() {
        return "Hello from CouchbaseImple";
    }

}
