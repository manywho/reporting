package com.manywho.microservices.reporting.factories;

import com.manywho.microservices.reporting.entities.DatabaseType;
import com.manywho.microservices.reporting.repositories.EventRepository;
import com.manywho.microservices.reporting.repositories.EventRepositoryNull;
import com.manywho.microservices.reporting.repositories.EventRepositoryPostgres;
import com.manywho.sdk.services.config.ServiceConfiguration;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.ServiceLocator;

import javax.inject.Inject;

public class EventRepositoryFactory implements Factory<EventRepository> {
    private ServiceConfiguration configuration;
    private ServiceLocator serviceLocator;

    @Inject
    public EventRepositoryFactory(ServiceConfiguration configuration, ServiceLocator serviceLocator) {
        this.configuration = configuration;
        this.serviceLocator = serviceLocator;
    }

    @Override
    public EventRepository provide() {
        DatabaseType databaseType = DatabaseType.forValue(configuration.get("database.type"));

        switch (databaseType) {
            case Postgres:
                return serviceLocator.getService(EventRepositoryPostgres.class);
            case Null:
            default:
                return serviceLocator.getService(EventRepositoryNull.class);
        }
    }

    @Override
    public void dispose(EventRepository instance) {

    }
}
