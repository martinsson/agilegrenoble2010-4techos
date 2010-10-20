package org.agile.grenoble;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;

public class simpleClient {

	public static void main(String[] args) {
		
		Client c = Client.create();
		c.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
		System.out.println("Client created, going to create a webresource") ;
		WebResource r = c.resource("http://localhost:9998/helloworld");
		System.out.println("WebResource created, getting the answer");
		String response = r.accept(
			        MediaType.APPLICATION_JSON_TYPE,
			        MediaType.APPLICATION_XML_TYPE).
			        header("X-FOO", "BAR").get(String.class); 
		System.out.println("Response is " + response ) ;
	}
	
}
