package com.Controller;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.User.TUser;
import com.model.User.User;
import com.service.UserService.UserService;

@RestController
public class UserController {
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/user/{page}/{size}", method = RequestMethod.GET)
	public HttpEntity<List<User>> listAllUser(@PathVariable (value = "page") String page, @PathVariable (value = "size") String size)
	{
		List<User> userList = new ArrayList<User>();
		try
		{
			userList = userService.listUser(Integer.parseInt(page), Integer.parseInt(size));
		}
		catch(Exception e)
		{
			System.out.println("listAllUser " +e);
		}
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable (value = "id") String id)
	{
		User user;
		try 
		{
			user = this.userService.getUserById(Integer.parseInt(id));
			user.add(linkTo(methodOn(GroupController.class).getGroup(user.getGroups().getGroupId().toString())).withSelfRel());
		} 
		catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
		return user;
	}	
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void addUser(@RequestBody User user)
	{
		if (user != null)
		{
			if ((user.getUserName() != null) && (user.geteMail() != null) && user.getPassword() != null)
			{
				try
				{
					this.userService.addUser(user);
				}
				catch (Exception e)
				{
					System.out.println("User cont not be saved: " +e);
				}
			}
		}
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable(value = "id") String id)
	{
		this.userService.deleteUser(id);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user)
	{
		this.userService.updateUser(user);
	}
}
