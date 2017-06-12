package com.labwork4.DAO;

import com.labwork4.entities.Registration;

/**
 * @author Arkadiy Maklakov
 */
public class RegistrationDAO extends DAOEM<Registration, Integer>{

    public RegistrationDAO(Class<Registration> registrationClass) {
        super(registrationClass);
    }
}
