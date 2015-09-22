package com.model.User;

import java.util.List;

import com.model.Group.Group;

public interface UserDAO {
	List <User> listUser();
	Group getGroupById(Integer userId);
	User findById(int userId);
	User findByUserName(String userName);
}
