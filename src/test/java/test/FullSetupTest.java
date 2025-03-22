package test;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Pages.AgentPage;
import com.Pages.CSVUploadPage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.RegistrationPage;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;



public class FullSetupTest extends Base_Class {
	Log log;
	com.Utility.ScreenShot screenShot;
	com.Utility.ExcelReader ExcelReader;
	AgentPage Agentpage = new AgentPage();
	LoginPage Loginpage = new LoginPage();
	DashboardPage Dashboardpage =new DashboardPage();
	CSVUploadPage CSVUploadpage =new CSVUploadPage();
	Base_Class Base_Class = new Base_Class();

//	@Override
//	public WebDriver getDriver() {
//		//		homepage = new com.pages.HomePage(driver);
//		return driver;
//	}



	By signInButtonClass = By.className("btnSignIn");
	By signout = By.xpath("//a[@class=\"dropdownMenu user-details-menuSection dropdownArrowMenu\"]");
	By signoutbtn = By.xpath("//*[@id='dropdownMenuListSec']//a[contains(text(),'Sign Out')]");
	By signoutInshura = By.xpath("//div[@class=\"signoutsec\"]");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("FullSetupTest");
		log = new Log();
		screenShot = new com.Utility.ScreenShot(null);
		
	}

	

	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws Throwable {
		try {
			testdata.get("TestScenario").toString();
			String Username=testdata.get("Username").toString();
			String password=testdata.get("Password").toString();
			String Your_Name=testdata.get("Your_Name").toString();
			String Your_Name1=testdata.get("Your_Name1").toString();
			String Your_Email=testdata.get("Your_Email").toString();
			String Your_Password=testdata.get("Your_Password").toString();
			String ListName=testdata.get("ListName").toString();
			String WhatsappNo=testdata.get("WhatsappNo").toString();
			String FirstColumn=testdata.get("FirstColumn").toString();
			String SecondColumn=testdata.get("SecondColumn").toString();
			String ThirdColumn=testdata.get("ThirdColumn").toString();
			
					

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				System.out.println("<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				
				Base_Class.SetUp();
				
				Loginpage.LoginToApplication(Username,password);
				
				Dashboardpage.NavigateToAgentTab();
				
				Agentpage.AddAgent(Your_Name, WhatsappNo, Your_Email, Your_Password);
				
				Agentpage.AddAgent(Your_Name1, WhatsappNo, Your_Email, Your_Password);				
				
				Dashboardpage.NavigateToAdd_Power_Import_Tab();
				
				CSVUploadpage.EnterListName(ListName);
				
				CSVUploadpage.SelectAgentDropdown();
				
				CSVUploadpage.ClickOnChooseFile();
				
				CSVUploadpage.FileUpload();
				
				CSVUploadpage.ClickOnuploadFile();
				
				Agentpage.ClickOnOkbutton();
				
				CSVUploadpage.SelectFirstColumn(FirstColumn);
				
				CSVUploadpage.SelectSecondColumn(SecondColumn);
				
				CSVUploadpage.SelectThirdColumn(ThirdColumn);
				
				CSVUploadpage.ClickOnImport_Data();
				
				Agentpage.ClickOnOkbutton();
				
				Agentpage.Fetch_ListName(ListName);
				
				Dashboardpage.applicationlogout();

				}

				// EndTest
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

			

		} catch (Exception e) {

			System.out.println("<----------------Failed--- Test execution " + testdata.get("TestScenario").toString()
					+ " ---Failed ---------------->");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("Catch File not found error");
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		} catch (AssertionError e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("File not found error");
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// EndTest
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("************************ Test Suite " + testdata.get("TestScenario").toString()
					+ " ending ****************************");

		} finally {
			if (driver != null)
				driver.quit();
		}
	}

	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException {

		Object[][] objectarry = null;
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

		objectarry = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectarry[i][0] = completedata.get(i);
		}
		return objectarry;
	}
} 