package com.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.model.Groups.Groups;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;
	private static final int DEFAULT_GROUPID_USER = 25;
	private static final int DEFAULT_MESSAGE_USER = 1;
	
	public UserDAOImpl(SessionFactory _sessionFactory)
	{
		this.sessionFactory = _sessionFactory;
	}
	
	@SuppressWarnings("unchecked") 
	public List<User> listUser() throws Exception {
		List<User> userList = new ArrayList<User>();
		
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		
		userList = (List<User>) session.createQuery("FROM User u LEFT JOIN FETCH u.groups").list();
		
		tx2.commit();
		session.close();
		
		return userList;
	}
	
	public void addUser(User user) throws Exception {
		user.encryptPasswd();
		Session session = this.sessionFactory.openSession();
		
		session.beginTransaction();
			
		Groups group = (Groups)session.get(Groups.class, DEFAULT_GROUPID_USER);
		user.setGroups(group);
			
		session.persist(user);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public boolean checkLogin(String userName, String passWord) throws Exception {
		User user = new User();
		User tmp = new User();
		tmp.setPassWord(passWord);
		tmp.encryptPasswd();
		
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		user = (User) session.get(User.class, userName);
		if(!userName.equals("") && !passWord.equals(""))
		{
			if(user.getPassWord()== tmp.getPassWord())
			{
				return true;
			}
		}
		return false;
	}

	public User getUser(int userid) throws Exception {
		User user = null;
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		
		user = (User) session.get(User.class, userid);
		
		tx2.commit();
		session.close();
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> listUserId() throws Exception {
		List<User> userList = new ArrayList<User>();
		
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		
		userList = (List<User>) session.createQuery("FROM User u LEFT JOIN FETCH u.groups").list();
		
		tx2.commit();
		session.close();
		
		return userList;
	}
}
