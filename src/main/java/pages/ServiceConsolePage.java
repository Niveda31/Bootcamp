package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class ServiceConsolePage extends PreAndPost{
	
	public ServiceConsolePage(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
	}
	


	public ServiceConsolePage clickDropDown()
	{
		click(locateElement("xpath","//button[@title='Show Navigation Menu']"));
		return this;
	}
	public ServiceConsolePage selectFiles()
	{
		click(locateElement("xpath","//span[text()='Files']"));
		return this;
	}
	public ServiceConsolePage clickUploadFiles()
	{
		Actions builder = new Actions(this.driver);
		WebElement uploadFiles=locateElement("xpath","//div[text()='Upload Files']");
		builder.moveToElement(uploadFiles).click().perform();
		return this;
	}
	public ServiceConsolePage enterFilePath() throws InterruptedException, AWTException
	{
		Thread.sleep(5000);
		StringSelection stringSelection = new StringSelection("C:\\Pictures\\Nature.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		// Paste it using Robot class
		Robot robot = new Robot();

		// Enter to confirm it is uploaded
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
		return this;
	}
	// finish download
	public ServiceConsolePage clickDone() throws InterruptedException
	{
		Actions builder1 = new Actions(driver);
		WebElement doneClick = locateElement("xpath","//span[text()='Done']");
		builder1.moveToElement(doneClick).click().perform();
		Thread.sleep(3000);
		return this;
	}
	public ServiceConsolePage clickDropDownForNewlyUploadedFile()
	{
		click(locateElement("xpath","//div[@data-aura-class='forceVirtualAction']/a"));
		return this;
	}
	public ServiceConsolePage selectViewFileDetails()
	{
		click(locateElement("xpath","//a[@title='View File Details']"));
		return this;
	}
	public ServiceConsolePage verifyFileNameAndExtension()
	{
		String fileName = getText(locateElement("xpath","//div[text()='File']/following::span"));
		System.out.println(fileName);
		String fileExtension = getText(locateElement("xpath","//span[@title='File Extension']/following::span"));
		System.out.println(fileExtension);
		Assert.assertEquals(fileName, "Nature");
		Assert.assertEquals(fileExtension, "jpg");
		return this;
	}

	public ServiceConsolePage closeFileWindow()
	{
		click(locateElement("xpath","//div[@class='close slds-col--bump-left slds-p-left--none slds-context-bar__icon-action ']"));
		return this;
	}
	public ServiceConsolePage clickLatestModifiedItemLink()
	{
		click(locateElement("xpath","(//div[@class='slds-truncate']//span)[1]"));
		return this;
	}
	public ServiceConsolePage clickShare()
	{
		click(locateElement("xpath","//button[@title='Share']"));
		return this;
	}
	public ServiceConsolePage clickSearchUser()
	{
		click(locateElement("xpath","//input[@title='Search People']"));
		return this;
	}
	public ServiceConsolePage selectUser()
	{
		click(locateElement("xpath","//div[text()='Derrick Dsouza']"));
		return this;
	}
	public ServiceConsolePage verifyErrorMessage()
	{
		String errorMessage = getText(locateElement("xpath","//li[@class='form-element__help']"));
		Assert.assertEquals(errorMessage, "Can't share file with the file owner.");
		return this;
	}
	public ServiceConsolePage clickCancelShare()
	{
		click(locateElement("xpath","(//span[text()='Cancel'])[2]"));
		return this;
	}
	public ServiceConsolePage closeItemDialog()
	{
		click(locateElement("xpath","//button[@title='Close']"));
		return this;
	}
	public ServiceConsolePage clickDropDownForNewFile()
	{
		
		click(locateElement("xpath","//li[@class='oneActionsDropDown']//a"));
		return this;
	}
	public ServiceConsolePage clickDelete()
	{
		click(locateElement("xpath","//a[@title='Delete']"));
		return this;
	}
	public ServiceConsolePage confirmDelete()
	{
		click(locateElement("xpath","//span[text()='Delete']"));
		return this;
	}
	public ServiceConsolePage verifySuccessMessage()
	{
		String successMessage = getText(locateElement("xpath","//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		if(successMessage.contains("deleted"))
			System.out.println("The deleted message is displayed as expected");
		else
			System.err.println("The deleted message is not displayed");
		return this;
	}
}
