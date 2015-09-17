package com.model.User;

import java.util.List;

import com.model.Group.Group;

public interface UserDAO {
	List <User> listUser();
	User getUser(int userid);
	Group getGroupById(Integer userId);
}
