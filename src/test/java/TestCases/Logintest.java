package TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import BasicPkg.baseMethods;
import pages.loginPage;

public class Logintest extends baseMethods {

	
	@Test
	@Parameters({"email", "password"})
	public void credentials(String emailParameter, String passwordParameter) throws InterruptedException
	{
		System.out.println("entered test case");
		loginPage login= new loginPage(driver);
		
		// using normal string for data
		login.submit("venkat@gmail.com", "Seenithala@24");
		Thread.sleep(1500);
		login.clearCredentials();
		Thread.sleep(1500);
		
		// using parameter testng for data
		login.submit(emailParameter, passwordParameter);
		Thread.sleep(1000);
		login.clearCredentials();
		Thread.sleep(1000);
		
		
	}
	
	@Test(dataProvider ="jsonInputdata")
	public void credentialsUsingJson(HashMap<String, String> json) throws InterruptedException
	{
		// using json file for  data
		System.out.println("entered json file execution");
		loginPage login= new loginPage(driver);
		//using json file
		login.submit(json.get("email"), json.get("password"));
		Thread.sleep(1000);
		login.clearCredentials();
		Thread.sleep(1000);
		//hehehe
		
	}
	@Test
	public  void getDataFromExcel() throws IOException, InterruptedException
	{
		loginPage login= new loginPage(driver);
		//using excel file
		String email=excelData(1,1);
		String password=excelData(2,1);
		login.submit(email,password);
		Thread.sleep(1500);
		
	}
	
	@DataProvider
	public Object[][] jsonInputdata() throws IOException
	{
		System.out.println("entered data provider");
		String fileLocation="C://Users//seeni//eclipse-workspace//DDtrain//src//test//java//File//jsonData.json";
		List<HashMap<String, String>> data= jsonread(fileLocation);
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
}
