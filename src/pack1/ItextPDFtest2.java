package pack1;

import java.io.FileOutputStream;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPDFtest2 {

	public static void main(String[] args) {
		String filename="E://ItextPDFtest.pdf";
		Document doc =new Document();
		try {
			PdfWriter .getInstance(doc, new FileOutputStream(filename));
			doc.open();
			Font font1=new Font(Font.FontFamily.TIMES_ROMAN,18,Font.ITALIC,BaseColor.PINK);
	
			
			Paragraph para1= new Paragraph("This is a new para1 \n");
			Paragraph para2= new Paragraph("This is a new para2 \n");
			Paragraph para3= new Paragraph("This is a new para3 \n",font1);
			Paragraph para4= new Paragraph("This is a new para4 \n",font1);
			
			Chapter catPart=new Chapter("Chapter1",1);
			
			
			Section subCatPart = catPart.addSection(para1);
			//doc.add(subCatPart);
			subCatPart.addSection(para2);


			//doc.add(subCatPart);
			subCatPart = catPart.addSection(para3);
			//doc.add(subCatPart);
			subCatPart = catPart.addSection(para4);
			//catPart.add(subCatPart);

			//doc.add(subCatPart);
			//subCatPart.addSection("     111    ");
			doc.add(catPart);
			

			
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println("Completed");

	}

}
