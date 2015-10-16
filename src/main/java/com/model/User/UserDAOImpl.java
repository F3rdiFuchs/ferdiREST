package com.model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.model.Group.Group;
import com.service.TransactionService.ITransaction;
import com.service.TransactionService.TransactionImpl;

import Exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {	
	private static final int DEFAULT_GROUPID_USER = 25;
	private TransactionImpl transactionService;
	
	public TransactionImpl getTransactionService() {
		return transactionService;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "transactionService")
	public void setTransactionService(TransactionImpl transactionServ) {
		this.transactionService = transactionServ;
	}

	@SuppressWarnings("unchecked")
	public List<User> listUser(final int page, final int size) {
		return transactionService.doInTransaktion(new ITransaction<List<User>>() {
			
			public List<User> execute(Session session) {
				Query query = session.createQuery("FROM User u LEFT JOIN FETCH u.groups");
				query.setFirstResult((page - 1) * size);
				query.setMaxResults(size);
				
				List<User> userList = new ArrayList<User>();
				userList = (List<User>) query.list();
				
				return userList;
			}
		});
	}

	public User getUserById(final int userid) {
		return transactionService.doInTransaktion(new ITransaction<User>() {
			
			public User execute(Session session) {
				User user = null;
				user = (User) session.get(User.class, userid);
				return user;
			}
		});
	}

	public Group getGroupById(final Integer userId) {
		return transactionService.doInTransaktion(new ITransaction<Group>() {
			
			public Group execute(Session session) {
				Group group = null;
				group = (Group) session.get(Group.class, userId);
				return group;
			}
		});
	}

	public void addUser(final User user) {
		transactionService.doInTransaktion(new ITransaction<User>() {
			
			public User execute(Session session) {
				if (user.getGroups() == null)
				{
					Group group = (Group) session.get(Group.class, DEFAULT_GROUPID_USER);
					user.setGroups(group);
				}
				session.persist(user);
				return null;
			}
		});
	}

	public void deleteUser(final String userid) {
		transactionService.doInTransaktion(new ITransaction<User>() {
			
			public User execute(Session session) {
				User userToDelete = (User) session.get(User.class, Integer.parseInt(userid));
				session.delete(userToDelete);
				return null;
			}
		});
	}

	public void updateUser(final User user) {
		transactionService.doInTransaktion(new ITransaction<User>() {
			public User execute(Session session) {
				try
				{
					User tUser = (User) session.get(User.class, user.getUserId());
					tUser.setUserName(user.getUserName());
					tUser.setName(user.getName());
					tUser.setLastName(user.getLastName());
					tUser.seteMail(user.geteMail());
					tUser.setPassword(user.getPassword());
					session.save(tUser);
				}
				catch (Exception e)
				{
					throw new UserNotFoundException();
				}
				return null;
			}
		});
		
	}
}
