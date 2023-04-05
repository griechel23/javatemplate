package com.griechel.restservice.dagger.modules;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

import com.griechel.restservice.MyServiceConfiguration;

@Module
public class ApplicationModule {

    public static final String DB_URL = "dbUrl";
    private final MyServiceConfiguration config;

    public ApplicationModule(MyServiceConfiguration config) {
        this.config = config;
    }

    @Provides
    @Named("pingResponse")
    public String getPingResponse() {
        return config.getPingResponse();
    }

    @Provides
    @Named("endpointBaseUrl")
    public String getEndpointBaseUrl() {
        return "https://meteostat.p.rapidapi.com/point/daily";
    }

    @Provides
    @Named(DB_URL)
    String getDbUrl() {
        return "jdbc:sqlite:data.db";
    }

}
