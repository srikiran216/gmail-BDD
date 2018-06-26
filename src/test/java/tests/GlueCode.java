package tests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Homepage;
import pages.LoginPage;
import pages.MailBoxPage;

public class GlueCode
{
	public WebDriver driver;
	public Homepage hp;
	public LoginPage lp;
	public MailBoxPage mp;
	public Scenario s;
	public Properties pro;
	public WebDriverWait w;
	@Before
	public void method1(Scenario x) throws Exception
	{
		//use scenario object for current scenario
		this.s=x;
		//load properties file for current scenario
		pro=new Properties();
		FileInputStream fip=new FileInputStream("D:\\kiran\\SELENIUM\\eclipse-workspace\\gmailBDD\\src\\test\\resources\\gmailresources\\gmail.properties");
		pro.load(fip);
		//open browser for current scenario
		System.setProperty("webdriver.chrome.driver", pro.getProperty("cdpath"));
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//create page objects for current scenario
		hp=new Homepage(driver);
		lp=new LoginPage(driver);
		mp=new MailBoxPage(driver);
		w=new WebDriverWait(driver, 30);
	}
	
	@Given("^launch gmail site$")
	public void method2()
	{
		driver.get(pro.getProperty("url"));
	}
	
	@Then("^validate title with \"(.*)\" value$")
	public void method3(String x)
	{
		if(driver.getTitle().equalsIgnoreCase(x))
		{
			s.write("Title test was passed");
		}
		else
		{
			byte[] src=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(src, "Title test was Failed");
		}
	}
	
	@And("^close site$")
	public void method4()
	{
		driver.close();
	}
	
	@When("^enter userid with \"(.*)\" value$")
	public void method5(String x)
	{
		hp.filluid(x);
	}
	
	@And("^click next button$")
	public void method6() throws Exception
	{
		hp.clickuidnext();
		
	}
	
	@Then("^validate userid field with \"(.*)\" value$")
	public void method7(String criteria)
	{
		if(criteria.equalsIgnoreCase("valid") && lp.pwd.isDisplayed())
		{
			s.write("valid userID test was passed");
		}
		else if(criteria.equalsIgnoreCase("invalid") && hp.invaliduiderr.isDisplayed())
		{
			s.write("invalid userID test was passed");
		}
		else if(criteria.equalsIgnoreCase("blank") && hp.blankuiderr.isDisplayed())
		{
			s.write("blank userID test was passed");
		}
		else
		{
			System.out.println("kiraN");
			byte[] src=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(src, "userID validation test was Failed");
		}
		
	}
	
	@And("^enter password with \"(.*)\" value$")
    public void method8(String p)
    {	
		w.until(ExpectedConditions.visibilityOf(lp.pwd));
    	lp.fillpwd(p);
    }
	
	@And("^click password next button$")
	public void method9()
	{
		lp.clickpwdNext();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='COMPOSE'])|(//*[contains(text(),'Wrong password')])|(//*[text()='Enter a password'])")));
		
	}
	
	@Then("^validate password field with \"(.*)\" value$")
	public void method10(String criteria)
	{
		if(criteria.equalsIgnoreCase("valid") && mp.comp.isDisplayed())
		{
			s.write("valid password test passed");
		}
		else if(criteria.equalsIgnoreCase("invalid") && lp.invalidpwderr.isDisplayed())
		{
			s.write("invalid password test passed");
		}
		else if(criteria.equalsIgnoreCase("blank") && lp.blankpwderr.isDisplayed())
		{
			s.write("blank password test passed");
		}
		else
		{
			byte[] src=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(src, "password validation test was Failed");
		}
		
	}



}
