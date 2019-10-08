package DefaultMethod;

public interface I {

	public default void m1() {
		System.out.println("M1 from I");
		
	}
	
	void m2();
}
