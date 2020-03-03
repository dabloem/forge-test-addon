package org.forge.test.commands;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * OriginalResource
 */
public interface OriginalResource {

    @GET
    @Path("/customers")
    public String getProps();
}