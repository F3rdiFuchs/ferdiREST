package com.service.TransactionService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Exception.ExecuteException;

public class TransactionImpl {
	private SessionFactory sessionFactory;
	
	public TransactionImpl(SessionFactory sessionF) {
		this.sessionFactory = sessionF;
	}

	public <T> T doInTransaktion(ITransaction<T> dataObject)
	{
		Transaction tx = null;
		Session session = null;
		T data;
		
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		
	
			data = dataObject.execute(session);
			tx.commit();
		
		
		session.close();
		return data;
	}
	
}
