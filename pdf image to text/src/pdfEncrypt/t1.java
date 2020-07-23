package pdfEncrypt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.ghost4j.document.DocumentException;

import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.tools.EncryptPdf;

public class t1 {
	/** User password. */
	public static byte[] USER = "Hello".getBytes();
	/** Owner password. */
	public static byte[] OWNER = "World".getBytes();
	static String src = "D:\\916010032756455.pdf";
	static String dest = "D:\\1.pdf";
//	 File s = new File(s);
//	 File n = new File("D:\\1.pdf");


	public static void encryptPdf(String src, String dest) throws IOException, DocumentException, com.lowagie.text.DocumentException {
	    PdfReader reader = new PdfReader(src);
	    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
	    stamper.setEncryption(USER, OWNER,PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
	    stamper.close();
	    reader.close();
	}
	
	public static void main(String[] args) throws IOException, DocumentException, com.lowagie.text.DocumentException {
		encryptPdf(src, dest);
	}
}
