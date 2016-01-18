package com.manywho.microservices.reporting.exceptions;

public class UnableToConvertStateValueToJsonException extends RuntimeException {
    public UnableToConvertStateValueToJsonException(String stateId, String elementId) {
        super("Unable to convert the state value with ID " + stateId + ":" + elementId + " to JSON when saving to PostgreSQL");
    }
}
