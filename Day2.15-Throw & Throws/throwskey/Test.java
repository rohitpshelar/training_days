package throwskey;

import java.io.IOException;

public class Test extends A {
	@Override
	public void m1() {
	//int a=10/0;
	}
public static void main(String[] args)  {
	A a =new Test();

		try {
			a.m1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	System.out.println("prgram end===normally");
}
}
