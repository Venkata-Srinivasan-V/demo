package BasicPkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class baseMethods {

	public WebDriver driver;
	
	@BeforeSuite
	public void drivers() throws IOException
	{
	  File file = new File("C://Users//seeni//eclipse-workspace//DDtrain//src//test//java//File//propertyData");
	  FileInputStream fis = new FileInputStream(file);
	  Properties pro= new Properties();
	  pro.load(fis);
	  
	  String browserName= pro.getProperty("browser");
	  System.out.println(browserName);
	  
	  if(browserName.equalsIgnoreCase("chrome") )
	  {
		  driver = new ChromeDriver();
	  }
	  else if(browserName.equalsIgnoreCase("edge"))
	  {
		  driver = new EdgeDriver();
	  }
	  else if(browserName.equalsIgnoreCase("firefox"))
	  {
		  driver = new FirefoxDriver();
	  }
	  else
	  {
		  System.out.println("please enter valid browser");
	  }
	  
	  
	  String url= pro.getProperty("url");
	  driver.get(url);
	  driver.manage().window().maximize();
	}
	
	
	public List<HashMap<String, String>> jsonread(String jsonfile) throws IOException
	{
		System.out.println("entered jsonread");
		//File jsonfile= new File("C://Users//seeni//eclipse-workspace//DDtrain//src//test//java//File//jsonData.json");
		String str= FileUtils.readFileToString(new File(jsonfile), StandardCharsets.UTF_8);
		
		ObjectMapper map= new ObjectMapper();
		List<HashMap<String,String>> Hashdata=map.readValue(str, new  TypeReference<List<HashMap<String,String>>>() {} );
		
		System.out.println(Hashdata);
		return Hashdata;
	}
	
	@AfterSuite
	public void closeDriver()
	{
		driver.quit();
	}
	
	
	
}


  
  	

