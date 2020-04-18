package com.OrangCrm.dataDriven;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.OrangeCrm.automation.basePackage.TestBase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataDriven extends TestBase {

	@DataProvider(name="testcaseData")
	public Object[][] fetchTestData(Method m)
	{	
		String dataFile ="C:\\Users\\user\\Desktop\\LEARNING-Devi\\Git Local Repos\\CustomisedWebElements_OrangeCRM\\CustomizedWebElements\\resources\\Data2.json";
		//String dataFile ="C:\\Users\\user\\Desktop\\LEARNING-Devi\\Git Local Repos\\CustomisedWebElements_OrangeCRM\\CustomizedWebElements\\resources\\Data2.json";
		Map<String,Object> map1 = null;
		Map<String,Object> map2 = null;
		jsonMapper = new ObjectMapper();
		try{
			 map1 = jsonMapper.readValue(new File(dataFile), new TypeReference<Map<String, Object>>() {});
			 map2 = jsonMapper.convertValue(map1.get(m.getName()), new TypeReference<Map<String, Object>>() {});
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//System.out.println("Method M :"+m);
		System.out.println("Method M name :"+m.getName());
		System.out.println("Map1 from DP :"+map1);
		System.out.println("Map1.get(m.getName()) :"+map1.get(m.getName()));
		System.out.println("Map2 from DP :"+map2);
		return new Object[][]{{map2}};
		
	}
	
}
