package com.service.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
		
		try
		{
			data = dataObject.execute(session);
			tx.commit();
		}
		catch (Exception e)
		{
			tx.rollback();
			throw new RuntimeException(e);
		}
		session.close();
		return data;
	}
	
}
