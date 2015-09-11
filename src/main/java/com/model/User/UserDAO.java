package com.model.User;

import java.util.List;

import com.model.Groups.Groups;

public interface UserDAO {
	public List <User> listUser()throws Exception;
	public List	<User> listUserId()throws Exception;
	public User getUser(int userid)throws Exception;
	public Groups getGroupById(Integer userId)throws Exception;
	public void addUser(User user)throws Exception;
	public boolean checkLogin(String userName, String passWord)throws Exception;
}
