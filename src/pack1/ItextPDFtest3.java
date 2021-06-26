package pack1;

import java.io.FileOutputStream;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPDFtest3 {

	public static void main(String[] args) {
		String filename="E://ItextPDFtest.pdf";
		Document doc =new Document();
		try {
			PdfWriter .getInstance(doc, new FileOutputStream(filename));
			doc.open();
			Font font1=new Font(Font.FontFamily.TIMES_ROMAN,18,Font.BOLD,BaseColor.BLUE);
			Anchor anchor = new Anchor("Click here to go to target", font1);
	        anchor.setReference("#Target");
	        Anchor anchortarget = new Anchor("This is the target", font1);
			anchortarget.setName("Target");
			Chapter catPart = new Chapter(new Paragraph(anchor), 1);
			doc.add(anchor);
			
			Paragraph para1= new Paragraph("This is a new para1 \n");
			para1.setAlignment(Element.ALIGN_RIGHT);
			Paragraph para2= new Paragraph("This is a new para2 \n");
			Paragraph para3= new Paragraph("This is a new para3 \n",font1);
			Paragraph para4= new Paragraph("This is a newThis is a newThis is a newThis is a newThis is a newThis is a newThis is a newThis is a newThis is a newThis is a newThis is a newThis is a newThis is a newThis is a newThis is a newThis is a newThis is a new para4\n");
			para4.setIndentationLeft(50);
			
			para2.add(anchortarget);
			Section subCatPart = catPart.addSection(para1);
			
			subCatPart =catPart.addSection(para2);
			
			subCatPart = catPart.addSection(para3);
			
			subCatPart = catPart.addSection(para4);
			
			doc.add(catPart);
			//Image img=Image.getInstance("C:\\Users\\Vivek\\Downloads\\imgStep1.jpeg",true);
			//doc.add(img);
			
			doc.add(anchortarget);
			
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println("Completed");

	}

}
