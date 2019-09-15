package cjc.learn.day6;

public class Testnew {
	private A m1() {
	B b=new B();
	b.a=100;
return b;
	}
	public static void main(String[] args) {
		
	
	Test t = new Test();
	B b=t.rohit;
	A a=t.rohit;
	
	A aa=new A();
	A ab=new B();
	
	System.out.println(ab.a);
	System.out.println(b.a); 
	System.out.println(a.a);
	System.out.println(aa.a);
	System.out.println(t.rohita.a);
	System.out.println(t.rohit.a);
	
	t.rohita.m1();
	Testnew tn = new Testnew();
//	A at=(A) tn.m1();
//	System.out.println(at.a);
	B bt=(B) tn.m1();
	System.out.println(bt.a);
	}
}
