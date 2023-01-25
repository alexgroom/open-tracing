package org.acme.people.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.smallrye.common.annotation.NonBlocking;
import io.micrometer.core.instrument.MeterRegistry;

@Path("/hello")
public class GreetingResource {

    public static final Logger log = LoggerFactory.getLogger(GreetingResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @NonBlocking
    public String hello() {
        registry.counter("greeting.hello.counter").increment();
        return "hello";
    }

    private final MeterRegistry registry;

    GreetingResource(MeterRegistry registry) {
        this.registry = registry;
    }
}