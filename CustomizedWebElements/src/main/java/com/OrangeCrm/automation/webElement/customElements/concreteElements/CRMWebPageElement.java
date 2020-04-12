package com.OrangeCrm.automation.webElement.customElements.concreteElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.OrangeCrm.automation.webElement.customElements.superElements.CustomWebElement;

import java.util.List;

public class CRMWebPageElement extends CRMCustomWebElement {

    /**
     * Constructor.
     *
     * @param webDriver The webDriver usd to interact with the webbrowser.
     * @param by        The locator used to identify the element(s) on the website.
     **/
    public CRMWebPageElement(WebDriver webDriver, By by) {
        super(webDriver, by);
    }

    

    /**
     * Sets the text of the element.
     **/
    public void setText(String text) {
        getWebDriver().findElement(getBy()).clear();
        getWebDriver().findElement(getBy()).sendKeys(text);
    }
    
    /**
     * enter String.
     **/
    public void sendKeys(String text) {
        getWebDriver().findElement(getBy()).clear();
        getWebDriver().findElement(getBy()).sendKeys(text);
    }

    /**
     * Finds an element which uses the locator of this element as base.
     *
     * @return The found sub web element of this complex web element.
     **/
    public WebElement findElement(By locator) {
        return getWebDriver().findElement(getBy()).findElement(locator);
    }

    /**
     * Finds elements which uses the locator of this element as base.
     *
     * @return The found sub web elements of this complex web element.
     **/
    public List<WebElement> findElements(By locator) {
        return getWebDriver().findElement(getBy()).findElements(locator);
    }
    
 /*   *//**
     * Clicks on the button.
     **//*
    public void click() {
        getWebDriver().findElement(getBy()).click();
        
    }
    *//**
     * Returns the node text of the element.
     *
     * @return Returns the node text of the element.
     **//*
    public String getText() {
        
    	String innerText=  getWebDriver().findElement(getBy()).getText();
        Reporter.log("P "+getBy().toString()+": The text is:"+innerText+"<br>");
    	return innerText;
    }
    
    *//**
     * Verifies the node text of the element.
     *
     * @return Returns the node text of the element.
     **//*
    public void verifyText(String expectedText) {
        String actualText = getWebDriver().findElement(getBy()).getText();
        if(actualText.equals(expectedText))
        {
        	Reporter.log("P Text Matched by locator:"+getBy().toString()+". Expected -"+expectedText+", Actual -"+actualText +"<br>");
        }
        else
        {
        	Reporter.log("F Text Mismatched by locator:"+getBy().toString()+".  Expected -"+expectedText+", Actual -"+actualText +"<br>");
        }
    }
    
    *//***
     * 
     * Wait for the element to be visible for the given milliSeconds
     * @param milliSeconds	Time to wait in milliSeconds 
     * **//*
    public void waitForVisible(int milliSeconds)
    {	
    	int seconds = milliSeconds/1000;
    	WebDriverWait wait = new WebDriverWait(getWebDriver(),seconds);
		wait.until(ExpectedConditions.visibilityOf(getWebDriver().findElement(getBy())));
		
    }
    
    *//**
     * get the value of Attribute 'value'.
     **//*
    public void getValue() {
      String value=  getWebDriver().findElement(getBy()).getAttribute("value");
        Reporter.log("P value of element by locator:"+getBy().toString()+": The text is:"+value+"<br>");
    }
    *//**
     * Verifies the node value of the element.
     *
     * @return Returns the node value of the element.
     **//*
    public void verifyValue(String expectedText) {
        String actualText = getWebDriver().findElement(getBy()).getAttribute("value");
        if(actualText.equals(expectedText))
        {
        	Reporter.log("P Value Matched by locator:"+getBy().toString()+". Expected -"+expectedText+", Actual -"+actualText +"<br>");
        }
        else
        {
        	Reporter.log("F Value Mismatched by locator:"+getBy().toString()+".  Expected -"+expectedText+", Actual -"+actualText +"<br>");
        }
    }*/
     
}