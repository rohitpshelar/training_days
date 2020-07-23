package cellma;

import java.nio.charset.Charset;
import java.util.Random;

public class test {
static void m1(String firstname) {
	String usePassword = "";
	if(firstname != null && firstname.length() >= 1){
		if(firstname.length() > 3) {
			usePassword = firstname.substring(0, 3);	
		}else {
			usePassword = firstname.substring(0, firstname.length());	
		}
		usePassword = usePassword.substring(0, 1).toUpperCase() + usePassword.substring(1);
		usePassword = usePassword + "@" + String.valueOf(1000 + new Random().nextInt(9000));
	}
	System.out.println(usePassword);

}

static void m2(String firstname) {
	String usePassword = "";
	if(firstname != null && firstname.length() >= 1){
		if(firstname.length() > 3) {
			usePassword = firstname.substring(0, 3);	
		}else {
			 byte[] array = new byte[2]; // length is bounded by 7
			    new Random().nextBytes(array);
		    String generatedString = new String(array, Charset.forName("UTF-8"));
			usePassword = firstname.substring(0, firstname.length()) + generatedString;	
		}
		usePassword = usePassword.substring(0, 1).toUpperCase() + usePassword.substring(1);
		usePassword = usePassword + "@" + String.valueOf(1000 + new Random().nextInt(9000));
	}
	System.out.println(usePassword);

}

public static void main(String[] args) {
	m1("m");
	m2("m");
	
	Random rnd = new Random();
	char c = (char) (rnd.nextInt(26));
	System.out.println(c);
}
}
