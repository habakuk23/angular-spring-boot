package com.schremser.spring.boot.provider;

import org.glassfish.jersey.server.ContainerRequest;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(final ContainerRequestContext requestContext,
                       final ContainerResponseContext cres) throws IOException {
        if (!cres.getHeaders().containsKey("Access-Control-Allow-Origin") && ((ContainerRequest) requestContext).getRequestHeader("Origin") != null)
            cres.getHeaders().add("Access-Control-Allow-Origin", ((ContainerRequest) requestContext).getRequestHeader("Origin").get(0));

        if (!cres.getHeaders().containsKey("Access-Control-Allow-Headers"))
            cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");

        if (!cres.getHeaders().containsKey("Access-Control-Allow-Credentials"))
            cres.getHeaders().add("Access-Control-Allow-Credentials", "true");

        if (!cres.getHeaders().containsKey("Access-Control-Allow-Methods"))
            cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

        if (!cres.getHeaders().containsKey("Access-Control-Max-Age"))
            cres.getHeaders().add("Access-Control-Max-Age", "1800");
    }

}