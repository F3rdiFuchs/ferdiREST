package com.model.Groups;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GroupsDAOImpl implements GroupsDAO {
	
	private SessionFactory sessionFactory;
	
	public GroupsDAOImpl(SessionFactory _sessionFactory)
	{
		this.sessionFactory = _sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Groups> listGroups()throws Exception
	{
		List<Groups> groupList = new ArrayList<Groups>();
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		
		groupList = session.createQuery("SELECT DISTINCT g FROM Groups g LEFT JOIN FETCH g.user").list();
			
		tx2.commit();
		session.close();
		
		return groupList;
	}

	public Groups getGroupById(Integer id) throws Exception{
		Groups group = null;
		List<Groups> groupList = new ArrayList<Groups>();
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		groupList = session.createQuery("SELECT DISTINCT g FROM Groups g LEFT JOIN FETCH g.user").list();
		group = (Groups) session.get(Groups.class, id);
		
		tx2.commit();
		session.close();
		return group;
	}
}
