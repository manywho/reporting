package com.manywho.microservices.reporting.services;

import com.manywho.microservices.reporting.repositories.StateRepository;
import com.manywho.sdk.entities.run.state.State;

import javax.inject.Inject;

public class StateService {
    private StateRepository stateRepository;

    @Inject
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public boolean doesStateExist(String id) {
        return stateRepository.exists(id);
    }

    public void insertState(State state) {
        stateRepository.save(state);
    }

    public void updateState(State state) {
        stateRepository.update(state.getId(), state);
    }
}
