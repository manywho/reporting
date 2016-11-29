package com.manywho.microservices.reporting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.microservices.reporting.configuration.Database;
import com.manywho.microservices.reporting.factories.EventRepositoryFactory;
import com.manywho.microservices.reporting.factories.ObjectMapperFactory;
import com.manywho.microservices.reporting.factories.StateRepositoryFactory;
import com.manywho.microservices.reporting.factories.StateValueRepositoryFactory;
import com.manywho.microservices.reporting.managers.EventsManager;
import com.manywho.microservices.reporting.managers.StatesManager;
import com.manywho.microservices.reporting.repositories.EventRepository;
import com.manywho.microservices.reporting.repositories.EventRepositoryNull;
import com.manywho.microservices.reporting.repositories.EventRepositoryPostgres;
import com.manywho.microservices.reporting.repositories.StateRepository;
import com.manywho.microservices.reporting.repositories.StateRepositoryNull;
import com.manywho.microservices.reporting.repositories.StateRepositoryPostgres;
import com.manywho.microservices.reporting.repositories.StateValueRepository;
import com.manywho.microservices.reporting.repositories.StateValueRepositoryNull;
import com.manywho.microservices.reporting.repositories.StateValueRepositoryPostgres;
import com.manywho.microservices.reporting.services.StateService;
import com.manywho.microservices.reporting.services.StateValueService;
import com.manywho.sdk.services.config.DatabaseConfiguration;
import com.manywho.sdk.services.factories.Sql2oFactory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.sql2o.Sql2o;

import javax.inject.Singleton;

public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindFactory(Sql2oFactory.class).to(Sql2o.class);
        bindFactory(ObjectMapperFactory.class).to(ObjectMapper.class).ranked(10);
        bindFactory(EventRepositoryFactory.class).to(EventRepository.class);
        bindFactory(StateRepositoryFactory.class).to(StateRepository.class);
        bindFactory(StateValueRepositoryFactory.class).to(StateValueRepository.class);

        // Database repository implementations
        bind(EventRepositoryNull.class).to(EventRepositoryNull.class).in(Singleton.class);
        bind(EventRepositoryPostgres.class).to(EventRepositoryPostgres.class).in(Singleton.class);
        bind(StateRepositoryNull.class).to(StateRepositoryNull.class).in(Singleton.class);
        bind(StateRepositoryPostgres.class).to(StateRepositoryPostgres.class).in(Singleton.class);
        bind(StateValueRepositoryNull.class).to(StateValueRepositoryNull.class).in(Singleton.class);
        bind(StateValueRepositoryPostgres.class).to(StateValueRepositoryPostgres.class).in(Singleton.class);

        bind(Database.class).to(DatabaseConfiguration.class);
        bind(EventsManager.class).to(EventsManager.class);
        bind(StatesManager.class).to(StatesManager.class);
        bind(StateService.class).to(StateService.class);
        bind(StateValueService.class).to(StateValueService.class);
    }
}
