package com.testdb;

import com.testdb.dagger.DaggerServiceComponent;
import com.testdb.dagger.ServiceComponent;

public class FileDbMain {

    public static void main(String[] args) {
        ServiceComponent component = DaggerServiceComponent.create();
        Service executor = component.fileDbTaskExecutor();
        executor.run();
    }
}
