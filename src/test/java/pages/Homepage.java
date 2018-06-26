package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	public WebDriver driver;

	@FindBy(name="identifier")
	public WebElement uid;

	@FindBy(xpath="//*[text()='Next']")
	public WebElement uidnext;

	@FindBy(xpath="(//*[contains(text(),'find your Google Account')])[2]")
	public WebElement invaliduiderr;

	@FindBy(xpath="//*[text()='Enter an email or phone number']")
	public WebElement blankuiderr;

	public Homepage(WebDriver x)
	{
		this.driver=x;
		PageFactory.initElements(driver, this);
	}

	public void filluid(String x)
	{
		uid.sendKeys(x);
	}

	public void clickuidnext()
	{
		uidnext.click();
	}


}
