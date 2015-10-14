package Exception;

public class UserNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException()
	{
		super("The user you want to update does not exsist");
	}
	
}
