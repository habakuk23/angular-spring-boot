package com.schremser.spring.boot;

import com.schremser.spring.boot.provider.CORSFilter;
import com.schremser.spring.boot.rest.RootResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import com.schremser.spring.boot.provider.GsonJerseyProvider;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // packages("com.schremser.spring.boot");
        register(RequestContextFilter.class);
        register(CORSFilter.class);
        register(GsonJerseyProvider.class);
        register(RootResource.class);
    }
}
