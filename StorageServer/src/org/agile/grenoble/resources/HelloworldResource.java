package org.agile.grenoble.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
public class HelloworldResource {
         // The Java method will process HTTP GET requests
         @GET 
         // The Java method will produce content identified by the MIME Media
         // type "text/plain"
         @Produces("application/xml")
         public String getClichedMessage() {
             // Return some cliched textual content
             return "<hey>Hello World</hey>";
         }
}