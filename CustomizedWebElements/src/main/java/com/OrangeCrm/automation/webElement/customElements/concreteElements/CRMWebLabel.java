package com.OrangeCrm.automation.webElement.customElements.concreteElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.OrangeCrm.automation.webElement.customElements.superElements.CustomWebElement;

/**
 * A label.
 **/
public class CRMWebLabel extends CRMCustomWebElement {

    /**
     * Constructor.
     *
     * @param webDriver The webDriver usd to interact with the webbrowser.
     * @param by        The locator used to identify the element(s) on the website.
     **/
    public CRMWebLabel(WebDriver webDriver, By by) {
        super(webDriver, by);
    }

	/* ----- Methods ----- */

    /**
     * Returns the text of the label.
     **//*
    public String getText() {
        return getWebDriver().findElement(getBy()).getText();
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
        	Reporter.log("P Text Matched : Expected -"+expectedText+", Actual -"+actualText );
        }
        else
        {
        	Reporter.log("F Text Mismatch : Expected -"+expectedText+", Actual -"+actualText );
        }
    }*/
    
}