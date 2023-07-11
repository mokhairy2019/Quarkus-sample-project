package org.acme;

import com.couchbase.client.java.json.*;
import com.couchbase.client.java.*;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class CouchbaseImple implements DbInterface {

    static String connectionString = "couchbase://127.0.0.1";
    static String username = "Administrator";
    static String password = "password";
    static String bucketName = "test";

    private final Cluster cluster;
    private final Bucket bucket;
    private final Collection collection;

    CouchbaseImple() {
        this.cluster = Cluster.connect(connectionString, username, password);
        this.bucket = cluster.bucket(bucketName);
        bucket.waitUntilReady(java.time.Duration.ofSeconds(10));
        this.collection = bucket.defaultCollection();

    }

    @Override
    public void store(String key, JsonObject value) {
        collection.upsert(key, value);
    }

}
