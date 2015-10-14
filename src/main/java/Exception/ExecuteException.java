package Exception;

public class ExecuteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExecuteException()
	{
		super("There ist a Problem in doInTransaktion() - TransactionService");
	}
}
