/*
 * Copyright (c) Crosskey Banking Solutions. All rights reserved.
 */
package fi.crosskey.card.vehicle.simulator.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CarState state = CarState.STOPPED;

    public Car() {}

    public Car(final String name, final CarState state) {
        this.name = name;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public CarState getState() {
        return state;
    }

    public void setState(final CarState state) {
        this.state = state;
    }
}
