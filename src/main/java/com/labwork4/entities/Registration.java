package com.labwork4.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 *@author Arkadiy Maklakov
 */
@Entity
@Table(name = "registrations")
public class Registration implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "registration_id")
    private Integer id;

    @Column(name = "serial_number", unique = true)
    private String serial_number;

    public Registration() {

    }

    public Registration(Integer id, String serial_number) {
        this.id = id;
        this.serial_number = serial_number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    @Override
    public String toString() {
        return "Registration :" +
                "\n{Id: " + id +
                "\nSerial Number: " + serial_number +
                "}\n";
    }

}
