package com.OrangeCrm.automation.webElement.customElements.concreteElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.OrangeCrm.automation.webElement.customElements.superElements.CustomWebElement;

/**
 * A checkbox.
 **/
public class CRMWebCheckbox extends CRMCustomWebElement {

    /**
     * Constructor.
     *
     * @param webDriver The webdriver usd to interact with the webbrowser.
     * @param by        The locator used to identify the element(s) on the website.
     **/
    public CRMWebCheckbox(WebDriver webDriver, By by) {
        super(webDriver, by);
    }

    /**
     * Returns true if the checkbox is checked, else false.
     *
     * @return Returns true if the checkbox is checked, else false.
     **/
    public boolean isChecked() {
        return getWebDriver().findElement(getBy()).isSelected();
    }

    /**
     * Checks the checkbox.
     **/
    public void check() {
        if (!isChecked()) {
            getWebDriver().findElement(getBy()).click();
        }
    }

    /**
     * Unchecks a checkbox.
     **/
    public void uncheck() {

        if (isChecked()) {
            getWebDriver().findElement(getBy()).click();
        }
        else
        {
        	Reporter.log("Failed to uncheck since not checked already<br>");
        }
    }
}