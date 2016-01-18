package com.manywho.microservices.reporting.factories;

import com.manywho.microservices.reporting.entities.DatabaseType;
import com.manywho.microservices.reporting.repositories.StateValueRepository;
import com.manywho.microservices.reporting.repositories.StateValueRepositoryNull;
import com.manywho.microservices.reporting.repositories.StateValueRepositoryPostgres;
import com.manywho.sdk.services.config.ServiceConfiguration;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.ServiceLocator;

import javax.inject.Inject;

public class StateValueRepositoryFactory implements Factory<StateValueRepository> {
    private ServiceConfiguration configuration;
    private ServiceLocator serviceLocator;

    @Inject
    public StateValueRepositoryFactory(ServiceConfiguration configuration, ServiceLocator serviceLocator) {
        this.configuration = configuration;
        this.serviceLocator = serviceLocator;
    }

    @Override
    public StateValueRepository provide() {
        DatabaseType databaseType = DatabaseType.forValue(configuration.get("database.type"));

        switch (databaseType) {
            case Postgres:
                return serviceLocator.getService(StateValueRepositoryPostgres.class);
            case Null:
            default:
                return serviceLocator.getService(StateValueRepositoryNull.class);
        }
    }

    @Override
    public void dispose(StateValueRepository instance) {

    }
}
