package fi.crosskey.card.vehicle.simulator.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CarTest {
    private Car vehicle;
    @Test
    public void newVehicleIsStopped() {
        vehicle = new Car();
        assertThat(vehicle.getState(), is(CarState.STOPPED));
    }

    @Test(expected = VehicleStateException.class)
    public void stoppedVehicleCannotBeStopped() {
        vehicle = new Car();
        vehicle.setState(CarState.STOPPED);
    }

    @Test(expected = VehicleStateException.class)
    public void startedVehicleCannotBeStarted() {
        vehicle = new Car();
        vehicle.setState(CarState.STARTED);
        vehicle.setState(CarState.STARTED);
    }
}