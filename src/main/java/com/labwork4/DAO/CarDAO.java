package com.labwork4.DAO;

import com.labwork4.entities.Car;

/**
 * @author Arkadiy Maklakov
 */
public class CarDAO extends DAOEM<Car, Integer> {

    public CarDAO(Class<Car> carClass) {
        super(carClass);
    }
}
