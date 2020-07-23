package pdf_image_to_text;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Test extends PDFStreamEngine {
	static String PdfImageText = "";

	public static void main(String[] args) {
		try {
			new Test().pdfFolderScanner();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void pdfFolderScanner() throws InterruptedException, IOException {
		Path faxFolder = Paths.get("drive/");
		WatchService watchService  = FileSystems.getDefault().newWatchService();
		faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

		boolean valid = true;
		do {
			WatchKey watchKey = null;
			watchKey = watchService.take();

			for (WatchEvent<?> event : watchKey.pollEvents()) {
				if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
					String fileName = event.context().toString();
					if(fileName.toLowerCase().contains(".pdf")) {
						
						new Test().scanPDF();
				        File file = new File("drive/"+fileName); 
				        if(!file.delete()) 
				            System.out.println("Failed to delete the file"); 
					}
				}
			}
			valid = watchKey.reset();
		} while (valid);
	}
	
	 void scanPDF() throws IOException{
		String allText = "";
		String outFileName = "";
		PDDocument document = null;

		for (final File fileEntry : new File("drive/").listFiles()) {
			File scanedFile = new File(fileEntry.getPath());
			document = PDDocument.load(scanedFile);
			System.out.println("Processing : "+ fileEntry.getName());
			for (PDPage page : document.getPages()) {
				new Test().processPage(page);
			}

			String pdfText = new PDFTextStripper().getText(document);
			allText = allText.concat(pdfText).concat(PdfImageText);
			System.out.println("allText = " + allText);
			String[] lines = allText.split("\\R", 25);
			outFileName = "";
			String catagory = getCatagory(lines);
			String barcode = getBarcode(lines);
			String Name_filePath = "DOC/";
			outFileName = catagory + "_" + barcode;
			if (catagory != null && barcode != null) {
				Name_filePath = findDocumentCatagory(allText);
			} else {
				Name_filePath = "DOC/fail";
			}

			try (FileInputStream fis = new FileInputStream(scanedFile); FileOutputStream fos = new FileOutputStream(new File(Name_filePath + "/" + outFileName + ".pdf"))) {
				byte[] buffer = new byte[1024];
				int length;
				while ((length = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, length);
				}
			}
		document.close();
		allText = "";
		PdfImageText = "";
		}
	}

	protected void processOperator(Operator operator, List<COSBase> operands) throws IOException {
		if ("Do".equals(operator.getName())) {
			PDXObject xobject = getResources().getXObject((COSName) operands.get(0));
			if (xobject instanceof PDImageXObject) {
				PDImageXObject image = (PDImageXObject) xobject;

				// same image to local
				BufferedImage bImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
				bImage = image.getImage();
				File file = new File("image.png"); 
				ImageIO.write(bImage, "PNG", file);
				String imageText = "";
				try {
					imageText = new Tesseract().doOCR(new File("image.png"));
				} catch (TesseractException e) {
					e.printStackTrace();
				}
				PdfImageText = PdfImageText.concat(imageText);
			        if(!file.delete()) 
			            System.out.println("Failed to delete the file"); 
			} else if (xobject instanceof PDFormXObject) {
				showForm((PDFormXObject) xobject);
			}
		} else {
			super.processOperator(operator, operands);
		}
	}

	static String getCatagory(String[] lines) {
		for (String line : lines) {
			line = line.toLowerCase();
			if (line.contains("examinations")) {
				return "examination";
			}
			if (line.contains("category") && line.contains("specialty")) {
				return line.split("specialty", 2)[0].split("category :", 2)[1].trim();
			}
			if (line.contains("category") && line.contains("received")) {
				return line.split("received", 2)[0].split("category :", 2)[1].trim();
			}
			if (line.contains("category :") && line.contains("est")) {
				return line.split("est", 2)[0].split("category :", 2)[1].trim();
			}
			if (line.contains("category:") && line.contains("est")) {
				return line.split("est", 2)[0].split("category:", 2)[1].trim();
			}
		}
		return null;
	}

	static String getBarcode(String[] lines) {	
		for (String line : lines) {
			line = line.toLowerCase();
			if (line.contains("barcode") && line.contains("identifier")) {
				return line.split("identifier", 2)[0].split("barcode:", 2)[1].trim();
			}
			if (line.contains("barcode") && line.contains("specialty")) {
				String b =  line.split("barcode:", 2)[1].trim();
				if(b.contains(" ")) {
					return b.split(" ", 2)[0].trim();
				}
			}
			if (line.contains("barcode:")) {
				return line.split(" ", 10)[1].trim();
			}
			if (line.contains("barcode no:")) {
				return line.split("barcode no:")[1].trim();
			}
		}
		return null;
	}
	
	String findDocumentCatagory(String allText){
		if (allText.contains("Historical")) {
			return "DOC/success";
		} else if (allText.contains("Finance")) {
			return "DOC/success";
		} else if (allText.contains("Procedures") || allText.contains("Procedure")) {
			return "DOC/success";
		} else if (allText.contains("Medical Notes") || allText.contains("Medical Note")) {
			return "DOC/success";
		} else if (allText.contains("Letters") || allText.contains("Letter")) {
			return "DOC/success";	
		} else if (allText.contains("Hospitalisation")) {
			return "DOC/success";
		} else if (allText.contains("Insurance")) {
			return "DOC/success";
		} else if (allText.contains("Investigations") || allText.contains("Investigation")) {
			return "DOC/success";
		} else if (allText.contains("Examination") || allText.contains("Examinations")) {
			return "DOC/success";
		} else if (allText.contains("Medications") || allText.contains("Medication")) {
			return "DOC/success";
		} else {
			return "DOC/fail";
		}
	}
}
