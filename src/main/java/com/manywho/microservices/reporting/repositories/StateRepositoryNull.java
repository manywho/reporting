package com.manywho.microservices.reporting.repositories;

import com.manywho.sdk.entities.run.state.State;

public class StateRepositoryNull implements StateRepository {
    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public void save(State state) {

    }

    @Override
    public void update(String id, State state) {

    }
}
