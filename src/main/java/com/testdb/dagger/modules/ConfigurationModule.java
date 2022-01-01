package com.testdb.dagger.modules;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

@Module
public class ConfigurationModule {
    // Test string for injection
    public static final String FOO = "bar";

    @Named(FOO)
    @Provides
    String getFoo() {
        return FOO;
    }
}
