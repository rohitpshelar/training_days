package oops.polymorphysm;

public class A {

	
	protected static void m1() {
System.out.println("m1==A");
	}
	
	 protected void m2() {
		System.out.println("m2==A");
			}
	 static{
		 System.out.println("static==A");
		 m1();
		 B b=new B();
		 b.m2();
	 }
	 public static void main(String[] args) {
		 System.out.println("main==A");
		m1();
		
		
	}
}
