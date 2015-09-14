package com.service.UserService;

import java.util.List;

import com.model.Groups.Groups;
import com.model.User.User;

public interface UserService {
	public void addUser(User user) ;
	public List	<User> listUserId();
	public Groups getGroupById(Integer userId);
	public User getUser(int userid);
	public List<User> listUser() ;
	public boolean checkLogin(String userName, String passWord);
}
