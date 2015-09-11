package com.model.User;

import java.util.List;

public interface UserDAO {
	public List <User> listUser()throws Exception ;
	public void addUser(User user)throws Exception ;
	public boolean checkLogin(String userName, String passWord)throws Exception ;
}
