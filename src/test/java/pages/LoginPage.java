package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
public WebDriver driver;
	
	@FindBy(name="password")
	public WebElement pwd;
	
	@FindBy(xpath="//*[text()='Next']")
	public WebElement pwdNext;
	
	@FindBy(xpath="//*[contains(text(),'Wrong password')]")
	public WebElement invalidpwderr;
	
	@FindBy(xpath="//*[text()='Enter a password']")
	public WebElement blankpwderr;
	
	public LoginPage(WebDriver x)
	{
		this.driver=x;
		PageFactory.initElements(driver, this);
	}
	
	public void fillpwd(String x)
	{
		pwd.sendKeys(x);
	}
	
	public void clickpwdNext()
	{
		pwdNext.click();
	}


}
