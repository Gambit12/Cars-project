package com.labwork4.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Arkadiy Maklakov
 */
@Entity
@Table(name = "services")
public class Service implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "service_id")
    private Integer id;

    @Column(name = "service_name")
    private String name;

    public Service() {

    }

    public Service(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "\nService:" +
                "\n{ id: " + id  +
                "\nname: " + name +
                "\n}";
    }
}

