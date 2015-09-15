package com.service.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TransactionImpl {
	private SessionFactory sessionFactory;
	
	public TransactionImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Object doInTransaktion(Transaction dataObject)
	{
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx2 = session.beginTransaction();
		
		dataObject.execute(session);
		
		tx2.commit();
		session.close();
		return dataObject;
	}
}
