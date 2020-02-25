package org.forge.test.commands;

import javax.inject.Inject;
import javax.inject.Provider;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
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

public class mp extends AbstractUICommand {

	@Inject
	@ConfigProperty(name = "key", defaultValue = "default")
	String key;

	@Inject
	@ConfigProperty(name = "key")
	Provider<String> optional;

	@Inject
	Config config;

	public mp() {
		System.out.println("MP Created!");
	}

	@Override
	public UICommandMetadata getMetadata(UIContext context) {
		return Metadata.forCommand(mp.class).name("mp");
	}

	@Override
	public void initializeUI(UIBuilder builder) throws Exception {
	}

	@Override
	public Result execute(UIExecutionContext context) throws Exception {
		// return Results.success("Command 'mp' successfully executed with " + config.getValue("key", String.class) + "!");
		return Results.success("Command 'mp' successfully executed with " + key + ":" + optional.get() + ":" + config.getValue("key", String.class) + "!");
	}
}