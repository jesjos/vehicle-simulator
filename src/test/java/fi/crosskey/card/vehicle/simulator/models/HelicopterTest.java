package fi.crosskey.card.vehicle.simulator.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelicopterTest {
    private Helicopter vehicle;
    @Test
    public void newVehicleIsLanded() {
        vehicle = new Helicopter();
        assertThat(vehicle.getCurrentState(), is(HelicopterState.LANDED));
    }

    @Test(expected = VehicleStateException.class)
    public void landedVehicleCannotBeLanded() throws VehicleStateException {
        vehicle = new Helicopter();
        vehicle.setState(HelicopterState.LANDED);
    }

    @Test(expected = VehicleStateException.class)
    public void hovereringVehicleCannotHover() throws VehicleStateException {
        vehicle = new Helicopter();
        vehicle.setState(HelicopterState.HOVERING);
        vehicle.setState(HelicopterState.HOVERING);
    }

    @Test(expected = VehicleStateException.class)
    public void landedVehicleCannotHover() throws VehicleStateException {
        vehicle = new Helicopter();
        vehicle.setState(HelicopterState.HOVERING);
    }

    @Test(expected = VehicleStateException.class)
    public void landedVehicleCannotGoDown() throws VehicleStateException {
        vehicle = new Helicopter();
        vehicle.setState(HelicopterState.GOING_DOWN);
    }

    @Test
    public void landedVehicleCanGoUp() throws VehicleStateException {
        vehicle = new Helicopter();
        vehicle.setState(HelicopterState.GOING_UP);
    }

    @Test
    public void hooveringVehicleCanLand() throws VehicleStateException {
        vehicle = new Helicopter(HelicopterState.HOVERING);
        vehicle.setState(HelicopterState.LANDED);
    }

    @Test
    public void goingDownVehicleCanGoUp() throws VehicleStateException {
        vehicle = new Helicopter(HelicopterState.GOING_UP);
        vehicle.setState(HelicopterState.GOING_DOWN);
    }
}
