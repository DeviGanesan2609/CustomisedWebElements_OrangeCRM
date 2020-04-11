package com.OrangeCrm.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.OrangeCrm.automation.basePackage.TestBase;
import com.OrangeCrm.automation.webElement.customElements.concreteElements.CRMWebPageElement;
import com.OrangeCrm.automation.webElement.customElementsDecorator.CustomElementFieldDecorator;
import com.OrangeCrm.automation.webElement.customElementsDecorator.CustomElementLocator;

public class WelcomePage extends TestBase{
	
	/*@FindBy(xpath="//a[@id='welcome']")
	public WebElement textWelcome;*/
	
	/*************** CRM CUSTOM WEB ELEMENTS**************/
	
	@FindBy(xpath="//a[@id='welcome']")
	public CRMWebPageElement textWelcome;
	
	@FindBy(xpath="//h1[text()='Dashboard']")
	public CRMWebPageElement headerDashboard;
	
	
	
	public WelcomePage()
	{
		//System.out.println("welcomr page constructor");
		//PageFactory.initElements(webDriver, this);
	PageFactory.initElements(new CustomElementFieldDecorator(webDriver, webDriver), this);
		
		//PageFactory.initElements((WebDriver) new CustomElementLocator(webDriver.findElement(getBy())), this);
	}
	
	public void waitForPageToLoad()
	{	
		//System.out.println("welcome page wait");
		//textWelcome.waitForVisible(20000);
		headerDashboard.waitForVisible(50000);
		Reporter.log(this.getClass().getSimpleName()+" has been successfully loaded <br>");
	}
	
	public void waitForPageToLoad(int milliSeconds)
	{
	
		textWelcome.waitForVisible(milliSeconds);
		Reporter.log(this.getClass().getSimpleName()+" has been successfully loaded <br>");
	}
}
