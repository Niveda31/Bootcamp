package testcases;

import java.awt.AWTException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;


	public class AssessmentTestCase extends PreAndPost{

		@BeforeTest
		public void setData() {
			testCaseName="AssessmentTestCase";
			testDescription="Files";
			authors="Niveda";
			category="Regression";
			nodes="ServiceConsole";
			//dataSheetName="Data";
		}
		
		@Test
		public void checkFiles() throws InterruptedException, AWTException {
			new LoginPage(driver, test)
			.typeUserName("nupela@testleaf.com")
			.typePassword("Bootcamp$123")
			.clickLogin()
			.clickToggleMenu()
			.clickViewAll()
			.clickServiceConsole()
			.clickDropDown()
			.selectFiles()
			.clickUploadFiles()
			.enterFilePath()
			.clickDone()
			.clickDropDownForNewlyUploadedFile()
			.selectViewFileDetails()
			.verifyFileNameAndExtension()
			.closeFileWindow()
			.clickLatestModifiedItemLink()
			.clickShare()
			.clickSearchUser()
			.selectUser()
			.verifyErrorMessage()
			.clickCancelShare()
			.closeItemDialog()
			.clickDropDownForNewFile()
			.clickDelete()
			.confirmDelete()
			.verifySuccessMessage();
			
		}
}

