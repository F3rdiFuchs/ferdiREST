package com.service.UserService;

import java.util.List;

import com.model.User.User;

public interface UserService {
	public void addUser(User user) throws Exception ;
	public List<User> listUser() throws Exception ;
	public boolean checkLogin(String userName, String passWord) throws Exception ;
}
