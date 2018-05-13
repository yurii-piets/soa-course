package com.soa.repository.def;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRepository<T> implements Repository<T>{

    protected final EntityManagerFactory factory;

    private final Class<T> type;

    public AbstractRepository(Class<T> type) {
        this.factory = getEntityManagerFactory();
        this.type = type;
    }

    private EntityManagerFactory getEntityManagerFactory() {
        Map<String, String> env = System.getenv();
        Map<String, Object> config = new HashMap<>();
        config.put("javax.persistence.jdbc.user", env.get("PG_USER"));
        config.put("javax.persistence.jdbc.password", env.get("PG_PASSWORD"));

        return Persistence.createEntityManagerFactory("SOA_LAB8", config);
    }

    @Override
    public Collection<T> findAll() {
        EntityManager em = factory.createEntityManager();
        return em.createQuery("from " + type.getSimpleName()).getResultList();
    }

    @Override
    public Collection<T> findByCriteria() {
        return null;
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        EntityManager em = factory.createEntityManager();
        return em.getCriteriaBuilder();
    }

    @Override
    public void save(T entity) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void save(Collection<T> entities) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        entities.forEach(em::persist);
        transaction.commit();
    }

    @Override
    public void delete(T entity) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(entity);
        transaction.commit();
    }

    @Override
    public void delete(Collection<T> entities) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        entities.forEach(em::remove);
        transaction.commit();
    }
}
