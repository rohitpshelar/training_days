package cjc.learn.day6;

public class AB {


	public static void main(String[] args) {
	
		A a = new A();
		a.m1();
		a.m2();
		System.out.println(a.a);
		System.out.println(a.b);
		System.out.println("");
		
		B b = new B();
		b.m1();//B==m1
		b.m2();//A=m2
		b.m3();//B=m3
		System.out.println(b.a);//30==B
		System.out.println(b.b);//20==A
		System.out.println(b.c);//40==B
		System.out.println("");
		
		A ab=new B();
		ab.m1();//B==m1---------Calls from B if there is m1 method in B
		ab.m2();//A==m2
		System.out.println(ab.a);//10 ==A --------call from A even if there is int a Variable in B
		System.out.println(ab.b);//20==a
		System.out.println("");
		
		b= (B) ab;
		System.out.println(b.a);//30==b // to call variable from class B
	
		
	
		
		
		
		
		
	}

}
