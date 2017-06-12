package com.labwork4.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * @author Arkadiy Maklakov
 */
@Entity
@Table(name = "cars")
public class Car implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "car_id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registration_id")
    private Registration registration;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "country")
    private String country;

    @ManyToMany
    @JoinTable(name = "CAR_SERVICE")
    private List<Service> services;

    public Car() {
    }

    public Car(Integer id, Registration registration, Owner owner, String model, String country, List<Service> services) {
        this.id = id;
        this.registration = registration;
        this.owner = owner;
        this.model = model;
        this.country = country;
        this.services = services;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Service> getStations() {
        return services;
    }

    public void setStations(List<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        String str =  "Car:" +
                "\n{Id: " + id +
                "\nModel: " + model +
                "\nCountry: " + country +
                "\n" + registration +
                "\n" + owner +
                "\nstations:\n{";
        for (Service service: services) {
            str += "service id: " + service.getId() +
                    " service name: " + service.getName() + "\n";
        }
        str += "}\n}\n===========================\n";
        return str;
    }


}
