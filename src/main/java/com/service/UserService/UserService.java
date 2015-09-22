package com.service.UserService;

import java.util.List;

import com.model.Group.Group;
import com.model.User.User;

public interface UserService {
	Group getGroupById(Integer userId);
	User findById(int userid);
	List<User> listUser();
	User findByUserName(String userName);
}
