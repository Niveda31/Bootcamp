package lib.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import lib.utils.DataInputProvider;

public class PreAndPost extends WebDriverServiceImpl {

	public String dataSheetName;
	public String pwd = "Bootcamp$123";
	 

	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}

	@BeforeClass
	public void beforeClass() {
		startTestCase(testCaseName, testDescription);
	}

	@BeforeMethod
	@Parameters("browser")

 	public void beforeMethod(String browserName) {

		// for reports
		startTestModule(nodes);// each data row -> one testcase
		test.assignAuthor(authors);
		test.assignCategory(category);
		startApp(browserName);

	}


	@AfterMethod
	public void afterMethod() {
		closeActiveBrowser();
	}

	@AfterSuite
	public void afterSuite() {
		endResult();// write report
	}

	@DataProvider(name = "fetchData")
	public Object[][] getData() {
		return DataInputProvider.getSheet(dataSheetName);
 
	}

}
