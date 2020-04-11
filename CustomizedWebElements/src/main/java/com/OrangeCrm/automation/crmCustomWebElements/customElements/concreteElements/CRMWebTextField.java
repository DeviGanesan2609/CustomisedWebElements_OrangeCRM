package com.OrangeCrm.automation.crmCustomWebElements.customElements.concreteElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.OrangeCrm.automation.webElement.customElements.superElements.CustomWebElement;

/**
 * A text field.
 **/
public class CRMWebTextField extends CustomWebElement {

    /**
     * Constructor.
     *
     * @param webDriver The webDriver usd to interact with the webbrowser.
     * @param by        The locator used to identify the element(s) on the website.
     **/
    public CRMWebTextField(WebDriver webDriver, By by) {
        super(webDriver, by);
    }

    /**
     * Returns the text of this textfield.
     *
     * @return Returns the text of this textfield.
     **/
    public String getText() {
        return getAttribute("value");
    }

    /**
     * Sets the text of this textfield.
     *
     * @param text The text which should be inserted in this text field.
     **/
    public void setText(String text) {
        getWebDriver().findElement(getBy()).clear();
        getWebDriver().findElement(getBy()).sendKeys(text);
    }
    
    /**
     * enter String into textbox.
     **/
    public void sendKeys(String text) {
        getWebDriver().findElement(getBy()).clear();
        getWebDriver().findElement(getBy()).sendKeys(text);
    }
    
    /**
     * enter Integer into text box.
     **/
    public void sendKeys(int text) {
        getWebDriver().findElement(getBy()).clear();
        getWebDriver().findElement(getBy()).sendKeys("\""+text+"\"");
    }

    /**
     * Tries to submit by pressing enter.
     */
    public void submit() {
        getWebDriver().findElement(getBy()).sendKeys(Keys.ENTER);
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
        	Reporter.log("P Text Matched : Expected -"+expectedText+", Actual -"+actualText );
        }
        else
        {
        	Reporter.log("F Text Mismatch : Expected -"+expectedText+", Actual -"+actualText );
        }
    }
    
}
