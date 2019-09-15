package statics.keyword.single_turn_design_pattern;

public class Test {


	public static void main(String[] args) {
//		A a=new A();
//		A a1=new A();
		 A a= A.m1();
		A a1= A.m1();

		System.out.println(a);
		System.out.println(a1);
System.out.println(a.equals(a1));
		
	}

}
