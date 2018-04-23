package com.soa;

import com.soa.domain.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        Map<String, Object> config = new HashMap<>();
        config.put("javax.persistence.jdbc.user", env.get("PG_USER"));
        config.put("javax.persistence.jdbc.password", env.get("PG_PASSWORD"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SOA_LAB7", config);
        EntityManager em = factory.createEntityManager();

        Car car = new Car();
        car.setRegisterNumber("AA1234BB");
        car.setMark("Batmobile");
        car.setModel("XX");
        car.setYearOfProduction("1939");
        car.setDescription("Does batmobile needs a description?");

        EntityTransaction t1 = em.getTransaction();
        t1.begin();
        em.persist(car);
        t1.commit();
    }
}
