package com.testdb;

import com.testdb.dagger.modules.ConfigurationModule;

import javax.inject.Inject;
import javax.inject.Named;

public class Service {

    private final String foo;

    @Inject
    public Service(@Named(ConfigurationModule.FOO) String entrypoint) {
        this.foo = entrypoint;
    }

    public void run() {
        System.out.println("Injected variable foo with value " + foo);
    }
}
