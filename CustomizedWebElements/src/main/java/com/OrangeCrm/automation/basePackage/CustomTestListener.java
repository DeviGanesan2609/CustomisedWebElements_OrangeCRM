package com.OrangeCrm.automation.basePackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomTestListener extends TestBase implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		/*Reporter.log("<br>P ToString : "+arg0.toString());
		Reporter.log("<br>P getTestName :" +arg0.getTestName());
		Reporter.log("<br>P getName : "+arg0+ " and "+arg0.getName());
		Reporter.log("<br>P getTestContext : "+arg0+ " and "+arg0.getTestContext());
		Reporter.log("<br>P getTestContext : "+arg0+ " and "+arg0.getTestContext());
		Reporter.log("P TestName="+arg0.getAttribute("name")+" ; TestResult="+arg0.getAttribute("status")+"<br>");*/
		Reporter.log("P TestCase executed successfully:TestName="+arg0.getMethod().getMethodName()+" ; TestResult=PASS<br>");
		System.out.println(arg0.getTestContext().getName());//Default Test
		
		System.out.println(arg0.getMethod().getMethodName());//validLoginTest
		
		}

}
