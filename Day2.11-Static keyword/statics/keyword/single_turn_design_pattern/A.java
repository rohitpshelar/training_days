package statics.keyword.single_turn_design_pattern;

public class A {
	protected static A a;
	
	private A() {
		
	}

 public static A m1() {
		if (a==null) 
		a= new A();
return a;
	}
}
