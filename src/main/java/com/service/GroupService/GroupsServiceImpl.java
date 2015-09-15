package com.service.GroupService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GroupsServiceImpl {
	private SessionFactory sessionFactory;
	
	public GroupsServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Object doInTransaktion(GroupsService dataObject)
	{
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		
		dataObject.execute(session);
		
		tx2.commit();
		session.close();
		return dataObject;
	}

}
