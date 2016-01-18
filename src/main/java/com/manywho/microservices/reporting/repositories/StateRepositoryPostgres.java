package com.manywho.microservices.reporting.repositories;

import com.manywho.sdk.entities.run.state.State;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import javax.inject.Inject;
import java.util.UUID;

public class StateRepositoryPostgres implements StateRepository {
    private Sql2o sql2o;

    @Inject
    public StateRepositoryPostgres(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public boolean exists(String id) {
        final String sql = "SELECT EXISTS(SELECT 1 FROM States WHERE Id = :id)";

        try (Connection connection = sql2o.open()) {
            return connection.createQuery(sql)
                    .addParameter("id", UUID.fromString(id))
                    .executeScalar(boolean.class);
        }
    }

    @Override
    public void save(State state) {
        final String sql = "INSERT INTO States (Id, CurrentMapElementId, CurrentMapElementName, FlowId, FlowName, FlowVersionId, " +
                "Done, TenantId, CurrentUserEmail, DateModified) VALUES (:id, :elementId, :elementName, :flowId, " +
                ":flowName, :flowVersionId, :done, :tenantId, :userEmail, :dateModified)";

        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("id", UUID.fromString(state.getId()))
                    .addParameter("elementId", UUID.fromString(state.getCurrentMapElementId()))
                    .addParameter("elementName", state.getCurrentMapElementDeveloperName())
                    .addParameter("flowId", UUID.fromString(state.getCurrentFlowId().getId()))
                    .addParameter("flowName", state.getCurrentFlowDeveloperName())
                    .addParameter("flowVersionId", UUID.fromString(state.getCurrentFlowId().getVersionId()))
                    .addParameter("done", state.isDone())
                    .addParameter("tenantId", UUID.fromString(state.getManyWhoTenantId()))
                    .addParameter("userEmail", state.getCurrentRunningUserEmail())
                    .addParameter("dateModified", state.getDateModified())
                    .executeUpdate();

        }
    }

    @Override
    public void update(String id, State state) {
        final String sql = "UPDATE States SET CurrentMapElementId = :elementId, CurrentMapElementName = :elementName," +
                " Done = :done, CurrentUserEmail = :userEmail, DateModified = :dateModified WHERE Id = :id";

        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("id", UUID.fromString(state.getId()))
                    .addParameter("elementId", UUID.fromString(state.getCurrentMapElementId()))
                    .addParameter("elementName", state.getCurrentMapElementDeveloperName())
                    .addParameter("done", state.isDone())
                    .addParameter("userEmail", state.getCurrentRunningUserEmail())
                    .addParameter("dateModified", state.getDateModified())
                    .executeUpdate();

        }
    }
}
