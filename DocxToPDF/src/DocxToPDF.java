import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;



public class DocxToPDF {
    public static void main(String[] args) {
        //this should be same as class name
        //create object of class
        DocxToPDF cwoWord = new DocxToPDF();
        //you can specify your own path on the basis of file located
        cwoWord.ConvertToPDF(System.getProperty("user.dir") +"\\All file types\\docxFile.docx", System.getProperty("user.dir") +"\\All file types\\docxFile.pdf");
    }

    public void ConvertToPDF(String docPath, String pdfPath) {
        try {
            //taking input from docx file
            InputStream doc = new FileInputStream(new File(docPath));
            //process for creating pdf started
            XWPFDocument document = new XWPFDocument(doc);
            PdfOptions options = PdfOptions.create();
            OutputStream out = new FileOutputStream(new File(pdfPath));
            PdfConverter.getInstance().convert(document, out, options);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}