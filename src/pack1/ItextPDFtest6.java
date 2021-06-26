package pack1;

import java.io.FileOutputStream;

import com.google.common.collect.Table;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPDFtest6 {

	public static void main(String[] args) {
		String filename="E://PDFfile.pdf";
		Document doc =new Document(PageSize.A4.rotate());
		try {
			PdfWriter .getInstance(doc, new FileOutputStream(filename));
			Font font1=new Font(Font.FontFamily.TIMES_ROMAN,18,Font.BOLD,BaseColor.BLACK);
			Font font2=new Font(Font.FontFamily.HELVETICA,20,Font.ITALIC,BaseColor.RED);
			
			doc.open();
			doc.addHeader("Name", "Content");
			Paragraph p1= new Paragraph("----PARAGRAPH----\n",font1);
			//p1.setAlignment(p1.ALIGN_CENTER);
			doc.add(p1);
			
			Image img=Image.getInstance("E:\\Capture.PNG",true);
			img.scaleToFit(1000,250);
			
			doc.add(img);
			doc.newPage();
			Chunk chunkImage=new Chunk(img, 0, 0,true);
			doc.add(chunkImage);
			//doc.newPage();
			
			PdfPTable table =new PdfPTable(2);
			PdfPCell cell=new PdfPCell(new Phrase("Heading 1",font1));
			
			table.addCell(cell);
			cell=new PdfPCell(new Phrase("Heading 2",font2));
			table.addCell(cell);
			table.addCell("facebook");
			table.addCell(img);
			doc.add(table);
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println("Completed");
	}

}
