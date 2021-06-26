package pack1;

import java.io.FileOutputStream;
import java.util.Scanner;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPDFtest4 {

	public static void main(String[] args) {
		String filename=".//ItextPDFtest4.pdf";
		Document doc =new Document();
		try {
			PdfWriter .getInstance(doc, new FileOutputStream(filename));
			Scanner input=new Scanner(System.in);
			System.out.println("Enter link");
			String link=input.nextLine();
			
			doc.open();
			
			Anchor anchor1 = new Anchor(link);
			anchor1.setReference("#target");
			Paragraph p1 = new Paragraph();
			p1.add(anchor1);
			doc.add(p1);
			
			Anchor target = new Anchor("Target");
			target.setName("target");
			//addLines(doc);
			doc.add(target);
			
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println("Completed");

	}
	public static void addLines(Document document)  {
		
		Font font1=new Font(Font.FontFamily.TIMES_ROMAN,18,Font.BOLD,BaseColor.RED);
		
		Paragraph para4= new Paragraph("This is a new para4 \n",font1);	
		
		try {	
			for(int i=0;i<=100;i++) {
				Paragraph para= new Paragraph("This is a new para :"+i+" \n",font1);
				document.add(para);
				}
		} catch (DocumentException e) {
				e.printStackTrace();
		}
	}
}
