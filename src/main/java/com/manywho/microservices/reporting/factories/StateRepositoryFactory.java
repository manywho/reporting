package com.manywho.microservices.reporting.factories;

import com.manywho.microservices.reporting.entities.DatabaseType;
import com.manywho.microservices.reporting.repositories.StateRepository;
import com.manywho.microservices.reporting.repositories.StateRepositoryNull;
import com.manywho.microservices.reporting.repositories.StateRepositoryPostgres;
import com.manywho.sdk.services.config.ServiceConfiguration;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.ServiceLocator;

import javax.inject.Inject;

public class StateRepositoryFactory implements Factory<StateRepository> {
    private ServiceConfiguration configuration;
    private ServiceLocator serviceLocator;

    @Inject
    public StateRepositoryFactory(ServiceConfiguration configuration, ServiceLocator serviceLocator) {
        this.configuration = configuration;
        this.serviceLocator = serviceLocator;
    }

    @Override
    public StateRepository provide() {
        DatabaseType databaseType = DatabaseType.forValue(configuration.get("database.type"));

        switch (databaseType) {
            case Postgres:
                return serviceLocator.getService(StateRepositoryPostgres.class);
            case Null:
            default:
                return serviceLocator.getService(StateRepositoryNull.class);
        }
    }

    @Override
    public void dispose(StateRepository instance) {

    }
}
