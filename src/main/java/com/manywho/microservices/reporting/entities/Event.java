package com.manywho.microservices.reporting.entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.OffsetDateTime;
import java.util.UUID;

public abstract class Event {
    private UUID id;
    private OffsetDateTime occurredAt;
    private String type;
    private String data;

    public UUID getId() {
        return id;
    }

    public OffsetDateTime getOccurredAt() {
        return occurredAt;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    @JsonSetter
    public void setData(ObjectNode data) {
        if (data != null) {
            this.data = data.toString();
        }
    }
}
