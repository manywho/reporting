package com.manywho.microservices.reporting.repositories;

import com.manywho.microservices.reporting.entities.ApiEvent;
import com.manywho.microservices.reporting.entities.FlowEvent;
import com.manywho.microservices.reporting.entities.ServiceInvokerEvent;
import com.manywho.microservices.reporting.entities.StateEvent;
import com.manywho.microservices.reporting.entities.TenantEvent;
import com.manywho.microservices.reporting.entities.UserEvent;
import org.sql2o.Connection;
import org.sql2o.Query;

import java.util.List;

public class EventRepositoryPostgres implements EventRepository {
    @Override
    public void saveApiEvent(Connection connection, List<ApiEvent> events) {
        final String sql = "INSERT INTO events_api " +
                "(id, type, occurred_at, uri, data, ip_address, tenant_id, method, size, duration) " +
                "VALUES " +
                "(:id, :type, :occurredAt, :uri, :data::jsonb, :ipAddress::inet, :tenant, :method, :size, :duration)";

        Query query = connection.createQuery(sql);

        for (ApiEvent event : events) {
            query.bind(event)
                    .addToBatch();
        }

        query.executeBatch();
    }

    @Override
    public void saveFlowEvent(Connection connection, List<FlowEvent> events) {
        final String sql = "INSERT INTO events_flow " +
                "(id, type, occurred_at, tenant_id, user_id, flow_id, flow_version_id, data) " +
                "VALUES " +
                "(:id, :type, :occurredAt, :tenant, :user, :flow, :flowVersion, :data::jsonb)";

        Query query = connection.createQuery(sql);

        for (FlowEvent event : events) {
            query.bind(event)
                    .addToBatch();
        }

        query.executeBatch();
    }

    @Override
    public void saveServiceInvoker(Connection connection, List<ServiceInvokerEvent> events) {
        final String sql = "INSERT INTO events_serviceinvoker " +
                "(id, type, occurred_at, request_id, tenant_id, user_id, flow_id, flow_version_id, state_id, uri, data, service_uri, endpoint, service_id, size, duration) " +
                "VALUES " +
                "(:id, :type, :occurredAt, :request, :tenant, :user, :flow, :flowVersion, :state, :uri, :data::jsonb, :serviceUri, :endpoint, :service, :size, :duration)";

        Query query = connection.createQuery(sql);

        for (ServiceInvokerEvent event : events) {
            query.bind(event)
                    .addToBatch();
        }

        query.executeBatch();
    }

    @Override
    public void saveStateEvent(Connection connection, List<StateEvent> events) {
        final String sql = "INSERT INTO events_state " +
                "(id, type, occurred_at, tenant_id, user_id, flow_id, flow_version_id, state_id, data) " +
                "VALUES " +
                "(:id, :type, :occurredAt, :tenant, :user, :flow, :flowVersion, :state, :data::jsonb)";

        Query query = connection.createQuery(sql);

        for (StateEvent event : events) {
            query.bind(event)
                    .addToBatch();
        }

        query.executeBatch();
    }

    @Override
    public void saveTenantEvent(Connection connection, List<TenantEvent> events) {
        final String sql = "INSERT INTO events_tenant " +
                "(id, type, occurred_at, tenant_id, data) " +
                "VALUES " +
                "(:id, :type, :occurredAt, :tenant, :data::jsonb)";

        Query query = connection.createQuery(sql);

        for (TenantEvent event : events) {
            query.bind(event)
                    .addToBatch();
        }

        query.executeBatch();
    }

    @Override
    public void saveUserEvent(Connection connection, List<UserEvent> events) {
        final String sql = "INSERT INTO events_user " +
                "(id, type, occurred_at, tenant_id, user_id, data) " +
                "VALUES " +
                "(:id, :type, :occurredAt, :tenant, :user, :data::jsonb)";

        Query query = connection.createQuery(sql);

        for (UserEvent event : events) {
            query.bind(event)
                    .addToBatch();
        }

        query.executeBatch();
    }
}
