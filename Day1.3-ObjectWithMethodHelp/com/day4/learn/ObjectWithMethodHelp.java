package com.day4.learn;

public class ObjectWithMethodHelp {
	int z;

	private void m1() {
		System.out.println("method m1===");
	}

	private ObjectWithMethodHelp m22() {
		ObjectWithMethodHelp o = new ObjectWithMethodHelp();
		o.z = 100;
		System.out.println("Method m22 with return as Class name");
		return o;
	}

	private int m3() {
		System.out.println("m3==return is 5");
		return 5;
	}

	private int m4() {
		int x = 5;
		System.out.println("m4 ====return as X");
		return x;
	}

	public static void main(String[] args) {
		ObjectWithMethodHelp o = new ObjectWithMethodHelp();
		ObjectWithMethodHelp o1 =o.m22();// new ObjectWithMethodHelp();
		o.m1();
		o.m22();
		o1.m22();
		o.m3();
		o.m4();
		System.out.println(o.z);
		System.out.println(o1.z);
	}
}
