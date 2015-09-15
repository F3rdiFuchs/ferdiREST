package com.service.Transaction;

import org.hibernate.Session;

public interface ITransaction {
	Object execute(Session session);	
}
