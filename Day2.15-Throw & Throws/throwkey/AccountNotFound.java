package throwkey;

public class AccountNotFound extends ArithmeticException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFound(String a) {
		super(a);
		System.out.println("AccountNotFound==constructor");
	}

}
