package com.labwork4.DAO;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

/**
 * @author Arkadiy Maklakov
 */
public abstract class DAOEM <T, K  extends Serializable> implements DAO<T, K> {
    private EntityManager entityManager;
    private final Class<T> tClass;
    private final static Logger logger = Logger.getLogger(DAOEM.class);


    public DAOEM(Class<T> tClass) {
        entityManager = ConnectionManager.getEntityManager();
        this.tClass = tClass;
    }

    public void create(T obj) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(obj);
            entityTransaction.commit();
        }
        catch (PersistenceException pe) {
            //entityTransaction.rollback();
            logger.error("Failed to create the object! " + pe.getMessage());
        }
    }

    public List<T> readAll() {
        List<T> tList = null;
        try {
            tList = entityManager.createQuery("Select t from " +
                    tClass.getSimpleName() + " t", tClass).getResultList();
        }
        catch (IllegalArgumentException iae) {
            logger.error("Failed to get  the list of objects! " + iae.getMessage());
        }
        return tList;
    }

    public void update(T obj) {
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(obj);
            entityTransaction.commit();
        }
        catch (PersistenceException pe) {
            entityTransaction.rollback();
            logger.error("Failed to update the the object! " + pe.getMessage());
        }
    }

    public T read(K key) {
        T obj = null;
        try {
            obj = entityManager.find(tClass, key);
        }
        catch (IllegalArgumentException iae) {
            logger.error("Failed to get the object by primary key! " + iae.getMessage());
        }
        return obj;
    }

    public void delete(T obj) {
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.remove(obj);
            entityTransaction.commit();
        }
        catch (PersistenceException pe) {
            entityTransaction.rollback();
            logger.error("Failed to delete the object! " + pe.getMessage());
        }
    }
}
