package com.manywho.microservices.reporting.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manywho.microservices.reporting.managers.EventsManager;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/events")
@Consumes(MediaType.APPLICATION_JSON)
public class EventsController {
    private final EventsManager manager;

    @Inject
    public EventsController(EventsManager manager) {
        this.manager = manager;
    }

    @POST
    @Path("/")
    public void receiveEvents(List<ObjectNode> events) {
        manager.receiveEvents(events);
    }
}
