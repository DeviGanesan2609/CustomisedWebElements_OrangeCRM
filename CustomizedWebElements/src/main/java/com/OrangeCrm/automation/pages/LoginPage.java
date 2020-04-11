package com.OrangeCrm.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.OrangeCrm.automation.basePackage.TestBase;
import com.OrangeCrm.automation.webElement.customElements.concreteElements.CRMWebButton;
import com.OrangeCrm.automation.webElement.customElements.concreteElements.CRMWebPageElement;
import com.OrangeCrm.automation.webElement.customElementsDecorator.CustomElementFieldDecorator;

public class LoginPage extends TestBase{

/*	@FindBy(xpath="//input[@id='txtUsername']")
	public WebElement textBoxUserName;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	public WebElement textBoxPassword;

	@FindBy(xpath="//input[@id='btnLogin']")
	public WebElement buttonLogin;
	
	@FindBy(xpath="//span[@id='spanMessage']")
	public WebElement errorInvalidCredential;*/
	
	
	/****   CRM WEB ELEMENTS *********/
	@FindBy(xpath="//input[@id='txtUsername']")
	public CRMWebPageElement textBoxUserName;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	public CRMWebPageElement textBoxPassword;

	@FindBy(xpath="//input[@id='btnLogin']")
	public CRMWebButton buttonLogin;
	
	@FindBy(xpath="//span[@id='spanMessage']")
	public CRMWebPageElement errorInvalidCredential;
	
	public LoginPage()
	{
		//PageFactory.initElements(driver, this);
		 PageFactory.initElements(new CustomElementFieldDecorator(webDriver, webDriver), this);
	}
	
	public void invoke()
	{
		webDriver.get(prop.getProperty("url"));
	}
	
	public void waitForPageToLoad()
	{
		textBoxUserName.waitForVisible(10000);
		Reporter.log("P "+ this.getClass().getSimpleName()+" has been successfully loaded <br>");
	}
	
	public void waitForPageToLoad(int milliSeconds)
	{
		textBoxUserName.waitForVisible(milliSeconds);
		Reporter.log("P "+this.getClass().getSimpleName()+" has been successfully loaded <br>");
	}
}
