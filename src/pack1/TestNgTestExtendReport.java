package pack1;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestNgTestExtendReport {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	@Test
	public static void Test1() {
		System.out.println("Test running 1-Pass");
		extentTest=extent.createTest("Test Extent 1 to be passed");
		extentTest.log(Status.PASS, "The test has passed and success");
		
		try {
			extentTest.addScreenCaptureFromPath("C:\\Users\\vivek\\eclipse-workspace\\CucumberTesting\\output\\Screenshot20210514083807.png");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public static void Test2() {
		System.out.println("Test running 2-Fail");
		
		extentTest=extent.createTest("Test Extent 2 to be failed");
		extentTest.log(Status.FAIL, "The test has Failed and success");
		Assert.fail();
	}
	@Test
	public static void Test3() {
		System.out.println("Test running 3-Skip");

		extentTest=extent.createTest("Test Extent to be skipped Skipped");
		extentTest.log(Status.SKIP, "The test has Skipped and success");
		throw new SkipException("Skipping exception encountered");	
	}
	@BeforeTest
	public static void BTest1() {
		System.out.println("preparing Test run");
		Date date=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		String fileName="./TestReport"+formatter.format(date)+".html";
		htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setDocumentTitle("Auto reports");
		htmlReporter.config().setReportName("Report name");
		htmlReporter.config().setTheme(Theme.DARK);
		//htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		htmlReporter.config().setTimeStampFormat("'('zzz')' EEEE, MMMM dd, yyyy, HH:MM ");
	
		extent=new ExtentReports();
		extent.setSystemInfo("Organisation  ", "Auto Test");
		extent.setSystemInfo("Test Lead  ", "Vivek M");
		extent.setSystemInfo("Browser", "Chrome");
		
		extent.attachReporter(htmlReporter);
	}
	@AfterTest
	public static void ATest1() {
		System.out.println("Completed Test");
	}
	
	@AfterClass
	public static void Aclass() {
		System.out.println("Completed Class");
		extent.flush();
	}
}
