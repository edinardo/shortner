package com.sibilante.shortner.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.sibilante.shortner.controller.ShortnerResource;

@Component
@ApplicationPath("/")
public class JerseyConfiguration extends ResourceConfig {
	public JerseyConfiguration() {
		register(ShortnerResource.class);
	}
}
