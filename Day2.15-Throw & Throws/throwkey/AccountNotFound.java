package throwkey;

public class AccountNotFound extends ArithmeticException {
	
	public AccountNotFound(String a) {
		super(a);
		System.out.println("AccountNotFound==constructor");
	}

}
