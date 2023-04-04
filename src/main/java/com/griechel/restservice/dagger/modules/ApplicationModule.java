package com.griechel.restservice.dagger.modules;

import javax.inject.Named;
import javax.inject.Singleton;

import com.fasterxml.jackson.datatype.guava.GuavaModule;
import dagger.Module;
import dagger.Provides;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.griechel.restservice.MyServiceConfiguration;

@Module
public class ApplicationModule {

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
    @Singleton
    @Named("endpointBaseUrl")
    public String getEndpointBaseUrl() {
        return "https://meteostat.p.rapidapi.com/point/daily";
    }

    @Provides
    @Singleton
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper().registerModule(new GuavaModule());
    }
}
