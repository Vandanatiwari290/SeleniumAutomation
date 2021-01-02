package seleniumproject.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class GenerateExtentReport {

    static ExtentTest test;
    static ExtentReports report;

    public void generateExtentReports(){
        report=new ExtentReports(System.getProperty("./extentReports.html"));
        test=report.startTest("ExtentDemo");
        report.flush();

    }

}
