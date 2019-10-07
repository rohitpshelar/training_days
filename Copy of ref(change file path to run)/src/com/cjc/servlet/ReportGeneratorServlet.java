package com.cjc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.daoImpI.Dao;
import com.cjc.model.RegForm;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class ReportGeneratorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
static String fileOutputpath="D:/MPI to instal/New Folder (2)/New Folder (2)/New Folder (2)/workspace_eclypse/Copy of ref(change file path to run)/WebContent/DBimages/";
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside report");
		Dao d = new Dao();
		ArrayList<RegForm> list  = (ArrayList<RegForm>) d.GetLoginDetails();


		try {
			Document document = new Document(PageSize.A4.rotate());
			

			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();

	
			
			Paragraph paragraph1 = new Paragraph("Registered Entry",FontFactory.getFont(FontFactory.TIMES_BOLD,22,Element.ALIGN_CENTER,BaseColor.RED));
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph1);

			Paragraph paragraph2 = new Paragraph(
					"1st Floor Kusai Market Above Tirupati Hospital Building,",
					FontFactory.getFont(FontFactory.TIMES_ITALIC, 12,
							Element.ALIGN_CENTER, BaseColor.GRAY));
			paragraph2.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph2);

			Paragraph paragraph3 = new Paragraph(
					"Karve Nagar Stop,Pune-52.Contact:8888022204", FontFactory
							.getFont(FontFactory.TIMES_ITALIC, 12,
									Element.ALIGN_CENTER, BaseColor.GRAY));
			paragraph3.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph3);
			

			Paragraph paragraph11 = new Paragraph(
					"------------------------------------------------------------------------------------------------",
					FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 24));// ,Font.CENTER_BASELINE
			paragraph11.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph11);

			PdfPTable table1 = new PdfPTable(10);
			table1.setWidthPercentage(100);
			
			
			PdfPCell cell = new PdfPCell(new Paragraph("Registration ID",
					FontFactory.getFont(FontFactory.TIMES_ROMAN, 10,
							Element.ALIGN_CENTER, BaseColor.GRAY)));
			cell.setFixedHeight(10);
			
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);

			cell = new PdfPCell(new Paragraph("Image", FontFactory
					.getFont(FontFactory.TIMES_ROMAN, 13, Element.ALIGN_CENTER,
							BaseColor.BLUE)));
			cell.setFixedHeight(10);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);

			cell = new PdfPCell(new Paragraph("First Name", FontFactory
					.getFont(FontFactory.TIMES_ROMAN, 13, Element.ALIGN_CENTER,
							BaseColor.BLUE)));
			cell.setFixedHeight(10);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);

			cell = new PdfPCell(new Paragraph("Last Name", FontFactory
					.getFont(FontFactory.TIMES_ROMAN, 13, Element.ALIGN_CENTER,
							BaseColor.BLUE)));
			cell.setFixedHeight(10);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);

			cell = new PdfPCell(new Paragraph("Gender", FontFactory
					.getFont(FontFactory.TIMES_ROMAN, 13, Element.ALIGN_CENTER,
							BaseColor.BLUE)));
			cell.setFixedHeight(20);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Qualification", FontFactory
					.getFont(FontFactory.TIMES_ROMAN, 13, Element.ALIGN_CENTER,
							BaseColor.BLUE)));
			cell.setFixedHeight(40);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Address", FontFactory
					.getFont(FontFactory.TIMES_ROMAN, 13, Element.ALIGN_CENTER,
							BaseColor.BLUE)));
			cell.setFixedHeight(40);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Language", FontFactory
					.getFont(FontFactory.TIMES_ROMAN, 13, Element.ALIGN_CENTER,
							BaseColor.BLUE)));
			cell.setFixedHeight(40);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("User Name", FontFactory
					.getFont(FontFactory.TIMES_ROMAN, 13, Element.ALIGN_CENTER,
							BaseColor.BLUE)));
			cell.setFixedHeight(40);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Password", FontFactory
					.getFont(FontFactory.TIMES_ROMAN, 13, Element.ALIGN_CENTER,
							BaseColor.BLUE)));
			cell.setFixedHeight(40);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell);

			for (RegForm r : list) {

				cell = new PdfPCell(new Paragraph("" + r.getRegid(), FontFactory
						.getFont(FontFactory.TIMES_ROMAN, 13, Element.ALIGN_CENTER,
								BaseColor.BLACK)));
				cell.setFixedHeight(40f);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(cell);
				
				try{
					cell = new PdfPCell();
					Image image = Image.getInstance(fileOutputpath+r.getUname()+".jpg");
					image.scalePercent(95, 100);
				 
				    cell.addElement(new Chunk(image, 0,0));
				    cell.setFixedHeight(40f);
				    cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
				    cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				    table1.addCell(cell);
		}catch(Exception e){
			e.printStackTrace();
		}
				
				cell = new PdfPCell(new Paragraph("" + r.getFname()));
				cell.setFixedHeight(40f);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(cell);

				cell = new PdfPCell(new Paragraph("" + r.getLname()));
				cell.setFixedHeight(40f);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(cell);
				
				cell = new PdfPCell(new Paragraph("" + r.getGender()));
				cell.setFixedHeight(40f);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(cell);
				
				cell = new PdfPCell(new Paragraph("" + r.getQual()));
				cell.setFixedHeight(40f);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(cell);
				
				cell = new PdfPCell(new Paragraph("" + r.getAdder()));
				cell.setFixedHeight(40f);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(cell);
				
				cell = new PdfPCell(new Paragraph("" + r.getLang()));
				cell.setFixedHeight(40f);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(cell);
				
				cell = new PdfPCell(new Paragraph("" + r.getUname()));
				cell.setFixedHeight(40f);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(cell);
				
				cell = new PdfPCell(new Paragraph("" + r.getPass()));
				cell.setFixedHeight(40f);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(cell);
				
				
			}
			document.add(table1);
			document.close();
		} catch (Exception e) {

		}

	}

}
