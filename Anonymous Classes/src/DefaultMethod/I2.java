package DefaultMethod;

public interface I2 {

	public default void m1() {
		System.out.println("M1 from I2");
		
	}
	
	void m2();
}
