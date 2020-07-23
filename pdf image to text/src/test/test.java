package test;

public class test {
public static void main(String[] args) {
	String s= "Barcode: 1161 (Jackson Jems)";
	s= s.toLowerCase();
//	if (s.contains("barcode") && s.contains("(")) {
//		System.out.println(s.split("(", 2)[0].split("barcode:", 2)[1].trim());
//	}
	if (s.contains("barcode:")) {
		System.out.println(s.split(" ", 10)[1].trim());
	}
}
}
