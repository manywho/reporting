package com.manywho.microservices.reporting.configuration;

import com.manywho.sdk.services.config.DatabaseConfiguration;
import com.manywho.sdk.services.config.ServiceConfiguration;

import javax.inject.Inject;

public class Database implements DatabaseConfiguration {
    private ServiceConfiguration configuration;

    @Inject
    public Database(ServiceConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String getUrl() {
        // This environment variable has a compatible JDBC URL when running on Heroku, so use it if it's there
        if (configuration.has("JDBC_DATABASE_URL")) {
            return configuration.get("JDBC_DATABASE_URL");
        }

        return configuration.get("database.url");
    }

    @Override
    public String getUsername() {
        return configuration.get("database.username");
    }

    @Override
    public String getPassword() {
        return configuration.get("database.password");
    }
}
