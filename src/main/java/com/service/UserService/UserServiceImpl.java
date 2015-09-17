package com.service.UserService;

import java.util.List;

import com.model.Group.Group;
import com.model.User.User;
import com.model.User.UserDAO;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userD) {
		this.userDAO = userD;
	}

	public List<User> listUser() {
		return this.userDAO.listUser();
	}

	public User getUser(int userid)  {
		return this.userDAO.getUser(userid);
	}

	public Group getGroupById(Integer userId) {
		return this.userDAO.getGroupById(userId);
	}
}