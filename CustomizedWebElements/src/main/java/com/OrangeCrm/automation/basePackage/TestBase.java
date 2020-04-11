package com.OrangeCrm.automation.basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.OrangeCrm.automation.webElement.customElements.superElements.CustomWebElement;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;


public class TestBase  {
	
	

	public static WebDriver webDriver;
	public static Properties prop;
	public static WebDriverWait wait;

	
	@BeforeMethod
	public void initialization()
	{	
		try{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\LEARNING-Devi\\FreeCRmWorkSpace\\CustomizedWebElements\\chromedriver.exe");
			webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\user\\Desktop\\LEARNING-Devi\\FreeCRmWorkSpace\\CustomizedWebElements\\resources\\orangeCrm.properties"));
		prop = new Properties();
		prop.load(fis);
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
			
	}
	
	@AfterMethod
	public void tearDown()
	{
		webDriver.quit();
	}
	
	
	
	public static void getDataFromMap(String testName,String jsonFilePath) 
	{
		JSONParser jsonPaser = new JSONParser();	
		try{
		/*Object obj = jsonPaser.parse(new FileReader(jsonFilePath));
	    JSONObject jsonObject = (JSONObject) obj;*/
	    
	    JSONObject jsonObject = (JSONObject) jsonPaser.parse(new FileReader(jsonFilePath));
	    
	    JSONArray solutions = (JSONArray) jsonObject.get("TestData");
	    System.out.println("solutions:"+solutions);
	    Map<String,Object> map =new HashMap<String,Object>();
	    for(int i=0;i<solutions.size();i++)
	    {
	    	JSONObject mainObject = (JSONObject) solutions.get(i);
	    	System.out.println(mainObject);
	    
	    	for (Object key : mainObject.keySet()) {
	            JSONObject innerJsonObj = (JSONObject) mainObject.get(key);
	            
	            Map<String, String> innerMap = new HashMap();
	            System.out.println("key set"+innerJsonObj.keySet());
	            for(Object split:innerJsonObj.keySet()){
	            	innerMap.put((String) split, innerJsonObj.get(split).toString());
	            }
	            System.out.println("InnerMap:"+innerMap);
		    	map.put((String)key, innerMap);
	         }
	    }
	    
	    System.out.println("Final map:"+map);
	    System.out.println("test case 1:"+map.get("validateMultiLogin"));
	    System.out.println("test case 2:"+map.get("secondTc"));
	    
	    Map<String, String> returnMap = (Map<String, String>) map.get("secondTc");
	    System.out.println(returnMap);

	   /* JsonPath jsonData = new JsonPath(solutions.toString());
	    System.out.println(jsonData.get("secondTc"));
	    System.out.println(jsonData.get("validateMultiLogin"));
	    System.out.println(jsonData.get("data"));*/
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
	    catch(ParseException pe)
		{
	    	pe.printStackTrace();
		}
	}
	
	public static void getTestDataFromMap(String testMethodName,String dataFilePath) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(new FileReader(dataFilePath));
		System.out.println("json Object :"+jsonObject);
		System.out.println("value of validateMultiLogin : "+jsonObject.get("validateMultiLogin"));
		System.out.println("value of secondTC : "+jsonObject.get("secondTC"));
		
		JSONObject obj2 = (JSONObject) jsonObject.get("validateMultiLogin");
		System.out.println("User Names :"+obj2.get("userName"));
		System.out.println("Password : "+obj2.get("password"));
	}
	
	public static void getTestDataFromJson(String testMethodName,String dataFilePath) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(new FileReader(dataFilePath));
		Map<String,String> map = new HashMap<String,String>();		
		JSONObject obj2 = (JSONObject) jsonObject.get(testMethodName);
		/*System.out.println("User Names :"+obj2.get("userName"));
		System.out.println("Password : "+obj2.get("password"));
		
		System.out.println(obj2.entrySet());
		System.out.println(obj2.keySet());*/
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,String> map2 = mapper.convertValue(obj2, new TypeReference<Map<String, String>>() {});
		System.out.println(map2);
	}
	//correct one
	public static Map<String,String> getTestData(String testMethodName,String dataFilePath) throws FileNotFoundException, IOException, ParseException
	{	
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map1 = mapper.readValue(new File(dataFilePath), new TypeReference<Map<String, Object>>() {});
		System.out.println(map1);
		Map<String,String> map2 = mapper.convertValue(map1.get(testMethodName), new TypeReference<Map<String, String>>() {});
		System.out.println(map2);
		
		return map2;
	}	
	
	public static Map<String,Object> getTestData2(String testMethodName,String dataFilePath) throws FileNotFoundException, IOException, ParseException
	{	
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map1 = mapper.readValue(new File(dataFilePath), new TypeReference<Map<String, Object>>() {});
		Map<String,Object> map2 = mapper.convertValue(map1.get(testMethodName), new TypeReference<Map<String, Object>>() {});
			
		return map2;
	}
	
	public static String getCurrentUrl()
	{
		return webDriver.getCurrentUrl();
	}

}
