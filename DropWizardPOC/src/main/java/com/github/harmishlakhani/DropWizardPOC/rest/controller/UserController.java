package com.github.harmishlakhani.DropWizardPOC.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.harmishlakhani.DropWizardPOC.rest.representations.User;

import io.dropwizard.setup.Environment;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

	@GET
    @Path("/{id}")
    public Response getEmployeeById(@PathParam("id") Integer id) {
        User user = new User(1, "Harmish", "Lakhani", "harmish.lakhani@gmail.com");
        
        return Response.ok(user).build();
    }
}
