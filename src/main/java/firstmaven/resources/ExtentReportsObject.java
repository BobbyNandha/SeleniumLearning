package firstmaven.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsObject {
	//generating extent reports 
	public static ExtentReports Reports() {
		String path="./reports/"+"index.html";
		
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setDocumentTitle("test");
		report.config().setReportName("web testing");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("tester", "bobby");
		return extent;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	



}
