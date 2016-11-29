package com.manywho.microservices.reporting.managers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import com.manywho.microservices.reporting.entities.ApiEvent;
import com.manywho.microservices.reporting.entities.FlowEvent;
import com.manywho.microservices.reporting.entities.ServiceInvokerEvent;
import com.manywho.microservices.reporting.entities.StateEvent;
import com.manywho.microservices.reporting.entities.TenantEvent;
import com.manywho.microservices.reporting.entities.UserEvent;
import com.manywho.microservices.reporting.repositories.EventRepository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

public class EventsManager {
    private final Sql2o sql2o;
    private final ObjectMapper objectMapper;
    private final EventRepository eventRepository;

    @Inject
    public EventsManager(Sql2o sql2o, ObjectMapper objectMapper, EventRepository eventRepository) {
        this.sql2o = sql2o;
        this.objectMapper = objectMapper;
        this.eventRepository = eventRepository;
    }

    public void receiveEvents(List<ObjectNode> events) {
        // Start transaction
        try (Connection connection = sql2o.beginTransaction()) {
            // Create some empty lists so we can batch save a bunch of each type of event
            List<ApiEvent> apiEvents = Lists.newArrayList();
            List<FlowEvent> flowEvents = Lists.newArrayList();
            List<ServiceInvokerEvent> serviceInvokerEvents = Lists.newArrayList();
            List<StateEvent> stateEvents = Lists.newArrayList();
            List<TenantEvent> tenantEvents = Lists.newArrayList();
            List<UserEvent> userEvents = Lists.newArrayList();

            for (ObjectNode event : events) {
                String type = event.get("type").asText();

                // Split and switch by the event primary type
                switch (type.split("\\.")[0]) {
                    case "api":
                        apiEvents.add(objectMapper.treeToValue(event, ApiEvent.class));
                        break;
                    case "flow":
                        flowEvents.add(objectMapper.treeToValue(event, FlowEvent.class));
                        break;
                    case "serviceinvoker":
                        serviceInvokerEvents.add(objectMapper.treeToValue(event, ServiceInvokerEvent.class));
                        break;
                    case "state":
                        stateEvents.add(objectMapper.treeToValue(event, StateEvent.class));
                        break;
                    case "tenant":
                        tenantEvents.add(objectMapper.treeToValue(event, TenantEvent.class));
                        break;
                    case "user":
                        userEvents.add(objectMapper.treeToValue(event, UserEvent.class));
                        break;
                }
            }

            // Batch save the list of each type of event
            eventRepository.saveApiEvent(connection, apiEvents);
            eventRepository.saveFlowEvent(connection, flowEvents);
            eventRepository.saveServiceInvoker(connection, serviceInvokerEvents);
            eventRepository.saveStateEvent(connection, stateEvents);
            eventRepository.saveTenantEvent(connection, tenantEvents);
            eventRepository.saveUserEvent(connection, userEvents);

            // Commit the transaction to save all the events
            connection.commit();
        } catch (IOException e) {
            throw new RuntimeException("Unable to deserialize the incoming event JSON", e);
        }
    }
}
