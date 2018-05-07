package com.soa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class PersistenceManager {

    private final EntityManagerFactory factory;

    public PersistenceManager() {
        this.factory = getEntityManagerFactory();
    }

    private EntityManagerFactory getEntityManagerFactory() {
        Map<String, String> env = System.getenv();
        Map<String, Object> config = new HashMap<>();
        config.put("javax.persistence.jdbc.user", env.get("PG_USER"));
        config.put("javax.persistence.jdbc.password", env.get("PG_PASSWORD"));

        return Persistence.createEntityManagerFactory("SOA_LAB8", config);
    }
}
