package day12.karve.interfac;

public class B extends A implements I,I2 {
      @Override
	public void m1() {
		System.out.println("B");

	}
	public static void main(String[] args) {
		B b=new B();
		
		b.m1();
		b.m2();
		
	}

}
