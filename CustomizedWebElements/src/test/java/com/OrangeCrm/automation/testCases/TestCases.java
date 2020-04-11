package com.OrangeCrm.automation.testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OrangeCrm.automation.basePackage.TestBase;
import com.OrangeCrm.automation.pages.LoginPage;
import com.OrangeCrm.automation.pages.WelcomePage;
import com.OrangeCrm.automation.webElement.customElementsDecorator.CustomElementFieldDecorator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class TestCases extends TestBase{
	
	@Test
	public void testCustomeWebElement() throws InterruptedException
	{
		LoginPage loginPage =new LoginPage();
		loginPage.invoke();
		loginPage.waitForPageToLoad();
				
		loginPage.buttonLogin.click();
		Thread.sleep(20000);
		System.out.println("Clicked on Login Button");
		
	}
	
	@Test
	public void validateMultiLogin() throws FileNotFoundException, IOException, ParseException
	{
		String dataFile ="C:\\Users\\user\\Desktop\\LEARNING-Devi\\FreeCRmWorkSpace\\CustomizedWebElements\\resources\\Data2.json";
		String testMethod ="validateMultiLogin";
		
		Map<String,Object> data =getTestData2(testMethod,dataFile);
		ArrayList<String> users =  (ArrayList) data.get("users");
		ArrayList<String> passwords =(ArrayList)data.get("passwords");
		/*System.out.println(users);
		System.out.println(passwords);*/
		for(int i=0;i<users.size();i++){
		LoginPage loginPage =new LoginPage();
		loginPage.invoke();
		loginPage.waitForPageToLoad(30);
		
		loginPage.textBoxUserName.sendKeys(users.get(i));
		loginPage.textBoxPassword.sendKeys(passwords.get(i));
		
		loginPage.buttonLogin.click();
		
		WelcomePage welcomePage = new WelcomePage();
	//	PageFactory.initElements(new CustomElementFieldDecorator(driver, driver), welcomePage);
	//	welcomePage.waitForPageToLoad();
		if(getCurrentUrl().contains("dashboard"))
		{
			Reporter.log("Valid Credential : "+users.get(i)+" & "+passwords.get(i)+"<br>"  );
			welcomePage.waitForPageToLoad();
		}
		else
		{
			Reporter.log("Invalid Credentials : "+users.get(i)+" & "+passwords.get(i)+"<br>"  );
		}
		}
	}
	
	@Test
	public void validLoginTest()
	{
		LoginPage loginPage =new LoginPage();
		loginPage.invoke();
		loginPage.waitForPageToLoad();
		
		loginPage.textBoxUserName.sendKeys("Admin");
		loginPage.textBoxPassword.sendKeys("admin123");
		loginPage.buttonLogin.click();
		
		WelcomePage welcomePage = new WelcomePage();
		welcomePage.waitForPageToLoad();
	}

}
