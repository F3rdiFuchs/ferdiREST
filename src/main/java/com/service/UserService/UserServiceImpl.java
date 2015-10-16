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

	public List<User> listUser(int page, int size) {
		return this.userDAO.listUser(page, size);
	}

	public User getUserById(int userId)  {
		return this.userDAO.getUserById(userId);
	}

	public Group getGroupById(Integer userId) {
		return this.userDAO.getGroupById(userId);
	}

	public void addUser(User user) {
		this.userDAO.addUser(user);
	}

	public void deleteUser(String userId) {
		this.userDAO.deleteUser(userId);
	}

	public void updateUser(User user) {
		this.userDAO.updateUser(user);
	}
}