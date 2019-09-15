package learn.superkey.thiskey;

public class B extends A {
	int a=20;
	int b=90;

	public B() {
//		super();
		this(1);
		System.out.println("B=default=Constructor");
	}
	
	public B(final int b) {
		this("Rohit");
		System.out.println("B=int=Constructor");
	}
	
	public B(final String b) {
	super();
		System.out.println("B=string=Constructor");
	}
	
public void m1() {
	final int a=30;
	int b=30;
	System.out.println("int a");
	System.out.println(a);
	System.out.println(this.a);
	System.out.println(super.a);
	
	System.out.println("int x==A");
	System.out.println(x);
	System.out.println(this.x);
	System.out.println(super.x);
	
	System.out.println("int b==B");
	System.out.println(b);
	System.out.println(this.b);
	//System.out.println(super.b);
	

	
}
public static void mains() {
	System.out.println("rohit");
}
@Override
public int m2(final int i) {
	final int a=10;
	final int b=20;
	final int c=a+b;
	return c;
	
	
}

public int m3() {
	int c=super.m2(2);
	c=c*100;
	return c;
}
	public static void main(final String[] args) {
		
		final B b=new B();
		System.out.println("");
		System.out.println("M1");
		b.m1();
		final int a=b.m2(30);
		System.out.println("");
		System.out.println("M2");
		System.out.println(a);
		
		final int c=b.m3();
		System.out.println("");
		System.out.println("M3");
		System.out.println(c);

	}
}
