package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportSpiceJet {
	 public static ExtentReports getReport() {
  	   ExtentSparkReporter report=new ExtentSparkReporter("./spicejetreports/report.html");
  	   report.config().setReportName("SpiceJet Reporter");
  	   report.config().setDocumentTitle("SpiceJet Reporter Title");
  	   ExtentReports extent=new ExtentReports();
  	   extent.attachReporter(report);
  	   
  	   return extent;
  	   
  	   }
}
