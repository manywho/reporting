package com.manywho.microservices.reporting.entities;

public enum DatabaseType {
    Null("null"),
    Postgres("postgres");

    private final String text;

    DatabaseType(final String text) {
        this.text = text;
    }

    public static DatabaseType forValue(String value) {
        for (DatabaseType databaseType : values()) {
            if (value != null && value.equalsIgnoreCase(databaseType.text)) {
                return databaseType;
            }
        }

        return Null;
    }
}
