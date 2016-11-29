package com.manywho.microservices.reporting.entities;

import java.util.UUID;

public class StateEvent extends FlowEvent {
    private UUID state;

    public UUID getState() {
        return state;
    }
}
