package com.example;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.management.event.CamelContextStartedEvent;


/**
 * Configuration Class of our application
 */
@Singleton
public class Configuration {

	/**
	 * This method creates a bean (using @Produces) for Camel properties called
	 * 'properties'
	 * 
	 * @return
	 */
	@Produces
	@Named("properties")
	public PropertiesComponent propertiesComponent() {
		PropertiesComponent properties = new PropertiesComponent();
		properties.setLocation("classpath:application.properties");
		return properties;
	}

	/**
	 * Listen for event (observe using @Observes) when Camel is started.
	 * 
	 * You can listen for any of the Camel events from
	 * org.apache.camel.management.event package.
	 */
	void onContextStarted(@Observes CamelContextStartedEvent event) {

		System.out.println("***************************************");
		System.out.println("* Camel started " + event.getContext().getName());
		System.out.println("***************************************");
	}
}
