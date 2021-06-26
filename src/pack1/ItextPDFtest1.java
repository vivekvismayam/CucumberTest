package pack1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPDFtest1 {

	public static void main(String[] args) {
		String filename="D://ItextPDFtest.pdf";
		Document doc =new Document();
		try {
			PdfWriter .getInstance(doc, new FileOutputStream(filename));
			doc.open();
			doc.addAuthor("Vivek M");
			doc.addHeader("dsadf", "daf");
			Paragraph para1= new Paragraph("This is a new para1");
			Paragraph para2= new Paragraph("\n\n\n\n\n\n\n\n\n\n");
			Paragraph para3= new Paragraph("This is a new para2");
			Paragraph para4= new Paragraph("3");
			doc.add(para1);
			doc.add(para2);
			doc.add(para3);
			doc.add(para4);
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println("Completed");
	}

}
