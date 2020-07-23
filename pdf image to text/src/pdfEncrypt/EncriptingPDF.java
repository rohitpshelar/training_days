package pdfEncrypt;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
public class EncriptingPDF {
  
   public static void main(String args[]) throws Exception {
      //Loading an existing document
      File file = new File("D:\\916010032756455.pdf");
      PDDocument document = PDDocument.load(file);
   
      
      
      String javaScript = "app.alert( {cMsg: 'this is an example', nIcon: 3,"
    	         + " nType: 0, cTitle: 'PDFBox Javascript example’} );";

    	      //Creating PDActionJavaScript object 
    	      PDActionJavaScript PDAjavascript = new PDActionJavaScript(javaScript);

    	      //Embedding java script
    	      document.getDocumentCatalog().setOpenAction(PDAjavascript);
      
      
      //Creating access permission object
      AccessPermission ap = new AccessPermission();         

      //Creating StandardProtectionPolicy object
      StandardProtectionPolicy spp = new StandardProtectionPolicy("1234", "1234", ap);

      //Setting the length of the encryption key
      spp.setEncryptionKeyLength(128);

      //Setting the access permissions
      spp.setPermissions(ap);

      //Protecting the document
      document.protect(spp);

      System.out.println("Document encrypted");

      //Saving the document
      document.save("D:\\916010032756455.pdf");
      //Closing the document
      document.close();

   }
}
