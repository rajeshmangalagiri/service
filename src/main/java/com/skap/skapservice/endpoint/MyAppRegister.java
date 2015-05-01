/**
 * 
 */
package com.skap.skapservice.endpoint;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.wordnik.swagger.jaxrs.config.BeanConfig;

/**
 * Registers the components to be used by the JAX-RS application
 * @author Sravan_Meda
 *
 */
public class MyAppRegister extends ResourceConfig {
	/**
	* Register JAX-RS application components.
	*/
	public MyAppRegister() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("v1.0");
		beanConfig.setBasePath("http://localhost:9080/");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);
        
		register(RequestContextFilter.class);
		register(SkapServiceEndPointImpl.class);
		register(JacksonFeature.class);
		register(com.wordnik.swagger.jersey.listing.ApiListingResourceJSON.class);
		register(com.wordnik.swagger.jersey.listing.JerseyApiDeclarationProvider.class);
		register(com.wordnik.swagger.jersey.listing.JerseyResourceListingProvider.class);
	}

}
