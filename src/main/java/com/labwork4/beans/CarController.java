package com.labwork4.beans;

import com.labwork4.DAO.CarDAO;
import com.labwork4.DAO.RegistrationDAO;
import com.labwork4.entities.Car;
import com.labwork4.entities.Owner;
import com.labwork4.entities.Registration;
import com.labwork4.entities.Service;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.List;

/**
 * @author Arkadiy Maklakov
 */
@ManagedBean
public class CarController implements Converter {

    private static final Logger logger = Logger.getLogger(CarController.class);
    private CarDAO carDAO;
    private List<Car> cars;
    private Owner owner;
    private Car car;
    private Registration registration;
    private RegistrationDAO registrationDAO;
    private List<Service> services;

    public CarController() {
        carDAO = new CarDAO(Car.class);
        registrationDAO = new RegistrationDAO(Registration.class);
        cars = carDAO.readAll();
        registration = new Registration();
        car = new Car();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }


    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void add() {
        car.setRegistration(registration);
        car.setOwner(owner);
        registrationDAO.create(registration);
        logger.info("New registration was added successfully!");
        carDAO.create(car);
        logger.info("New car was added successfully!");
    }

    public void update() {
        car.setRegistration(registration);
        car.setOwner(owner);
        car.setStations(services);
        registrationDAO.create(registration);
        carDAO.update(car);
        logger.info("Car was updated successfully!");
    }

    public void delete() {
        carDAO.delete(car);
        logger.info("Car was deleted successfully!");
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return carDAO.read(Integer.parseInt(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return ((Car)o).getId().toString();
    }
}
