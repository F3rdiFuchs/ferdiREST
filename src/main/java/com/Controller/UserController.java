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
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired(required=true)
	@Qualifier(value ="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/user", method = RequestMethod.GET)
	public HttpEntity<List<TUser>> listAllUser()
	{
		List<User> userList = new ArrayList<User>();
		List<TUser> tuserList = new ArrayList<TUser>();
		userList = userService.listUser();
		
		for (Integer index = 0; index < userList.size(); index++)
		{
			tuserList.add(new TUser());
		}
		for (Integer index = 0; index < userList.size(); index++)
		{
			User user = userList.get(index);
			Link slink = linkTo(methodOn(UserController.class).getUser(user.getUserId().toString())).withSelfRel();
			tuserList.get(index).add(slink);
		}
		
		return new ResponseEntity<List<TUser>>(tuserList,HttpStatus.OK);
	}

	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable (value="id") String id)
	{
		User user;
		try 
		{
			user = this.userService.getUser(Integer.parseInt(id));
			user.add(linkTo(methodOn(GroupsController.class).getGroup(user.getGroups().getGroupId().toString())).withSelfRel());
		} 
		catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
		
		return user;
	}	
}
