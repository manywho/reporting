package com.manywho.microservices.reporting.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

public class ObjectMapperFactory extends com.manywho.sdk.services.factories.ObjectMapperFactory {
    @Override
    public ObjectMapper provide() {
        return super.provide()
                .registerModule(new JSR310Module());
    }
}
