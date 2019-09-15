package learn.typecast.inheritance;

public class A {
String a="A";

	public void m1() {
	System.out.println("A==m1");

}
public static void main(String[] args) {
	A a=new A();
	a.m1();
	System.out.println(a.a);
}
}
