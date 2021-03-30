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
import com.aspose.words.ImageSize;
import com.aspose.words.NodeType;
import com.aspose.words.PageSetup;
import com.aspose.words.SaveFormat;
import com.aspose.words.Shape;

public class msgToPdf {

	public static void main(String args[]) throws Exception {
		dbconnection();
	}

	public static void dbconnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cellma", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM document_management where doc_type = \"msg\"");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "  " + rs.getString(13) + rs.getString(14));

				String inputDir = rs.getString(13)+"\\";
				String outputDir = rs.getString(13)+"\\";
				String fileName = rs.getString(14);
				String inputFileName = fileName;
				String outputFileName = fileName.replace(".msg", ".mhtml");

				msgToPdf msgToPdf = new msgToPdf();
				msgToPdf.msgToMhtml(inputDir, inputFileName, outputDir, outputFileName);
				msgToPdf.mhtmlToPdf(outputDir, outputFileName);
				
	        	File mhtmlFile = new File(outputDir+ outputFileName); 
	        	mhtmlFile.delete();

				String filename = rs.getString(14).replace(".msg", ".pdf");
				String query = "UPDATE document_management SET doc_type = ?, doc_name = ? WHERE (doc_id = ?)";

				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setString(1, "pdf");
				preparedStmt.setString(2, filename);
				preparedStmt.setInt(3, rs.getInt(1));
				preparedStmt.executeUpdate();
				
				System.out.println(" -> Converted");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String msgToMhtml(String inputDir, String inputFileName, String OutputDir, String outputFileName) {
		com.aspose.email.License license = new com.aspose.email.License();
		license.setLicense(System.getProperty("user.dir") + "\\lib\\" + "Aspose.Email.Java.lic");
		MailMessage eml = MailMessage.load(inputDir + inputFileName);

		MhtSaveOptions mhtSaveOptions = new MhtSaveOptions();
		int iSaveOptions = MhtFormatOptions.WriteHeader | MhtFormatOptions.HideExtraPrintHeader;
		mhtSaveOptions.setMhtFormatOptions(iSaveOptions);
		eml.save(OutputDir + outputFileName, mhtSaveOptions);
		return outputFileName;
	}

	@SuppressWarnings("unchecked")
	void mhtmlToPdf(String OutputDir, String outputFileName) throws Exception {
		com.aspose.words.License license = new com.aspose.words.License();
		license.setLicense(System.getProperty("user.dir") + "\\lib\\" + "Aspose.Words.Java.lic");
		Document wpd = new Document(OutputDir + outputFileName);

		for (Shape shape : (Iterable<Shape>) wpd.getChildNodes(NodeType.SHAPE, true)) {
			resizeLargeImage(shape);
		}
		wpd.save(OutputDir + outputFileName.replace(".mhtml", ".pdf"), SaveFormat.PDF);

	}

	public static void resizeLargeImage(Shape image) throws Exception {
		if (!image.hasImage())
			return;

		PageSetup ps = image.getParentParagraph().getParentSection().getPageSetup();
		double freePageWidth = image.isInline() ? ps.getPageWidth() - ps.getLeftMargin() - ps.getRightMargin()
				: ps.getPageWidth();
		double freePageHeight = image.isInline() ? ps.getPageHeight() - ps.getTopMargin() - ps.getBottomMargin()
				: ps.getPageHeight();

		ImageSize size = image.getImageData().getImageSize();

		boolean exceedsMaxPageSize = size.getWidthPoints() > freePageWidth || size.getHeightPoints() > freePageHeight;

		if (exceedsMaxPageSize) {
			boolean widthLonger = (size.getWidthPoints() > size.getHeightPoints());
			double ratio = widthLonger ? freePageWidth / size.getWidthPoints()
					: freePageHeight / size.getHeightPoints();

			image.setWidth(size.getWidthPoints() * ratio);
			image.setHeight(size.getHeightPoints() * ratio);
		}
	}

}