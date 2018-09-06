package fi.crosskey.card.vehicle.simulator.models;

import javax.persistence.*;

import static fi.crosskey.card.vehicle.simulator.models.HelicopterState.*;

@Entity
public class Helicopter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private HelicopterState currentState;


    public Helicopter(){
        this.currentState = LANDED;
    }

    public Helicopter(final String name, final HelicopterState state){
        this.name = name;
        this.currentState = state;
    }

    public Helicopter(final String name){
        this.name = name;
        this.currentState = LANDED;
    }

    public Helicopter(final HelicopterState state){
        this.currentState = state;
    }


    public void setCurrentState(final HelicopterState currentState) throws VehicleStateException {
        validateState(currentState);

    }

    private void validateState(HelicopterState state) throws VehicleStateException {
        if (state == this.currentState) {
            throw new VehicleStateException();

        } else { validateStateChange(state); }
    }

    private void validateStateChange(HelicopterState state) throws VehicleStateException {
        if ((this.currentState == LANDED) &&  (state == GOING_DOWN || state == HOVERING)){
            throw new VehicleStateException();
        } else { this.currentState = state; }
    }


    public void setName(String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HelicopterState getCurrentState() {
        return currentState;
    }
}
