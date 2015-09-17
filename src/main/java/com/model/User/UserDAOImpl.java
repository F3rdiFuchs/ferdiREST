package com.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.model.Group.Group;
import com.service.Transaction.ITransaction;
import com.service.Transaction.TransactionImpl;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {	
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
	public List<User> listUser() {
		return transactionService.doInTransaktion(new ITransaction<List<User>>() {
			
			public List<User> execute(Session session) {
				List<User> userList = new ArrayList<User>();
				userList = (List<User>) session.createQuery("FROM User u LEFT JOIN FETCH u.groups").list();
				return userList;
			}
		});
	}

	public User getUser(final int userid) {
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
}
