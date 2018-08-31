/*
 * Copyright (c) Crosskey Banking Solutions. All rights reserved.
 */
package fi.crosskey.card.vehicle.simulator.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.crosskey.card.vehicle.simulator.models.Car;
import fi.crosskey.card.vehicle.simulator.repositories.CarRepository;

@RestController
@RequestMapping("/cars")
public class CarsController {

    private CarRepository vehiclesRepository;

    public CarsController(final CarRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Car> findAll() {
        return vehiclesRepository.findAll();
    }
}
