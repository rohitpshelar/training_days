import org.junit.jupiter.api.Test;

public class StringConcat {
	private static final int COUNT = 10000000;
	private final String s1 = new String("1234567890");
	private final String s2 = new String("1234567890");
	public static void main(String[] args) {
		String a = "Rohit shelar";
		String b = "Rohit shelar";
		
		System.out.println("a.equals(b) : " + a.equalsIgnoreCase(b));
		System.out.println("a.contains(b) : " + a.contains(b));
		System.out.println("a.contains(b) : " + a.toLowerCase().contains(b.toLowerCase()));
	}
	@Test public void testConcatenation() {
	    for (int i = 0; i < COUNT; i++) {
//	        String s3 = s1 + s2;//0.734
//	        String s3 = new StringBuilder(s1).append(s2).toString();//0.284
//	        String s3 = new StringBuffer(s1).append(s2).toString();//0.370
//	        String s3 = s1.concat(s2);//0.417
//	        String s3 = "1234567890" + "1234567890";//0.016
//	        String s3 = s1 + "1234567890";//0.634
//	        String s3 = new StringBuilder(s1).append("1234567890").toString();//0.209
//	        String s3 = new StringBuffer(s1).append("1234567890").toString();//0.290
	        String s3 = s1.concat("1234567890");//0.285
	    }
	}
}


