/*
 * Copyright (c) Crosskey Banking Solutions. All rights reserved.
 */
package fi.crosskey.card.vehicle.simulator.repositories;

import org.springframework.data.repository.CrudRepository;

import fi.crosskey.card.vehicle.simulator.models.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
}
