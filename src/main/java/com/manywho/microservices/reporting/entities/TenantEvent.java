package com.manywho.microservices.reporting.entities;

import java.util.UUID;

public class TenantEvent extends Event {
    private UUID tenant;

    public UUID getTenant() {
        return tenant;
    }
}
