package com.manywho.microservices.reporting.entities;

import java.util.UUID;

public class FlowEvent extends UserEvent {
    private UUID flow;
    private UUID flowVersion;

    public UUID getFlow() {
        return flow;
    }

    public UUID getFlowVersion() {
        return flowVersion;
    }
}
