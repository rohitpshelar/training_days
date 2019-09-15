package statics.keyword.day11;

public class A {

	static int a;//100/200
			int b;//0
			
		
			public static void main(String[] args) {
				A a=new A();
				a.a=100;
				a.b=100;
				System.out.println("a:"+a.a);
				System.out.println("b:"+a.b);
				System.out.println("");
				
				A a1=new A();
				a1.a=200;
				a1.b=200;
				System.out.println("a:"+a.a);//100 now 200
				System.out.println("b:"+a.b);
				System.out.println("a:"+a1.a);
				System.out.println("b:"+a1.b);
				System.out.println("");
				
				A a2=new A();
				System.out.println("a:"+a2.a);
				System.out.println("b:"+a2.b);
			
				
}
}
