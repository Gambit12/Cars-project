package com.labwork4;

import com.labwork4.DAO.CarDAO;
import com.labwork4.DAO.OwnerDAO;
import com.labwork4.DAO.RegistrationDAO;
import com.labwork4.DAO.ServiceDAO;
import com.labwork4.entities.Car;
import com.labwork4.entities.Owner;
import com.labwork4.entities.Registration;
import com.labwork4.entities.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Arkadiy Maklakov
 */
public class Main {
    public static void main(String[] args) {
        Owner owner_1 = new Owner(null, "Arkadiy", "Maklakov");
        Owner owner_2 = new Owner(null, "Peter", "Norson");

        OwnerDAO ownerDAO = new OwnerDAO(Owner.class);
        ownerDAO.create(owner_1);
        ownerDAO.create(owner_2);
        Registration registration_1 = new Registration(null, "AA9555BB");
        Registration registration_2 = new Registration(null, "AB2710KB");

        RegistrationDAO registrationDAO = new RegistrationDAO(Registration.class);
        registrationDAO.create(registration_1);
        registrationDAO.create(registration_2);

        Service service_1= new Service("Service Mercedes");
        Service service_2= new Service("Service BMW");
        Service service_3= new Service("Service 4All");

        ServiceDAO serviceDAO = new ServiceDAO(Service.class);
        serviceDAO.create(service_1);
        serviceDAO.create(service_2);
        serviceDAO.create(service_3);

        List<Service> services1 = new LinkedList<>();
        services1.add(service_1);
        services1.add(service_2);
        List<Service> services2 = new LinkedList<>();

        Car car1 = new Car(null, registration_1, owner_1,"BMW X5", "Germany", services1);
        services2.add(service_1);
        services2.add(service_3);

        Car car2 = new Car(null, registration_2, owner_1,"Mercedes AMG", "Germany", services2);
        CarDAO carDAO = new CarDAO(Car.class);
        carDAO.create(car1);
        carDAO.create(car2);

    }
}
