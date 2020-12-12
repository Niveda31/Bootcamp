package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class HomePage extends PreAndPost{

	public HomePage(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
	}
	
	public HomePage clickToggleMenu()
	{
		click(locateElement("xpath","//div[@class='slds-icon-waffle']"));
		return this;
	}
	public AppLauncherPage clickViewAll()
	{
		click(locateElement("xpath","//button[text()='View All']"));
		return new AppLauncherPage(driver, test);
	}
}
