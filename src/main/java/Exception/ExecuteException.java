package Exception;

public class ExecuteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExecuteException()
	{
		super("This only happens if the test is ok!");
	}

}
