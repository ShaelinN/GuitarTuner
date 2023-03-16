package com.shaelinn.guitartuner.services;

import org.hibernate.cfg.Configuration;

public class GuitarTuningDBConfig extends Configuration {
    public GuitarTuningDBConfig() {
        String url = "jdbc:mysql://host.docker.internal:3306/" + System.getenv("DB_DATABASE");
        String pass =  System.getenv("DB_PASSWORD");
        String user = System.getenv("DB_USERNAME");

        this.setProperty("hibernate.connection.url", url);
        this.setProperty("hibernate.connection.username", user);
        this.setProperty("hibernate.connection.password", pass);

        this.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        this.setProperty("hibernate.show_sql", "true");

    }

}
