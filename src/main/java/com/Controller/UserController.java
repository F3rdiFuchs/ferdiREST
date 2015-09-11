package com.Controller;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.model.User.User;
import com.service.UserService.UserService;

@RestController
public class UserController {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public HttpEntity<List<User>> listAllUser()
	{
		List<User> userList = new ArrayList<User>();

		try
		{
			userList = (List<User>) userService.listUser();
			
			for(User user : userList)
			{
				user.add(linkTo(methodOn(UserController.class).getUser(user.getUserId().toString())).withSelfRel());
			}
			
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable (value="id") String id)
	{
		User user;
		try 
		{
			user = this.userService.getUser(Integer.parseInt(id));

		} 
		catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
		return user;
	}
}
