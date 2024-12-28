package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	private WebDriver driver;

	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	public void submit(String emailId, String passwordString)
	{
		email.sendKeys(emailId);
		password.sendKeys(passwordString);
	}
	public void clearCredentials()
	{
		email.clear();
		password.clear();
	}
}
