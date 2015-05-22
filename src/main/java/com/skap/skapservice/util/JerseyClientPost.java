package com.skap.skapservice.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class JerseyClientPost {

	public static void main(String[] args) {

		try {

			Client client = ClientBuilder.newClient();

			WebTarget webTarget = client
					.target("http://localhost:8080/skapservice/users/saveUserDefinition");

			String input = "{\"userID\":\"123@asm.com\",\"password\":\"f089eda53eff2b17ca9b385c11425b278c770509\"}";
			
			;
			
			Response response = webTarget.request("application/json")
					.post(Entity.entity(input, MediaType.APPLICATION_JSON));

			if (response.getStatus() != 201 || response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.readEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
