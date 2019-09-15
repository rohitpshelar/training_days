package learn.typecast.inheritance;

public class B extends A {
private	String a="B";
	public B m2() {
		System.out.println("B==m1");
return b;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	static B b=new B();
public static void main(String[] args) {
	b.setA("Rohit");
	String b2=b.getA();
	System.out.println(b2);
}
}
