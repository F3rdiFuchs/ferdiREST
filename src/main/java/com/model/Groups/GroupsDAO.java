package com.model.Groups;

import java.util.List;

import org.hibernate.SessionFactory;

import com.model.User.User;

public interface GroupsDAO {
	public List <Groups> listGroups();
	public List<User> getUserInGroup(Integer groupId);
	public Groups getGroupById(Integer id);
	public void openSession(SessionFactory sessionFactory);
}
