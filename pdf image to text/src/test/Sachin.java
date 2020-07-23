package test;

public class Sachin {

	private static void m1(String s) {
		System.out.println("S");
	}

	private static void m1(Object o) {
		System.out.println("o");
	}

	public static void main(String[] args) {
		m1(null);
		m1("rohit");
	}
}
