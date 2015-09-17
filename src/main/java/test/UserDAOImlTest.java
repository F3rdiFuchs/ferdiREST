package test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.List;

import com.model.Group.Group;
import com.model.User.User;
import com.model.User.UserDAOImpl;
import com.service.Transaction.ITransaction;
import com.service.Transaction.TransactionImpl;

public class UserDAOImlTest {
	
	Session session;
	UserDAOImpl userDAOImpl;
	
	@Before
	public void create(){
		session = mock(Session.class);
		TransactionMock transactionMock = new TransactionMock(session);
		userDAOImpl.setTransactionService(transactionMock);
		
	}
	

	@Test
	public void test() {
		
		List<User> userList = userDAOImpl.listUser();
		
	}
	
	class TransactionMock extends TransactionImpl
	{
		private Session session;
		public TransactionMock(Session session) {
			super(null);
			this.session = session;
			
		}
		
		
		@Override
		public <T> T doInTransaktion(ITransaction<T> dataObject) {
			
			T data = dataObject.execute(session);
			
			return data;
		}
		
	}

}
