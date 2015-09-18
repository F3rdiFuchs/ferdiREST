package test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import com.service.TransactionService.ITransaction;
import com.service.TransactionService.TransactionImpl;

import Exception.ExecuteException;

public class TransactionImplTest {
	TransactionImpl transactionImpl;
	SessionFactory sessionF;
	Session session;
	Transaction transaction;
	
	@Before
	public void before()
	{
		session = mock(Session.class);
		transaction = mock(Transaction.class);
		SessionFactory sessionF = mock(SessionFactory.class);
		transactionImpl = new TransactionImpl(sessionF);
		when(sessionF.openSession()).thenReturn(session);
		when(session.beginTransaction()).thenReturn(transaction);
	}
	
	@Test()
	public void doInTransaktionRollback() {
		try
		{
			transactionImpl.doInTransaktion(new ITransaction<Object>() {
	
				public Object execute(Session session) {
					throw new ExecuteException();
				}
			});
		}
		catch (Exception e)
		{
			//for once
		}
		verify(transaction).rollback();
	}
	
	@Test(expected=ExecuteException.class)
	public void doInTransaktionException() {
		transactionImpl.doInTransaktion(new ITransaction<Object>() {

			public Object execute(Session session) {
				throw new ExecuteException();
			}
		});
	}
}
