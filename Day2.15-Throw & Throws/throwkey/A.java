package throwkey;

public class A {
public void m1(int account) {
	System.out.println("111");
	
	if (account==100) {
		AccountNotFound a=new AccountNotFound("Account 100 is not available");
		throw a;
	
	}

}
public static void main(String[] args) {
	A a = new A();
	try {
		a.m1(100);
	} catch (AccountNotFound e) {
		System.out.println("catch");
	System.out.println(e.getMessage());
	}
	
}
}
