package org.forge.test.commands;

import java.io.StringReader;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.RedirectionException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
// import org.forge.mp.config.ABNProperties;
import org.jboss.forge.addon.ui.command.AbstractUICommand;
import org.jboss.forge.addon.ui.context.UIBuilder;
import org.jboss.forge.addon.ui.context.UIContext;
import org.jboss.forge.addon.ui.context.UIExecutionContext;
import org.jboss.forge.addon.ui.metadata.UICommandMetadata;
import org.jboss.forge.addon.ui.util.Metadata;
import org.jboss.forge.addon.ui.util.Categories;
import org.jboss.forge.addon.ui.result.Result;
import org.jboss.forge.addon.ui.result.Results;

@ApplicationScoped
public class mp extends AbstractUICommand {

	// @Inject
	// @ConfigProperty(name = "local", defaultValue = "default")
	// String key;

	@Inject
	@ConfigProperty(name = "key")
	Provider<String> optional;

	@Inject
	Config config;

	@Inject
	@RestClient
	CountryResource cr;

	@Inject
	@RestClient
	BasicResource br;


	@Override
	public Result execute(UIExecutionContext context) throws Exception {
		// System.out.println( cr.getProps() );
		try {
			System.out.println( cr.getProps() );

		} catch (RedirectionException ex) {
			System.out.println(ex.getResponse().getStatusInfo().getReasonPhrase());
			return Results.fail(ex.getMessage());
		} catch (WebApplicationException ex) {
			Response resp = ex.getResponse();
			System.out.println(ex.getMessage());
			return Results.fail(ex.getResponse().getStatusInfo().getReasonPhrase());
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
			return Results.fail(e.getMessage());
		}


		// Properties props = new Properties();
		// props.load(new StringReader(cr.getProps()));
		// return Results.success("Command 'mp' successfully executed with " + config.getValue("key", String.class) + "!");
		// String dynamic = config.getValue("configsource.properties.url", String.class);
		// String opt = optional.get();
		return Results.success("Command 'mp' successfully executed with " + optional.get() + "!");
	}

	@Override
	public UICommandMetadata getMetadata(UIContext context) {
		return Metadata.forCommand(mp.class).name("mp");
	}

	@Override
	public void initializeUI(UIBuilder builder) throws Exception {	}	

}