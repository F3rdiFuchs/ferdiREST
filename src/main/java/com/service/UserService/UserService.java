package com.service.UserService;

import java.util.List;

import com.model.Groups.Groups;
import com.model.User.User;

public interface UserService {
	public void addUser(User user) throws Exception ;
	public List	<User> listUserId()throws Exception;
	public Groups getGroupById(Integer userId)throws Exception;
	public User getUser(int userid)throws Exception;
	public List<User> listUser() throws Exception ;
	public boolean checkLogin(String userName, String passWord) throws Exception ;
}
