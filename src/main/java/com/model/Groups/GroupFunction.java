package com.model.Groups;

import org.hibernate.Session;


public abstract class GroupFunction {
	public abstract Object doInTransaktion(Session session);
	
	
	
	
	/*
	public List<User> getUserInGroup(Integer groupId) {
		return (List<User>) doInTransaction (session) {
			Groups group = (Groups) session.get(Groups.class, groupId);
			return (List<User>) session.createQuery("FROM User u WHERE groups = :group")
					.setEntity("group", group)
					.list();
		}
	}*/
	
	
	

}
