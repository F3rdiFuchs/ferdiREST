package Test;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;

import com.model.User.User;
import com.model.User.UserDAOImpl;
import com.service.TransactionService.ITransaction;
import com.service.TransactionService.TransactionImpl;

public class UserDAOImlTest {
	Query query;
	Session session;
	UserDAOImpl userDAOImpl;
	

	
	@Before
	public void create() {
		query = mock(Query.class);
		session = mock(Session.class);
		
		TransactionMock transactionMock = new TransactionMock(session);
		
		userDAOImpl = new UserDAOImpl();
		userDAOImpl.setTransactionService(transactionMock);
	}
	
	@Test
	public void userListTest() {
		List<User> userList = Arrays.asList(new User(), new User());
		when(session.createQuery(anyString())).thenReturn(query);
		when(query.list()).thenReturn(userList);
		List<User> testUserList = userDAOImpl.listUser();
		assertEquals(testUserList,userList);
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
