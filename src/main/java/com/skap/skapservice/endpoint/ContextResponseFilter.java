/**
 * 
 */
package com.skap.skapservice.endpoint;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

/**
 * @author Sravan_Meda
 *
 */
@Provider
@PreMatching
public class ContextResponseFilter implements ContainerResponseFilter {

	/* (non-Javadoc)
	 * @see javax.ws.rs.container.ContainerResponseFilter#filter(javax.ws.rs.container.ContainerRequestContext, javax.ws.rs.container.ContainerResponseContext)
	 */
	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		responseContext.getHeaders().add("Access-Control-Max-Age", "3600");
		responseContext.getHeaders().add("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
	}

}
