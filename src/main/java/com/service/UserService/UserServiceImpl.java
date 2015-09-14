package com.service.UserService;

import java.util.List;

import com.model.Groups.Groups;
import com.model.User.User;
import com.model.User.UserDAO;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void addUser(User p) {
		this.userDAO.addUser(p);
	}


	public List<User> listUser() {
		return this.userDAO.listUser();
	}

	public boolean checkLogin(String userName, String passWord) {

		return this.userDAO.checkLogin(userName, passWord);
	}

	public User getUser(int userid)  {
		return this.userDAO.getUser(userid);
	}

	public List<User> listUserId()  {
		return this.userDAO.listUserId();
	}

	public Groups getGroupById(Integer userId) {
		return this.userDAO.getGroupById(userId);
	}
}
