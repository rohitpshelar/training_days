package pdfEncrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
/**
 * This class is used to add password protection 
 * on a pdf file using iText jar.
 * @author codesjava
 */
public class PDFPasswordExample {
  public static void main(String args[]){
    try {
	String userPassword = "user123";
	String ownerPassword = "owner123";
 
	//Create Document instance.
	Document document = new Document();
 File s = new File("D:\\916010032756455.pdf");
 File n = new File("D:\\1.pdf");
	//Create OutputStream instance.
	OutputStream outputStream = 
	     new FileOutputStream(n);
 
	//Create PDFWriter instance.
	PdfWriter pdfWriter = 
			PdfWriter.getInstance(document, outputStream);
//  //Add content to the document.
	try (FileInputStream fis = new FileInputStream(s); FileOutputStream fos = new FileOutputStream(n)) {
		byte[] buffer = new byte[1024];
		int length;
		while ((length = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, length);
		}
	}
//
        //Add password protection.
	pdfWriter.setEncryption(userPassword.getBytes(), 
		    ownerPassword.getBytes(),
                    PdfWriter.ALLOW_PRINTING, 
                    PdfWriter.ENCRYPTION_AES_128);
 
        //Open the document.
       document.open();
// 

        //Close document and outputStream.
       document.close();
       outputStream.close();
 
        System.out.println("Pdf created successfully.");
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
}