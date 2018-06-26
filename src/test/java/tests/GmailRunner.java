package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"D:\\kiran\\SELENIUM\\eclipse-workspace\\gmailBDD\\src\\test\\resources\\gmailresources\\gmail.feature"}, plugin= {"pretty", "html:target"}, monochrome=true)

public class GmailRunner {

}
