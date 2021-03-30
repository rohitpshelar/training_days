import com.itextpdf.text.Document;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import org.jsoup.Jsoup;

public class HtmlAndHtmToPDF {
	private HtmlAndHtmToPDF() {}

	public static String extractText(Reader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(reader);
		String line;
		while ( (line=br.readLine()) != null) {
			sb.append(line);
		}
		String textOnly = Jsoup.parse(sb.toString()).text();
		System.out.println(textOnly);
		return textOnly;
	}

	public final static void main(String[] args) throws Exception{
		FileReader fr = new FileReader
				(System.getProperty("user.dir") +"\\All file types\\htmfile.htm");
		BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
		StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
		String line;  
		while((line=br.readLine())!=null)  
		{  
			sb.append(line);      //appends line to string buffer  
			//sb.append("\n");     //line feed   
		}  
		fr.close();    //closes the stream and release the resources  

		String ht = sb.toString();  
		System.out.println(ht);
		try {

			OutputStream file = new FileOutputStream(new File(System.getProperty("user.dir") +"\\All file types\\htmfile.pdf"));
			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			HTMLWorker htmlWorker = new HTMLWorker(document);
			htmlWorker.parse(new StringReader(ht));
			document.close();
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("finished converting");
	}
}