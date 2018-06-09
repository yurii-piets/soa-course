package com.soa.repository.def;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public abstract class AbstractRepository<T> implements Repository<T> {

    private final static String PERSISTENCE_UNIT_NAME = "SOA_PROJECT";

    private EntityManager entityManager;

    private Class<T> type;

    protected AbstractRepository(Class<T> type) {
        this.type = type;

        Map<String, String> env = System.getenv();
        Map<String, Object> config = new HashMap<>();
        config.put("javax.persistence.jdbc.user", env.get("PG_USER"));
        config.put("javax.persistence.jdbc.password", env.get("PG_PASSWORD"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, config);
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public List<T> findAll() {
        Entity entity = type.getAnnotation(Entity.class);
        return entityManager.createQuery("from " + entity.name()).getResultList();
    }

    @Override
    public void save(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    @Override
    public void save(Collection<T> entities) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entities.forEach(entityManager::persist);
        transaction.commit();
    }

    @Override
    public void delete(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entity);
        transaction.commit();
    }

    @Override
    public void delete(Collection<T> entities) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entities.forEach(entityManager::remove);
        transaction.commit();
    }
}
