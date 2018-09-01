package fi.crosskey.card.vehicle.simulator.models;

import javax.persistence.*;

@Entity
public class Helicopter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private HelicopterState currentState = HelicopterState.LANDED;

    public Helicopter(){}

    public Helicopter(final String name, final HelicopterState state){
        this.name = name;
        this.currentState = state;
    }
}
