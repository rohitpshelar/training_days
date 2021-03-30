import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

public class test {
public static void main(String[] args) throws IOException {
	File file = new File("append.txt");
	FileWriter fr = new FileWriter(file);
	fr.write("data");
	fr.close();
	
	System.out.println(Instant.now().toString().replaceAll("[TZ]", " ").replaceAll("-", "_").replaceAll(":", "_").replaceAll(" ", "_").replace(".","_"));
}
}
