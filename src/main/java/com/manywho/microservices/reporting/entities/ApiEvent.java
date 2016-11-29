package com.manywho.microservices.reporting.entities;

public class ApiEvent extends TenantEvent {
    private String uri;
    private String ipAddress;
    private String method;
    private Long size;
    private Integer duration;

    public String getUri() {
        return uri;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getMethod() {
        return method;
    }

    public Long getSize() {
        return size;
    }

    public Integer getDuration() {
        return duration;
    }
}
