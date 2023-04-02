package com.testdb;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import com.testdb.config.ServiceConfiguration;
import com.testdb.dagger.DaggerServiceComponent;
import com.testdb.dagger.ServiceComponent;
import com.testdb.resources.PingResource;

public class FileDbMain extends Application<ServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new FileDbMain().run(args);
    }

    @Override
    public String getName() {
        return "Breck-App";
    }

    @Override
    public void run(ServiceConfiguration configuration, Environment environment) {
        PingResource pingResource = new PingResource(configuration.getTest());
        environment.jersey().register(pingResource);
    }

}
