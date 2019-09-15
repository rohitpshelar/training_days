package throwable.exception.nullPointer;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		try {
			System.out.println("try ===start");
			String s = a;
			System.out.println("string ===done");
			int i = Integer.parseInt(s);
			System.out.println("int.parse ===done");
			@SuppressWarnings("unused")
			int b = 10 / i;
			System.out.println("int./0 ===done");
			System.out.println("try ===end");
		} catch (ArithmeticException e) {
			System.out.println("cant divide by 0---==arthmatic");
		} catch (NumberFormatException e) {
			System.out.println("NumberFormat Exception=====");
		} catch (Exception e) {
			System.out.println("Exception");
		}

		System.out.println("program finish SUCESSFULLY");
	}

}
