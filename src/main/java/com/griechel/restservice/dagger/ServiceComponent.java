package com.griechel.restservice.dagger;

import com.griechel.restservice.dagger.modules.ApplicationModule;
import com.griechel.restservice.resources.PingResource;

import dagger.Component;

@Component(modules = {
    ApplicationModule.class
})
public interface ServiceComponent {
    PingResource getPingResource();
}
