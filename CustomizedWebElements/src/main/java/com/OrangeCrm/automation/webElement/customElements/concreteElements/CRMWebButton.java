package com.OrangeCrm.automation.webElement.customElements.concreteElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.OrangeCrm.automation.webElement.customElements.superElements.CustomWebElement;

/**
 * A button.
 **/
public class CRMWebButton extends CustomWebElement {

    /**
     * Constructor.
     *
     * @param webDriver The webdriver usd to interact with the webbrowser.
     * @param by        The locator used to identify the element(s) on the website.
     **/
    public CRMWebButton(WebDriver webDriver, By by) {
        super(webDriver, by);
       // Reporter.log("P Located the element by locator :"+getBy().toString()+"<br>");
    }

     /**
     * Clicks on the button.
     **/
    public void click() {
        getWebDriver().findElement(getBy()).click();
       // Reporter.log("P Clicked on Element by locator: "+getBy().toString()+"<br>");
    }
    
    /**
     * get button text.
     **/
    public void getText() {
      String innerText=  getWebDriver().findElement(getBy()).getText();
        Reporter.log("P "+getBy().toString()+": The text is:"+innerText+"<br>");
    }
    
    /**
     * get the value of Attribute 'value'.
     **/
    public void getValue() {
      String value=  getWebDriver().findElement(getBy()).getAttribute("value");
        Reporter.log("P value of element by locator:"+getBy().toString()+": The text is:"+value+"<br>");
    }
    
    /**
     * Verifies the node text of the element.
     *
     * @return Returns the node text of the element.
     **/
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
    /**
     * Verifies the node value of the element.
     *
     * @return Returns the node value of the element.
     **/
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
    }
}