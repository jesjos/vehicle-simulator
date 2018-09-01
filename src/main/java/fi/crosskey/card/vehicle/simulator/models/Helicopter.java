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
    private HelicopterState currentState = LANDED;
    private boolean landed = true;

    public Helicopter(){}

    public Helicopter(final String name, final HelicopterState state){
        this.name = name;
        initializeState(state);
    }

    public Helicopter(final HelicopterState state){
        initializeState(state);
    }

    private void initializeState(HelicopterState state){
        if (state != this.currentState){
            this.currentState = state;
            this.landed = false;
        }

    }

    public void setState(final HelicopterState state) throws VehicleStateException {
        stateValidator(state);

    }

    private void stateValidator(HelicopterState state) throws VehicleStateException {
        if (state == this.currentState) {
            throw new VehicleStateException();

        }else{ stateChangeValidator(state); }
    }

    private void stateChangeValidator(HelicopterState state) throws VehicleStateException {
        if ((landed) &&  (state == GOING_DOWN || state == HOVERING)){
            throw new VehicleStateException();
        }else{ stateChange(state); }
    }

    private void stateChange(HelicopterState state){
        if(state == LANDED){
            this.landed = true;
            this.currentState = state;
        }else{
            this.landed = false;
            this.currentState = state;
        }
    }

    public HelicopterState getCurrentState() {
        return currentState;
    }
}
