package com.model.Groups;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.model.User.User;

public class GroupsDAOImpl implements GroupsDAO {
	
	private SessionFactory sessionFactory;
	
	public GroupsDAOImpl(SessionFactory _sessionFactory)
	{
		this.sessionFactory = _sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Groups> listGroups()
	{
		List<Groups> groupList = new ArrayList<Groups>();
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		
		groupList = session.createQuery("SELECT DISTINCT g FROM Groups g LEFT JOIN FETCH g.user").list();
			
		tx2.commit();
		session.close();
		
		return groupList;
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

	@SuppressWarnings("unchecked")
	public List<User> getUserInGroup(Integer groupId) {
		List<User> userList = new ArrayList<User>();
		
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		

		Groups group = (Groups) session.get(Groups.class, groupId);
		userList = (List<User>) session.createQuery("FROM User u WHERE groups = :group")
				.setEntity("group", group)
				.list();
		
		tx2.commit();
		session.close();
		return userList;
	}
}
