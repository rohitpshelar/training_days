package rod;

public class Test {

	int count;

	public void m1(int n, String a, String b, String c) {
		if (n == 1) {
			System.out.println(a + ">=" + c);
		} else {
			this.m1(n - 1, a, c, b);
			count++;
			System.out.println(a + ">=" + c);
			this.m1(n - 1, b, a, c);
			count++;
		}
	}

	public static void main(String[] args) {
		
		System.out.println(" In Tower of Hanoi ---Enter No. of disk:");
		java.util.Scanner s=new java.util.Scanner(System.in);
		int n=Integer.parseInt(s.next());
		s.close();
		Test t = new Test();
		t.m1(n, "a", "b", "c");
		t.count++;
		System.out.println("Steps need are ="+t.count);
	}
}
