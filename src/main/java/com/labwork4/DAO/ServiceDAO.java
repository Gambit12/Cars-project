package com.labwork4.DAO;

import com.labwork4.entities.Service;

/**
 * @author Arkadiy Maklakov
 */
public class ServiceDAO extends DAOEM<Service, Integer> {

    public ServiceDAO(Class<Service> serviceClass) {
        super(serviceClass);
    }
}
