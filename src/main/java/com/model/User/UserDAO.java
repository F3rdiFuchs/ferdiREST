package com.model.User;

import java.util.List;

import com.model.Groups.Groups;

public interface UserDAO {
	public List <User> listUser();
	public List	<User> listUserId();
	public User getUser(int userid);
	public Groups getGroupById(Integer userId);
	public void addUser(User user);
	public boolean checkLogin(String userName, String passWord);
}
