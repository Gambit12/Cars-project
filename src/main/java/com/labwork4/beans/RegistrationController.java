package com.labwork4.beans;

import com.labwork4.DAO.RegistrationDAO;
import com.labwork4.entities.Registration;

import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * @author Arkadiy Maklakov
 */
@ManagedBean
public class RegistrationController {

    private RegistrationDAO registrationDAO;
    private List<Registration> registrations;

    public RegistrationController() {
        registrationDAO = new RegistrationDAO(Registration.class);
        registrations = registrationDAO.readAll();
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }
}
