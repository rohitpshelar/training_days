package learn.statics;

public class B extends A {

	
	protected static void m1() {
		System.out.println("m1===B");
			}

	@Override
	public void m2() {
		System.out.println("m2===Bbbbbb");		
	
	}


 static{
	 m1();
	 B b=new B();
	 b.m2();
	 
 }
}
