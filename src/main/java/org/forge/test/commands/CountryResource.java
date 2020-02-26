package org.forge.test.commands;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * CountryResource
 */
@RegisterRestClient()
public interface CountryResource {

    @GET
    @Path("/some.properties")
    public String getProps();

}