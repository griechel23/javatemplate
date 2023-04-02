package com.griechel.restservice;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import com.griechel.restservice.dagger.DaggerServiceComponent;
import com.griechel.restservice.dagger.ServiceComponent;
import com.griechel.restservice.dagger.modules.ApplicationModule;
import com.griechel.restservice.resources.PingResource;

public class MyApplication extends Application<MyServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public String getName() {
        return "Garren's Application";
    }

    @Override
    public void run(MyServiceConfiguration configuration, Environment environment) {
        ServiceComponent component = DaggerServiceComponent.builder()
            .applicationModule(new ApplicationModule(configuration))
                                                           .build();
        PingResource pingResource = component.getPingResource();
        environment.jersey().register(pingResource);
    }

}
