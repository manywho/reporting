package com.manywho.microservices.reporting.repositories;

import com.manywho.microservices.reporting.entities.ApiEvent;
import com.manywho.microservices.reporting.entities.FlowEvent;
import com.manywho.microservices.reporting.entities.ServiceInvokerEvent;
import com.manywho.microservices.reporting.entities.StateEvent;
import com.manywho.microservices.reporting.entities.TenantEvent;
import com.manywho.microservices.reporting.entities.UserEvent;
import org.sql2o.Connection;

import java.util.List;

public class EventRepositoryNull implements EventRepository {

    @Override
    public void saveApiEvent(Connection connection, List<ApiEvent> events) {

    }

    @Override
    public void saveFlowEvent(Connection connection, List<FlowEvent> events) {

    }

    @Override
    public void saveServiceInvoker(Connection connection, List<ServiceInvokerEvent> events) {

    }

    @Override
    public void saveStateEvent(Connection connection, List<StateEvent> events) {

    }

    @Override
    public void saveTenantEvent(Connection connection, List<TenantEvent> events) {

    }

    @Override
    public void saveUserEvent(Connection connection, List<UserEvent> events) {

    }
}
