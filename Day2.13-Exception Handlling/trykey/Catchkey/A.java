package trykey.Catchkey;

import java.util.Scanner;

public class A {
	A() {

		System.out.println("constrictor===A");
	}

	private int m1() {
		int a=1;
		System.out.println("Globle a="+a);
		try {
			System.out.println("try==start");
			System.out.println("Enter No:_____");
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
scanner.close();
			int i = Integer.parseInt(s);

			a = 10 / i;

			System.out.println(a);

			System.out.println("try==end");
			return a;
		} catch (Exception e) {
			a = 20;
			System.out.println("catch a==" + a);
		} finally {
			a = 30;
			System.out.println("Finally a=" + a);
		}
		
System.out.println("after=try,catch a="+a);
return a;
	}

	public static void main(String[] args) {
		System.out.println("program start");
		A a = new A();
		int x = a.m1();
		System.out.println("main a=" + x);
		System.out.println("program ==end==normally");
	}

}
