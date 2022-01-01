package com.testdb.dagger;

import com.testdb.Service;
import com.testdb.dagger.modules.ConfigurationModule;
import dagger.Component;

@Component(modules = ConfigurationModule.class)
public interface ServiceComponent {
    Service fileDbTaskExecutor();
}
