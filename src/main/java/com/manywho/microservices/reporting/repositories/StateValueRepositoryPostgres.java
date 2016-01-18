package com.manywho.microservices.reporting.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.microservices.reporting.exceptions.UnableToConvertStateValueToJsonException;
import com.manywho.sdk.entities.run.state.StateValue;
import com.manywho.sdk.enums.ContentType;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class StateValueRepositoryPostgres implements StateValueRepository {
    private Sql2o sql2o;
    private ObjectMapper objectMapper;

    @Inject
    public StateValueRepositoryPostgres(Sql2o sql2o, ObjectMapper objectMapper) {
        this.sql2o = sql2o;
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean exists(String stateId, String elementId) {
        final String sql = "SELECT EXISTS(SELECT 1 FROM StateValues WHERE StateId = :stateId AND ElementId = :elementId)";

        try (Connection connection = sql2o.open()) {
            return connection.createQuery(sql)
                    .addParameter("stateId", UUID.fromString(stateId))
                    .addParameter("elementId", UUID.fromString(elementId))
                    .executeScalar(boolean.class);
        }
    }

    @Override
    public void save(String stateId, StateValue stateValue) {
        final String sql = "INSERT INTO StateValues (StateId, ElementId, Key, Value) VALUES (:stateId, :elementId, :key, :value::jsonb)";

        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("stateId", UUID.fromString(stateId))
                    .addParameter("elementId", UUID.fromString(stateValue.getValueElementId()))
                    .addParameter("key", stateValue.getValueElementDeveloperName())
                    .addParameter("value", convertValueToJson(stateId, stateValue))
                    .executeUpdate();
        }
    }

    @Override
    public void update(String stateId, StateValue stateValue) {
        final String sql = "UPDATE StateValues SET Key = :key, Value = :value::jsonb WHERE StateId = :stateId AND ElementId = :elementId";

        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("stateId", UUID.fromString(stateId))
                    .addParameter("elementId", UUID.fromString(stateValue.getValueElementId()))
                    .addParameter("key", stateValue.getValueElementDeveloperName())
                    .addParameter("value", convertValueToJson(stateId, stateValue))
                    .executeUpdate();
        }
    }

    private String convertValueToJson(String stateId, StateValue value) {
        try {
            // Check if the current state value is an Object or List, and convert the object data to a JSON string if so
            if (value.getContentType() != null &&
                    (value.getContentType().equals(ContentType.List) ||
                            value.getContentType().equals(ContentType.Object))) {
                return objectMapper.writeValueAsString(value.getObjectData());
            }

            // Otherwise use the scalar content value
            return objectMapper.writeValueAsString(value.getContentValue());

        } catch (JsonProcessingException e) {
            throw new UnableToConvertStateValueToJsonException(stateId, value.getValueElementId());
        }
    }
}
