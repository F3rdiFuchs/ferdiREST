package com.model.User;

import java.util.List;

import com.model.Groups.Groups;

public interface UserDAO {
	public List <User> listUser();
	public User getUser(int userid);
	public Groups getGroupById(Integer userId);
}
