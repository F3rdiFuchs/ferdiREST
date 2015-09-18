package com.service.TransactionService;

import org.hibernate.Session;

public interface ITransaction<T> {
	T execute(Session session);	
}
