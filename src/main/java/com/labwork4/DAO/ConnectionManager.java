package com.labwork4.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Arkadiy Maklakov
 */
public class ConnectionManager {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager = null;

    private ConnectionManager() {

    }

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null || entityManager == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("persist");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public static void close() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

}
