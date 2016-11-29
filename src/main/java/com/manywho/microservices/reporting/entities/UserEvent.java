package com.manywho.microservices.reporting.entities;

import java.util.UUID;

public class UserEvent extends TenantEvent {
    private UUID user;

    public UUID getUser() {
        return user;
    }
}
