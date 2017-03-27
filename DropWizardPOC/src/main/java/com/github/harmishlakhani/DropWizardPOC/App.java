package com.github.harmishlakhani.DropWizardPOC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.harmishlakhani.DropWizardPOC.rest.controller.UserController;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class App extends Application<Configuration> {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main( String[] args ) throws Exception {
		new App().run(args);
    }

	@Override
	public void run(Configuration c, Environment e) throws Exception {
		LOGGER.info("Inside run method");
		e.jersey().register(new UserController());
		e.lifecycle().executorService("DropWizardPOC-Threads");
	}
}
