package trycatchfinally;

public class A {
	public static void main(String[] args) {
		System.out.println("Program Start");
		int a = 0;
		try {
			System.out.println("outer try===start");
			a = /*10 / 0;*/10/2;
			try {
				System.out.println("inner try===start");
				a = /*10 / 0;*/20/0;
				System.out.println("inner try===end");
			} catch (NullPointerException e) {
				System.out.println("inner catch");
				
			} finally {
				System.out.println("inner finally");
			}
			System.out.println("outer try===end");
		} catch (RuntimeException e) {
			System.out.println("outer catch");
		
		} finally {

			System.out.println("outer finally");
		}
		System.out.println(a);
		System.out.println("Program end normally");
	}
}
