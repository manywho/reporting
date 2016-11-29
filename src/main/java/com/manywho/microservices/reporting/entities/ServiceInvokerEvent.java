package com.manywho.microservices.reporting.entities;

import java.util.UUID;

public class ServiceInvokerEvent extends StateEvent {
    private UUID flow;
    private UUID flowVersion;
    private UUID state;
    private UUID user;
    private UUID tenant;
    private UUID request;
    private String uri;
    private UUID service;
    private String serviceUri;
    private Long size;
    private Integer duration;
    private String endpoint;

    @Override
    public UUID getFlow() {
        return flow;
    }

    @Override
    public UUID getFlowVersion() {
        return flowVersion;
    }

    @Override
    public UUID getState() {
        return state;
    }

    @Override
    public UUID getUser() {
        return user;
    }

    @Override
    public UUID getTenant() {
        return tenant;
    }

    public UUID getRequest() {
        return request;
    }

    public String getUri() {
        return uri;
    }

    public UUID getService() {
        return service;
    }

    public String getServiceUri() {
        return serviceUri;
    }

    public Long getSize() {
        return size;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
