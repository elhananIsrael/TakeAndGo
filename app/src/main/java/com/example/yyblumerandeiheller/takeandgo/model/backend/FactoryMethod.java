package com.example.yyblumerandeiheller.takeandgo.model.backend;

import com.example.yyblumerandeiheller.takeandgo.model.datasource.ListsDataSource;


public class FactoryMethod {

    private static final FactoryMethod ourInstance = new FactoryMethod();



    public static FactoryMethod getInstance() {
        return ourInstance;
    }

    private FactoryMethod() {   }

    private static DataSource dataSourceInstance = new ListsDataSource();

    public static DataSource getDataSource() {return  dataSourceInstance; }
}
