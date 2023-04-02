package com.griechel.restservice.dagger.modules;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

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
}
