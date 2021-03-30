
public class mohini {

	public static void main(String[] args) {
		sub(500);
	}

	public static void sub(int result) {
		int temp = 0;
		int loop = 1;

		for (int i = 2; i <= 40; i++) {

			if (i % 2 == 0) {
				System.out.println("Loop=" + loop);
				System.out.println("Even :" + i);
				System.out.print(temp + "-" + i + "=");
				temp = temp - i;
				System.out.println(temp);
				System.out.println("---------------------------------------------");
				loop = loop + 1;
			}

		}
	}
}
