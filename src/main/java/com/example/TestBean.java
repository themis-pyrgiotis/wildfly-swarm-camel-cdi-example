package com.example;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.PropertyInject;

/**
 * Define this bean as singleton so CDI can use it for dependency injection
 */
@Singleton
@Named("testBean")
public class TestBean {

	public String giveResponse(@PropertyInject("greetings") String greetings) {
		return greetings;
	}
}
