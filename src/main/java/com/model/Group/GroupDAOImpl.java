package com.model.Group;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.Link;

import com.Controller.GroupController;
import com.model.User.User;
import com.service.TransactionService.ITransaction;
import com.service.TransactionService.TransactionImpl;

public class GroupDAOImpl implements GroupDAO {
	private TransactionImpl transactionService;
	
	public TransactionImpl getTransactionService() {
		return transactionService;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "transactionService")
	public void setTransactionService(TransactionImpl transactionService) {
		this.transactionService = transactionService;
	}

	public Group getGroupById(final Integer id)
	{
		return transactionService.doInTransaktion(new ITransaction<Group>() {
			
			public Group execute(Session session) {
				Group group = new Group();
				group = (Group)session.get(Group.class, id);
				return group;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUserInGroup(final Integer groupId) {
		return transactionService.doInTransaktion(new ITransaction<List<User>>() {
			
			public List<User> execute(Session session) {
				
				List<User> userList = new ArrayList<User>();
				Group group = (Group) session.get(Group.class, groupId);
				userList = (List<User>) session.createQuery("FROM User u WHERE groups = :group")
						.setEntity("group", group)
						.list();
				return userList;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<Group> listAllGroups()
	{
		return transactionService.doInTransaktion(new ITransaction<List<Group>>() {

			public List<Group> execute(Session session) {
				
				List<Group> groupList = new ArrayList<Group>();
				groupList = session.createQuery("SELECT DISTINCT g FROM Group g LEFT JOIN FETCH g.user").list();
				return groupList;
			}
		});
	}
	
	public Link generateLink(Group group)
	{
		return linkTo(methodOn(GroupController.class).getGroup(group.getGroupId().toString())).withSelfRel();
	}
	
	public Link generateLinkwithUser(Group group)
	{
		return linkTo(methodOn(GroupController.class).getGroup(group.getGroupId().toString())).slash("user").withRel("user");
	}
}
