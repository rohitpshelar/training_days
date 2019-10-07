
interface I {
	void run();

	default void m3() {
		System.out.println("defaulf");
	}

	static void m2() {
		System.out.println("Static");
	}
}

public class Anonymous implements I {

	public void m1() {
		System.out.println("Anonymous ====m1");

	}

	public static void main(String[] args) {

		I i = new I() {
			public void run() {
				System.out.println("run");
			}
		};
		i.run();

		Anonymous a = new Anonymous() {
			public void m1() {
				System.out.println("Anonymous ====m1--overriden");
			}
		};

		a.m1();

		I aaa = new Anonymous();
		aaa.m3();

		I.m2();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

	@Override
	public void m3() {
		System.out.println("a==M3");
		I.super.m3();
	}
}
