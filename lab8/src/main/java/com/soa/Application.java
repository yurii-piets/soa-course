package com.soa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public void run() {
        Map<String, String> env = System.getenv();
        Map<String, Object> config = new HashMap<>();
        config.put("javax.persistence.jdbc.user", env.get("PG_USER"));
        config.put("javax.persistence.jdbc.password", env.get("PG_PASSWORD"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SOA_LAB8", config);
        EntityManager em = factory.createEntityManager();
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
