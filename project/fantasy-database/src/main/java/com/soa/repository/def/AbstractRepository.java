package com.soa.repository.def;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractRepository<T> implements Repository<T> {

    private final static String PERSISTENCE_UNIT_NAME = "SOA_PROJECT";

    protected EntityManager entityManager;

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
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        Entity entity = type.getAnnotation(Entity.class);
        return entityManager.createQuery("from " + entity.name()).getResultList();
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(type, id);
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
    public void update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
    }

    @Override
    public void delete(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entity);
        transaction.commit();
    }

    public void deleteById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        T entity = findById(id);
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
