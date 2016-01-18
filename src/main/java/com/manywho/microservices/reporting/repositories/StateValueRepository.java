package com.manywho.microservices.reporting.repositories;

import com.manywho.sdk.entities.run.state.StateValue;

public interface StateValueRepository {
    boolean exists(String stateId, String elementId);

    void save(String stateId, StateValue stateValue);

    void update(String stateId, StateValue stateValue);
}
