package com.manywho.microservices.reporting.services;

import com.manywho.microservices.reporting.repositories.StateValueRepository;
import com.manywho.sdk.entities.run.state.StateValue;

import javax.inject.Inject;
import java.util.List;

public class StateValueService {
    private StateValueRepository stateValueRepository;

    @Inject
    public StateValueService(StateValueRepository stateValueRepository) {
        this.stateValueRepository = stateValueRepository;
    }

    public void saveValues(String stateId, List<StateValue> values) {
        // Go through and save all the values, except those without a developer name (as they're old internal values)
        values.stream()
                .filter(value -> value.getValueElementDeveloperName() != null)
                .forEach(value -> {
                    // If the value already exists, then update it
                    if (stateValueRepository.exists(stateId, value.getValueElementId())) {
                        stateValueRepository.update(stateId, value);
                    } else {
                        // Otherwise just insert a new value
                        stateValueRepository.save(stateId, value);
                    }
                });
    }
}
