package com.model.Groups;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.model.User.User;
import com.service.Transaction.Transaction;
import com.service.Transaction.TransactionImpl;

public class GroupsDAOImpl implements GroupsDAO {
	private TransactionImpl transactionService;
	
	
	public TransactionImpl getTransactionService() {
		return transactionService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="transactionService")
	public void setTransactionService(TransactionImpl transactionService) {
		this.transactionService = transactionService;
	}

	public Groups getGroupById(final Integer id)
	{
		return (Groups) transactionService.doInTransaktion(new Transaction() {
			
			public Object execute(Session session) {
				Groups group = new Groups();
				group = (Groups) session.get(Groups.class, id);
				return group;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUserInGroup(final Integer groupId) {
		return (List<User>) transactionService.doInTransaktion(new Transaction() {
			
			
			public Object execute(Session session) {
				
				List<User> userList = new ArrayList<User>();
				Groups group = (Groups) session.get(Groups.class, groupId);
				userList = (List<User>) session.createQuery("FROM User u WHERE groups = :group")
						.setEntity("group", group)
						.list();
				return userList;
				
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<Groups> listAllGroups()
	{
		Object ot = transactionService.doInTransaktion(new Transaction() {

			public Object execute(Session session) {
				
				List<Groups> groupList = new ArrayList<Groups>();
				groupList = session.createQuery("SELECT DISTINCT g FROM Groups g LEFT JOIN FETCH g.user").list();
				return groupList;
			}
		});
		return (List<Groups>) ot;
	}
}
