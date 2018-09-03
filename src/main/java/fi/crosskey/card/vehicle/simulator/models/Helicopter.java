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
    private boolean landed;

    public Helicopter(){
        stateChange(LANDED);
    }

    public Helicopter(final String name, final HelicopterState state){
        this.name = name;
        stateChange(state);
    }

    public Helicopter(final String name){
        this.name = name;
        stateChange(LANDED);
    }

    public Helicopter(final HelicopterState state){
        stateChange(state);
    }


    public void setCurrentState(final HelicopterState currentState) throws VehicleStateException {
        stateValidator(currentState);

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
