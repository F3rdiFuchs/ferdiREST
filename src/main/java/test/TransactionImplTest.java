package test;

import static org.mockito.Mockito.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import com.service.Transaction.ITransaction;
import com.service.Transaction.TransactionImpl;

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
	public void test() {
		
		transactionImpl.doInTransaktion(new ITransaction<Object>() {

			public Object execute(Session session) {
				return  "1";
			}
		});
		verify(transaction).rollback();
		
		
	}

}
