package org.forge.test.commands;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.forge.addon.BasicProvider;

/**
 * BasicResource
 */
@RegisterRestClient(baseUri = "http://localhost:8181")
@RegisterProvider(value = BasicProvider.class)
public interface BasicResource {

    @GET
    @Path("/basic")
    public String getProps();
    
}