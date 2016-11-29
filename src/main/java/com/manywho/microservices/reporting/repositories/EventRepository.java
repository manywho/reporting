package com.manywho.microservices.reporting.repositories;

import com.manywho.microservices.reporting.entities.ApiEvent;
import com.manywho.microservices.reporting.entities.FlowEvent;
import com.manywho.microservices.reporting.entities.ServiceInvokerEvent;
import com.manywho.microservices.reporting.entities.StateEvent;
import com.manywho.microservices.reporting.entities.TenantEvent;
import com.manywho.microservices.reporting.entities.UserEvent;
import org.sql2o.Connection;

import java.util.List;

public interface EventRepository {
    void saveApiEvent(Connection connection, List<ApiEvent> events);
    void saveFlowEvent(Connection connection, List<FlowEvent> events);
    void saveServiceInvoker(Connection connection, List<ServiceInvokerEvent> events);
    void saveStateEvent(Connection connection, List<StateEvent> events);
    void saveTenantEvent(Connection connection, List<TenantEvent> events);
    void saveUserEvent(Connection connection, List<UserEvent> events);
}
