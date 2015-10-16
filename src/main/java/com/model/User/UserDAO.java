package com.model.User;

import java.util.List;

import com.model.Group.Group;

public interface UserDAO {
	List <User> listUser(int page, int size);
	void addUser(User user);
	void deleteUser(String userId);
	void updateUser(User user);
	User getUserById(int userid);
	Group getGroupById(Integer userId);
}
