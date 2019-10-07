package statics.keyword.method;

public class A {
	static int a;
	int b;
	

	public void m1() {
	System.out.println(a);
	System.out.println(b);

	}
	
	static void m2(){
		System.out.println(a);
	//	System.out.println(b);//need to create object
		
		A a=new A();
		System.out.println(a.b);
		
	}
	
	public static void main(String[] args) {
		A a=new A();
		a.m1();
		A.m2();
		m2();
	}
}
