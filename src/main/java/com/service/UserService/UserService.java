package com.service.UserService;

import java.util.List;

import com.model.Group.Group;
import com.model.User.User;

public interface UserService {
	Group getGroupById(Integer userId);
	User getUserById(int userId);
	void addUser(User user);
	void deleteUser(String userId);
	void updateUser(User user);
	List<User> listUser(int page, int size) ;
}
