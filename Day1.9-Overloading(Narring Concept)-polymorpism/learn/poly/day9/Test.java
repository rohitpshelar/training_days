package learn.poly.day9;

public class Test {

	private void m1(Object o) {
		System.out.println("Object");
	}
	
	
	private void m1(Test t) {
System.out.println("Test");
	}
	
	private void m1(int a) {
		System.out.println("int");

	}
	private void m1(String s) {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
	Test t = new Test();
//t.m1(null);
t.m1("rohit");

	
	}

}
