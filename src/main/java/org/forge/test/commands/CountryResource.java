package org.forge.test.commands;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.forge.addon.OAuth2Provider;

/**
 * CountryResource
 */
@RegisterRestClient(configKey = "")
@RegisterProvider(value = OAuth2Provider.class)
public interface CountryResource extends OriginalResource {

    @GET
    @Path("/customers")
    public String getProps();

}