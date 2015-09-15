package com.service.UserService;

import java.util.List;

import com.model.Groups.Groups;
import com.model.User.User;

public interface UserService {
	public Groups getGroupById(Integer userId);
	public User getUser(int userid);
	public List<User> listUser() ;
}
