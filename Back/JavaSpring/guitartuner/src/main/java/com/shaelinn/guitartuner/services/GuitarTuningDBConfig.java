package com.shaelinn.guitartuner.services;

import org.hibernate.cfg.Configuration;

public class GuitarTuningDBConfig extends Configuration {
    public GuitarTuningDBConfig() {
        this.setProperty("hibernate.connection.url", System.getProperty("GUITAR_TUNER_DB_URL"));
        this.setProperty("hibernate.connection.username", System.getProperty("GUITAR_TUNER_DB_USER"));
        this.setProperty("hibernate.connection.password", System.getProperty("GUITAR_TUNER_DB_PASSWORD"));
        this.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        this.setProperty("hibernate.show_sql", "true");

    }

}
