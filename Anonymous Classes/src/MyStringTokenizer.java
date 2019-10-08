import java.util.StringTokenizer;

public class A {

	final static String a = "c1(p2-5,p4-3)c2(p1-4,p2-6)";

	public static void m1(String s) {
		int max = 0;
		System.out.println(s);
		StringTokenizer st = new StringTokenizer(s, "c");
		while (st.hasMoreElements()) {
			String c = (String) st.nextElement();
			System.out.println(c);
		
				StringTokenizer p = new StringTokenizer(s, "p");
				System.out.println(p.nextToken());
				while (p.hasMoreElements()) {
					String ps = (String) p.nextElement();
					System.out.println("ps=="+ps);
				}

			
		}

	}

	public static void main(String[] args) {

		m1(a);
	}

}
