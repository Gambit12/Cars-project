package com.labwork4.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Arkadiy Maklakov
 */
@Entity
@Table(name = "owners")
public class Owner implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @OneToMany(mappedBy = "owner")
    private List<Car> cars;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    public Owner() {

    }

    public Owner(Integer id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Owner:" +
                "\n{Id: " + id +
                "\nFirst name: " + firstName +
                "\nLast name: " + lastName + "}\n";
    }


}
