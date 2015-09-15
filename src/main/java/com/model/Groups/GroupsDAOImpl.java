package com.model.Groups;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.model.User.User;
import com.service.GroupService.GroupsService;
import com.service.GroupService.GroupsServiceImpl;

public class GroupsDAOImpl implements GroupsDAO {
	
	private SessionFactory sessionFactory;
	private GroupsServiceImpl groupsService;
	
	public GroupsDAOImpl(SessionFactory _sessionFactory)
	{
		this.sessionFactory = _sessionFactory;
	}
	
	
	public Groups getGroupById(Integer id){
		Groups group = null;
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		group = (Groups) session.get(Groups.class, id);
		
		tx2.commit();
		session.close();
		return group;
	}
	/*
	@SuppressWarnings("unchecked")
	public List<User> getUserInGroup(Integer groupId) {
		List<User> userList = new ArrayList<User>();
		
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		

		
		
		tx2.commit();
		session.close();
		return userList;
	}
	*/
	@SuppressWarnings("unchecked")
	public List<User> getUserInGroup(Integer groupId) {
		return (List<User>) groupsService.doInTransaktion(new GroupsService() {
			
			
			public Object execute(Session session) {
				
				List<User> userList = new ArrayList<User>();
				Groups group = (Groups) session.get(Groups.class, groupId);
				userList = (List<User>) session.createQuery("FROM User u WHERE groups = :group")
						.setEntity("group", group)
						.list();
				return userList;
				
			}
		})
	}
	
	@SuppressWarnings("unchecked")
	public List<Groups> listAllGroups()
	{
		return (List<Groups>) groupsService.doInTransaktion(new GroupsService() {

			public Object execute(Session session) {
				
				List<Groups> groupList = new ArrayList<Groups>();
				groupList = session.createQuery("SELECT DISTINCT g FROM Groups g LEFT JOIN FETCH g.user").list();
				return groupList;
			}
		});
	}
}
