package oops.polymorphysm;

public class B extends A {

	
	protected static void m1() {
		System.out.println("m1===B");
			}

	@Override
	public void m2() {
		System.out.println("m2===B");		
	
	}


 static{
	 System.out.println("Static==B");
	 m1();
	 B b=new B();
	 b.m2();
 }
 public static void main(String[] args) {
	System.out.println("main==B");

	m1();
	
}
}
