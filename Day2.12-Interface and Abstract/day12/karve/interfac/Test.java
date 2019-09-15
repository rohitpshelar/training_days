package day12.karve.interfac;

public class Test extends B implements I,I2{
	@Override
	public void m1() {
		super.m1();
		System.out.println("Test");
		super.m1();
	}
public static void main(String[] args) {
	Test t=new Test();
	t.m1();
}

}
