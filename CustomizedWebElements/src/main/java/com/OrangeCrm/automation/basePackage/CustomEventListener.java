package com.OrangeCrm.automation.basePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.OrangeCrm.automation.webElement.customElements.superElements.CustomWebElement;

public class CustomEventListener extends TestBase implements WebDriverEventListener{

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		Reporter.log("P Alert is displayed<br>");
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		Reporter.log("P Accepted the alert<br>");
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		Reporter.log("P Dismissed the alert<br>");
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		//Reporter.log("Going to dismiss the alert<br>");
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		//Reporter.log("Navigating to "+url+" <br>");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		Reporter.log("P Navigated to "+url+" <br>");
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		//Reporter.log("P Navigating back. <br>");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		Reporter.log("P Navigated back to "+driver.getCurrentUrl()+"<br>");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		//Reporter.log("P Element located by locator:"+element.toString()+"<br>");
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		//Reporter.log("P Clicked on the element by locator: "+element.toString()+"<br>");
		Reporter.log("P Clicked on the element by locator: "+element.toString().substring(element.toString().indexOf("->"))+"<br>");
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	

}
