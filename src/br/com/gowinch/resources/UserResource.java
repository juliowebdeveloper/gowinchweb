package br.com.gowinch.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.gowinch.dao.UserDAO;
import br.com.gowinch.model.User;

@Path("/users")
public class UserResource {

	

	
	@GET
	@Path("/us")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getListUsers1(){
		UserDAO dao = new UserDAO();
		ArrayList<User> u = dao.getAllUsers();
		
		return u;
	   
		
		
	}
	
}
