package com.service.Transaction;

import org.hibernate.Session;

public interface Transaction {
	Object execute(Session session);	
}
