package com.manywho.microservices.reporting.controllers;

import com.manywho.microservices.reporting.managers.StatesManager;
import com.manywho.sdk.entities.run.state.State;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/states")
@Consumes(MediaType.APPLICATION_JSON)
public class StatesController {
    private StatesManager statesManager;

    @Inject
    public StatesController(StatesManager statesManager) {
        this.statesManager = statesManager;
    }

    @POST
    @Path("/")
    public void receiveState(State state) {
        statesManager.receiveState(state);
    }
}
