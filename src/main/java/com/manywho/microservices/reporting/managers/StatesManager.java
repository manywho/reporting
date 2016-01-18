package com.manywho.microservices.reporting.managers;

import com.manywho.microservices.reporting.services.StateService;
import com.manywho.microservices.reporting.services.StateValueService;
import com.manywho.sdk.entities.run.state.State;

import javax.inject.Inject;

public class StatesManager {
    private StateService stateService;
    private StateValueService stateValueService;

    @Inject
    public StatesManager(StateService stateService, StateValueService stateValueService) {
        this.stateService = stateService;
        this.stateValueService = stateValueService;
    }

    public void receiveState(State state) {
        // Check if the state already exists in the database, and if it does then update it
        if (stateService.doesStateExist(state.getId())) {
            stateService.updateState(state);
        } else {
            // Otherwise, create a new state in the database
            stateService.insertState(state);
        }

        // Finally, save all the values (if there are any)
        if (state.hasValues()) {
            stateValueService.saveValues(state.getId(), state.getValues());
        }
    }
}
