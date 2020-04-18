package com.OrangeCrm.automation.testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OrangCrm.dataDriven.DataDriven;
import com.OrangeCrm.automation.basePackage.CustomTestListener;
import com.OrangeCrm.automation.basePackage.TestBase;
import com.OrangeCrm.automation.pages.LoginPage;
import com.OrangeCrm.automation.pages.WelcomePage;
import com.OrangeCrm.automation.webElement.customElementsDecorator.CustomElementFieldDecorator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Listeners({CustomTestListener.class})
public class LoginTest extends TestBase{
	
	@Test
	public void TC001_blankUserNamePassword()
	{
		LoginPage loginPage =new LoginPage();
		loginPage.invoke();
		loginPage.waitForPageToLoad();
		
		loginPage.textBoxUserName.sendKeys("");
		loginPage.textBoxPassword.sendKeys("");
		loginPage.buttonLogin.click();
	
		loginPage.errorInvalidCredential.verifyText("Username cannot be empty");
		
	}
	
	@Test
	public void TC002_blankUserName()
	{
		LoginPage loginPage =new LoginPage();
		loginPage.invoke();
		loginPage.waitForPageToLoad();
		
		loginPage.textBoxPassword.sendKeys("Test");
		loginPage.buttonLogin.click();
	
		loginPage.errorInvalidCredential.verifyText("Username cannot be empty");
		
	}
	
	@Test
	public void TC003_blankPassword()
	{
		LoginPage loginPage =new LoginPage();
		loginPage.invoke();
		loginPage.waitForPageToLoad();
		
		loginPage.textBoxUserName.sendKeys("Test");
		loginPage.textBoxPassword.sendKeys("");
		loginPage.buttonLogin.click();
	
		loginPage.errorInvalidCredential.verifyText("Password cannot be empty");
		
	}
	
	@Test
	public void TC004_validLoginTest()
	{
		LoginPage loginPage =new LoginPage();
		loginPage.invoke();
		loginPage.waitForPageToLoad();
		
		loginPage.textBoxUserName.sendKeys("Admin");
		loginPage.textBoxPassword.sendKeys("admin123");
		
		loginPage.buttonLogin.verifyValue("LOGIN");
		loginPage.buttonLogin.click();
		
		WelcomePage welcomePage = new WelcomePage();
		welcomePage.waitForPageToLoad();
	}
	
	@Test
	public void TC005_validateMultiLogin() throws FileNotFoundException, IOException, ParseException
	{
		//String dataFile ="C:\\Users\\user\\Desktop\\LEARNING-Devi\\FreeCRmWorkSpace\\CustomizedWebElements\\resources\\Data2.json";
		String dataFile ="C:\\Users\\user\\Desktop\\LEARNING-Devi\\Git Local Repos\\CustomisedWebElements_OrangeCRM\\CustomizedWebElements\\resources\\Data2.json";
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
		loginPage.buttonLogin.verifyValue("LOGIN");
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
	
	@Test(dataProvider ="testcaseData",dataProviderClass=DataDriven.class)
	public void validateDataProvider(Map<String,Object> data)
	{
		System.out.println(data);
		System.out.println(data.get("userName"));
		System.out.println(data.get("password"));
	}
	
	
	
	

}
