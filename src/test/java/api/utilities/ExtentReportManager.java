package api.utilities;

 
	

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;

	public class ExtentReportManager implements ITestListener {

	    ExtentReports extent = ExtentReportManager.getReport();
	    ExtentTest test;

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("Execution Started");
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS,
	                "Test Case PASSED : " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.log(Status.FAIL,
	                "Test Case FAILED : " + result.getName());

	        test.log(Status.FAIL,
	                result.getThrowable());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.log(Status.SKIP,
	                "Test Case SKIPPED : " + result.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	        System.out.println("Execution Completed");
	    }
	}

}
