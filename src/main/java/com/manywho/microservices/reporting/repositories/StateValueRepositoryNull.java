package com.manywho.microservices.reporting.repositories;

import com.manywho.sdk.entities.run.state.StateValue;

public class StateValueRepositoryNull implements StateValueRepository {
    @Override
    public boolean exists(String stateId, String elementId) {
        return false;
    }

    @Override
    public void save(String stateId, StateValue stateValue) {

    }

    @Override
    public void update(String stateId, StateValue stateValue) {

    }
}
