package com.example;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.Endpoint;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.cdi.Uri;

@Singleton
@ContextName(value = "camel-context")
public class MainRoute extends RouteBuilder {

	@Inject
	@Named("testBean")
	TestBean test;

	@Inject
	@Uri("undertow:http://localhost:8080/demo")
	private Endpoint undertow;

	@Override
	public void configure() throws Exception {
		from(undertow).log(LoggingLevel.INFO, "called by [${headers.CamelHttpMethod}] ${headers.CamelHttpUrl}")
				.bean(test);
	}

}
