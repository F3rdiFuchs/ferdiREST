package com.model.User;

import java.util.List;

public interface UserDAO {
	public List <User> listUser()throws Exception;
	public List	<User> listUserId()throws Exception;
	public User getUser(int userid)throws Exception;
	public void addUser(User user)throws Exception;
	public boolean checkLogin(String userName, String passWord)throws Exception;
}
