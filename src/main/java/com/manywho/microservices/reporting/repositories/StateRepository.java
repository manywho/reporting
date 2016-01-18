package com.manywho.microservices.reporting.repositories;

import com.manywho.sdk.entities.run.state.State;

public interface StateRepository {
    boolean exists(String id);

    void save(State state);

    void update(String id, State state);
}
