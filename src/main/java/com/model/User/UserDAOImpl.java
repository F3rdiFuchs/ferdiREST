package com.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.model.Groups.Groups;
import com.service.Transaction.ITransaction;
import com.service.Transaction.TransactionImpl;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {	
private TransactionImpl transactionService;
	
	public TransactionImpl getTransactionService() {
		return transactionService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="transactionService")
	public void setTransactionService(TransactionImpl transactionService) {
		this.transactionService = transactionService;
	}

	@SuppressWarnings("unchecked")
	public List<User> listUser() {
		return (List<User>)transactionService.doInTransaktion(new ITransaction() {
			
			public Object execute(Session session) {
				List<User> userList = new ArrayList<User>();
				userList = (List<User>) session.createQuery("FROM User u LEFT JOIN FETCH u.groups").list();
				return userList;
			}
		});
	}

	public User getUser(final int userid) {
		return (User) transactionService.doInTransaktion(new ITransaction() {
			
			public Object execute(Session session) {
				User user = null;
				user = (User) session.get(User.class, userid);
				return user;
			}
		});
	}

	public Groups getGroupById(final Integer userId) {
		return (Groups) transactionService.doInTransaktion(new ITransaction() {
			
			public Object execute(Session session) {
				Groups group = null;
				group = (Groups) session.get(Groups.class, userId);
				return group;
			}
		});
	}
}
