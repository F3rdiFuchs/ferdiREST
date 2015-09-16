package com.service.Transaction;

import org.hibernate.Session;

public interface ITransaction<T> {
	T execute(Session session);	
}
