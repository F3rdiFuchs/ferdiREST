package com.service.UserService;

import java.util.List;

import com.model.Group.Group;
import com.model.User.User;

public interface UserService {
	Group getGroupById(Integer userId);
	User getUser(int userid);
	List<User> listUser();
	User findById(int id);
	User findBySso(String sso);
}
