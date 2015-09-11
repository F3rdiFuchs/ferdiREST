package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Groups.Groups;
import com.model.User.User;
import com.service.GroupService.GroupsService;
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
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public List<User> listAllUser()
	{
		List<User> userList = null;

		try
		{
			userList = userService.listUser();
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		return userList;
	}
}
