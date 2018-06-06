package com.soa.database.service;

import com.soa.database.domain.UserData;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

@Stateless
@Local(DataAccessService.class)
public class DataAccessServiceImpl implements DataAccessService {

    private final static String PERSISTENCE_UNIT_NAME = "SOA_PROJECT";

    private EntityManager entityManager;

    @PostConstruct
    private void postConstruct(){
        Map<String, String> env = System.getenv();
        Map<String, Object> config = new HashMap<>();
        config.put("javax.persistence.jdbc.user", env.get("PG_USER"));
        config.put("javax.persistence.jdbc.password", env.get("PG_PASSWORD"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, config);
        entityManager = factory.createEntityManager();
    }


    @Override
    public void save(UserData user) {
        EntityTransaction t1 = entityManager.getTransaction();
        t1.begin();
        entityManager.persist(user);
        t1.commit();
    }
}
