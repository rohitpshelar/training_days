import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.aspose.email.MailMessage;
import com.aspose.email.MhtFormatOptions;
import com.aspose.email.MhtSaveOptions;
import com.aspose.words.Document;
import com.aspose.words.ImageSaveOptions;
import com.aspose.words.ImageSize;
import com.aspose.words.NodeType;
import com.aspose.words.PageSet;
import com.aspose.words.PageSetup;
import com.aspose.words.SaveFormat;
import com.aspose.words.Shape;

public class DocToImg {

	static String inputDir = System.getProperty("user.dir") +"\\msg\\";
	static String OutputDir = System.getProperty("user.dir") +"\\convertedMsgFiles\\";
	
    public static void main(String args[]) throws Exception {
    	   String[] pathnames;

           File f = new File(inputDir);

           // Populates the array with names of files and directories
           pathnames = f.list();

           // For each pathname in the pathnames array
           for (String pathname : pathnames) {
               System.out.println(pathname);
           	String inputFileName = pathname;
        	String outputFileName = pathname.replace(".msg", ".mhtml");
        	
        	DocToImg dti = new DocToImg();
        	dti.msgToMhtml(inputFileName, outputFileName);
        	dti.mhtmlToPdf(outputFileName);
        	//dti.parseAndSaveAttachment(inputFileName);
    		//readingEmbeddedMessageFromAttachment(dataDir);
        //	dti.generateImages(outputFileName);
        	
        	File myObj = new File(OutputDir+ outputFileName); 
            myObj.delete();
        	
           }
    }

    public static void generateImages(String inputFilename) throws Exception {
    	com.aspose.words.License license = new com.aspose.words.License();
    	license.setLicense(System.getProperty("user.dir") +"\\lib\\" +"Aspose.Words.Java.lic");
    	String outputImageFileName = inputFilename.replace(".html", "");
    	System.out.println(outputImageFileName);
        Document doc = new Document(OutputDir+inputFilename);
        ImageSaveOptions options = new ImageSaveOptions(SaveFormat.JPEG);
        options.setJpegQuality(100);
        options.setResolution(100);
        for (int i = 0; i < doc.getPageCount(); i++) {
            String imageFilePath = OutputDir+ outputImageFileName+ "-" + i + ".jpg";
            options.setPageSet(new PageSet(i));
            doc.save(imageFilePath, options);
        }
    }
    
    private void mhtmlToPdf(String outputFileName) throws Exception {
    	com.aspose.words.License license = new com.aspose.words.License();
    	license.setLicense(System.getProperty("user.dir") +"\\lib\\" +"Aspose.Words.Java.lic");
    	Document wpd = new Document(OutputDir  + outputFileName);
    	// convert doc to docx, PDF and HTML
    	
    	for (Shape shape : (Iterable<Shape>)wpd.getChildNodes(NodeType.SHAPE, true))
    	{
    		resizeLargeImage(shape);
    	}
    	
//    	wpd.save(OutputDir + outputFileName.replace(".mhtml", ".tif"), SaveFormat.TIFF);
//    	wpd.save(OutputDir + outputFileName.replace(".mhtml", ".rtf"), SaveFormat.RTF);
//    	wpd.save(OutputDir + outputFileName.replace(".mhtml", ".doc"), SaveFormat.DOC);
//    	wpd.save(OutputDir + outputFileName.replace(".mhtml", ".docx"), SaveFormat.DOCX);
    	wpd.save(OutputDir + outputFileName.replace(".mhtml", ".pdf"), SaveFormat.PDF);
//    	wpd.save(OutputDir + outputFileName.replace(".mhtml", ".html"), SaveFormat.HTML);

	}
    
     String msgToMhtml(String inputFileName,String outputFileName) {
    	 com.aspose.email.License license = new com.aspose.email.License();
     	license.setLicense(System.getProperty("user.dir") +"\\lib\\" +"Aspose.Email.Java.lic");
    	MailMessage eml = MailMessage.load(inputDir+inputFileName);
    	
    	
    	MhtSaveOptions mhtSaveOptions = new MhtSaveOptions();
    	int iSaveOptions = MhtFormatOptions.WriteHeader | MhtFormatOptions.HideExtraPrintHeader;
    	mhtSaveOptions.setMhtFormatOptions(iSaveOptions);
    	eml.save(OutputDir + outputFileName, mhtSaveOptions);
    	return outputFileName;
	}
     
// 	public static void parseAndSaveAttachment(String inputFileName) {
//
//		//Instantiate an MSG file to load an MSG file from disk
//		MapiMessage outlookMessageFile = MapiMessage.fromFile(System.getProperty("user.dir") +"\\doc\\"+inputFileName);
//
//		//Loop through the attachments collection associated with the MapiMessage object
//		for (int i = 0; i < outlookMessageFile.getAttachments().size(); i++) {
//			//Set a reference to the MapiAttachment object
//			MapiAttachment outlookMessageAttachment = (MapiAttachment) outlookMessageFile.getAttachments().get_Item(i);
//			//Display attachment type
//			System.out.println("Att Type : " + outlookMessageAttachment.getMimeTag());
//			//Display attached file name
//			System.out.println("File Name : " + outlookMessageAttachment.getLongFileName());
//			//Save attachment to the disk
//			outlookMessageAttachment.save(System.getProperty("user.dir") +"\\doc\\converted\\" + outlookMessageAttachment.getDisplayName());
//		}
//	}
 	
	
//	public static void readingEmbeddedMessageFromAttachment(String dataDir) {
//		MapiMessage mapi = MapiMessage.fromFile(dataDir + "v3.msg");
//		MapiMessage emb = mapi.getAttachments().get_Item(0).getObjectData().toMapiMessage();
//	}
     
     public static void resizeLargeImage(Shape image) throws Exception
     {
     	// Return if this shape is not an image.
     	if (!image.hasImage())
     		return;

     	// calculate the free space based on an inline or floating image. If inline we must take the page margins into account.
     	PageSetup ps = image.getParentParagraph().getParentSection().getPageSetup();
     	double freePageWidth = image.isInline() ? ps.getPageWidth() - ps.getLeftMargin() - ps.getRightMargin() : ps.getPageWidth();
     	double freePageHeight = image.isInline() ? ps.getPageHeight() - ps.getTopMargin() - ps.getBottomMargin() : ps.getPageHeight();

     	ImageSize size = image.getImageData().getImageSize();

     	boolean exceedsMaxPageSize = size.getWidthPoints() > freePageWidth || size.getHeightPoints() > freePageHeight;

     	if (exceedsMaxPageSize)
     	{
     		// calculate the ratio to fit the page size based on which side is longer.
     		boolean widthLonger = (size.getWidthPoints() > size.getHeightPoints());
     		double ratio = widthLonger ? freePageWidth / size.getWidthPoints() : freePageHeight / size.getHeightPoints();
     	
     		// Set the new size.
     		image.setWidth(size.getWidthPoints() * ratio);
     		image.setHeight(size.getHeightPoints() * ratio);
     	}
     }
     

	
}