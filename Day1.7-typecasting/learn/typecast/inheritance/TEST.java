package learn.typecast.inheritance;

public class TEST {
	public static void main(String[] args) {
	
	System.out.println("A ae = new E();");
	A ae = new E();
	A a=ae;
/*	B b=(B) ae;				
	C c=(C) ae;				
	D d=(D) ae;*/			
	E e=(E) ae;
	
	ae.m1();
	a.m1();
/*	b.m1();
	c.m1();
	d.m1();*/
	e.m1();	
	
	System.out.println(ae.a);
	System.out.println(a.a);
/*	System.out.println(b.a);
	System.out.println(c.a);
	System.out.println(d.a);*/
	System.out.println(e.a);
	System.out.println("-------------------------------------------");
	/*--------------------------------------------------------------------------------------------------------------*/
	
	System.out.println("A ac = new C()");
	A ac = new C();
	A a1=      ac;
	B b1=(B) ac;
	C c1=(C) ac;
/*	D d1=(D) ac;
	E e1=(E) ac;*/
	
	ac.m1();
	a1.m1();
	b1.m1();
	c1.m1();
/*	d1.m1();
	e1.m1();*/
	
	System.out.println(ac.a);
	System.out.println(a1.a);
//	System.out.println(b1.a);
	System.out.println(c1.a);
/*	System.out.println(d1.a);
	System.out.println(e1.a);*/
	System.out.println("-------------------------------------------");
	/*--------------------------------------------------------------------------------------------------------------*/
	
	System.out.println("B be = new C();");
	B be = new C();
	A a2=be;
	B b2=(B) be;
	C c2=(C) be;
	//D d2=(D) be;
	//E e2=(E) be;
	
	be.m1();
	a2.m1();
    b2.m1();
	c2.m1();
	//d2.m1();
	//e2.m1();	
	
//	System.out.println(be.a);
	System.out.println(a2.a);
	//System.out.println(b2.a);
	System.out.println(c2.a);
	//System.out.println(d2.a);
	//System.out.println(e2.a);
	System.out.println("-------------------------------------------");
/*	--------------------------------------------------------------------------------------------------------------*/
	System.out.println("C cd = new D();");
	C cd = new D();
	A a3= cd;
	B b3=(B) cd;
	C c3=(C) cd;
	D d3=(D) cd;
	//E e3=(E) cd;
	
	cd.m1();
	a3.m1();
    b3.m1();
	c3.m1();
	d3.m1();
	//e3.m1();	
	
	System.out.println(cd.a);
	System.out.println(a3.a);
	//System.out.println(b3.a);
	System.out.println(c3.a);
	System.out.println(d3.a);
	//System.out.println(e3.a);
	System.out.println("-------------------------------------------");
/*	--------------------------------------------------------------------------------------------------------------*/
	
	
	}
}
