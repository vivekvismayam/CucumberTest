package pack1;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class TestClass {

	public static void main(String[] args) {
		Date d= new Date();
		/*
		 * System.out.println(LocalTime.now()); System.out.println(LocalDateTime.now());
		 * System.out.println(LocalDate.now());
		 */
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		System.out.println(formatter.format(d));
		
		LocalTime myObj = LocalTime.now();
		   // System.out.println(myObj.format(formatter));
		    

	}

}
