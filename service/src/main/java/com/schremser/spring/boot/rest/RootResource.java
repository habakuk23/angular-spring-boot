package com.schremser.spring.boot.rest;

import com.schremser.spring.boot.domain.Credentials;
import com.schremser.spring.boot.domain.Message;
import com.schremser.spring.boot.domain.Token;
import com.schremser.spring.boot.service.MessageService;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.*;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/")
public class RootResource {

    @Autowired
    private MessageService messageService;

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/hello")
    public String root() {
        return "Hello World";
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/messages")
    public List<Message> messages() {
        return messageService.getMessages();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/authenticate")
    public Token postAuthenticate(Credentials credentials) {
        return new Token(credentials);
    }

}
