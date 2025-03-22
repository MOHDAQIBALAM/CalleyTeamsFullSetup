package com.BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility.Log;
import com.extentReports.ExtentTestManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static RemoteWebDriver driver = null;

	public WebDriver getDriver() {
		return driver;
	} 

	private static By L_username = By.id("txtEmailId");
	private static By L_password = By.id("txtPassword");
	private static  By L_SignIn = By.id("btnLogIn");
	
	public static String Pagetitle;

	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}

	public void SetUp() throws IOException, InterruptedException {

		String Browser = configloader().getProperty("Browser");
		String Url = configloader().getProperty("URL");
		String UserName = configloader().getProperty("UserName");
		System.out.println("UserName:-"+UserName);
		String Password = configloader().getProperty("Password");
		System.out.println("Password:-"+Password);

		switch (Browser.toUpperCase()) {

		case "CHROME":
			WebDriverManager.chromedriver().setup();
			// Add argument to disable notifications
//	        options.addArguments("--disable-notifications");
			// Instantiate ChromeDriver
			driver = new ChromeDriver();
			ExtentSuccessMessage("Launched brower is : Chrome");
			break;

		case "FIREFOX":
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			ExtentSuccessMessage("Launched brower is : Firefox");
			break;
			
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			ExtentSuccessMessage("Launched brower is : Edge");
			break;

		default:
			System.err.println("The Driver is not defined");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		Log.info("Driver has initialized successfully for "+Browser+"browser");
		driver.get(Url);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//		Thread.sleep(9000);
		Pagetitle = driver.getTitle();
		Log.info("Title is displayed : "+Pagetitle);

//		input(L_username, UserName);
//		input(L_password, Password);
//		click(L_SignIn);
	}

	public static void KeyOperation(String strKey) {
		Actions act = new Actions(driver);
		String str = strKey.toUpperCase();
		switch (str) {
		case "ENTER":
			act.sendKeys(Keys.ENTER).build().perform();
			ExtentSuccessMessage("Successfully click on 'ENTER' Key");
			break;
		case "TAB":
			act.sendKeys(Keys.TAB).build().perform();
			ExtentSuccessMessage("Successfully click on 'TAB' Key");
			break;
		case "DELETE":
			act.sendKeys(Keys.DELETE).build().perform();
			ExtentSuccessMessage("Successfully click on 'DELETE' Key");
			break;
		case "BACK_SPACE":
			act.sendKeys(Keys.BACK_SPACE).build().perform();
			ExtentSuccessMessage("Successfully click on 'BACK_SPACE' Key");
			break;
		case "LEFT":
			act.sendKeys(Keys.LEFT).build().perform();
			ExtentSuccessMessage("Successfully click on 'LEFT' Key");
			break;
		case "DOWN":
			act.sendKeys(Keys.DOWN).build().perform();
			ExtentSuccessMessage("Successfully click on 'DOWN' Key");
			break;
		case "UP":
			act.sendKeys(Keys.UP).build().perform();
			ExtentSuccessMessage("Successfully click on 'UP' Key");
			break;
		case "RIGHT":
			act.sendKeys(Keys.RIGHT).build().perform();
			ExtentSuccessMessage("Successfully click on 'BACK_SPACE' Key");
			break;
		case "SUBTRACT":
			act.sendKeys(Keys.SUBTRACT).build().perform();
			ExtentSuccessMessage("Successfully click on 'BACK_SPACE' Key");
			break;
		case "CONTROL":
			act.sendKeys(Keys.CONTROL).build().perform();
			ExtentSuccessMessage("Successfully click on 'CTRL' Key");
			break;
		case "ARROW_LEFT":
			act.sendKeys(Keys.ARROW_LEFT).build().perform();
			ExtentSuccessMessage("Successfully click on 'BACK_SPACE' Key");
			break;
		case "ESC":
			act.sendKeys(Keys.ESCAPE).build().perform();
			ExtentSuccessMessage("Successfully click on 'ESC' Key");
			break;
		case "V":
			act.sendKeys("V").build().perform();
			ExtentSuccessMessage("Successfully click on 'V' Key");
			break;

		}
	}

	public static  void input(By element, String Value) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(Value);
	}

	public static  void click(By element) throws InterruptedException {

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		Thread.sleep(2000);
	}
	public static void MouseHoverOnElement(By element) throws InterruptedException {
		WebElement ele = driver.findElement(element);
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}

	public static void select(String value,By element) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select selWeekDayDropDown = new Select(driver.findElement(element));
		selWeekDayDropDown.selectByVisibleText(value);

	}

	public static void clear(By element)throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
		Thread.sleep(2000);
	}


	public void AcceptAlert()
	{
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();	
	}
	public static void DismissAlert()
	{
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();	
	}

	public static void waitUntilElementDisappear(By element) throws InterruptedException {

		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		//Thread.sleep(2000);

	}
	public static void getListofIframe() {
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe|//frame"));
		System.out.println("iFrame info :- Total number of iFrame present on the Pagetitle '" + Pagetitle + "' = "
				+ iframes.size());
		int count = 1;
		for (WebElement iframe : iframes) {
			String strIframeID = iframe.getAttribute("id");
			String strIframeName = iframe.getAttribute("name");
			System.out.println("iFrame" + count + " : Id = " + strIframeID + " , Name = " + strIframeName);
			count++;
		}
	}
	public void switchToWindowByTitle(String title) {
		boolean foundWindow = false;
		for (String handle : driver.getWindowHandles()) {
			if (driver.switchTo().window(handle).getTitle().equalsIgnoreCase(title)) {
				ExtentSuccessMessage("Successfully Switched to window with title:" + title);
				foundWindow = true;
				break;
			}
		}
		if (foundWindow) {
			System.out.println("Couldn't find the window with title -> " + title + "\nSwitching to parent window.");
		}
	}
	public static void SwitchToFrame(By frameName) throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
	}

	public static void ScrollUntilElementVisible(By locator) throws InterruptedException
	{ 
		Thread.sleep(1000);
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static boolean ElementDisplayed(By locator) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isDisplayed();
		return flag;
	}

	public static boolean ElementEnabled(By locator)
	{
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();
		return flag;
	}

	public static boolean CheckBoxStatus(By locator)
	{
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isSelected();
		return flag;
	}

	public static void UploadFile(By locator, String path)
	{
		WebElement uploadElement = driver.findElement(locator);
		String path1=System.getProperty("user.dir");
		Log.info("path is :" + path1);
		uploadElement.sendKeys(path1 + path);

	}


	//	public static void UploadFile(By locator)
	//	{
	//		WebElement uploadElement = driver.findElement(locator);
	//		 String path=System.getProperty("user.dir");
	//		 Log.info("path is :" + path);
	//		//System.out.Directory.GetParent(this.GetType().Assembly.Location).ToString();
	//		uploadElement.sendKeys(path);
	//		
	//		
	//	}
	public static boolean ElementEnableOrDisable(By locator)
	{
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();
		return flag;
	}

	public static boolean CheckElementDisable(By locator)
	{  
		//disable
		WebElement element = driver.findElement(locator);
		Boolean flag = element.isEnabled();	

		if (flag==false) {
			flag=true;
		}else if(flag==true)
			flag=false;

		return flag;
	}


	public static  void Hover(By element) throws InterruptedException {
		WebElement element1 = driver.findElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element1).perform();
	}





	public static  void DatabaseConnector() throws ClassNotFoundException {


		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String UserName = "sqa";
		String Password = "SPQA@sql2019" ;
		String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=NBFC_adithyan;encrypt=true;trustServerCertificate=true";


		//		try(Connection connection = DriverManager.getConnection(Url,UserName,Password)){
		//		//con = DriverManager.getConnection(Url,UserName,Password);
		//		System.out.println("Class: Common Method: DatabaseConnector: Connected");
		//		
		//		//Execute Query for getting approval
		//		CallableStatement callableStatement = connection.prepareCall("{call cl}");
		//		//callableStatement.setLong(1, 9999999991L);
		//		//System.out.println("Stored procedure called with parameter: 9999999991");
		//		
		//		 // Execute stored procedure
		//        callableStatement.executeQuery();
		//        System.out.println("Stored procedure executed successfully.");
		////        while (resultSet.next()) {
		////            String column1 = resultSet.getString("O");
		////            System.out.println("OTP : " + column1  );
		////
		////		
		////        }
		String query = "cl;";
		try (Connection connection = DriverManager.getConnection(Url, UserName, Password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {

		} catch (SQLException e) {
			System.out.println("Error executing the SQL query.");
			//e.printStackTrace();
		}





		//	}catch(Exception e)
		//	{
		//		System.out.println("Class: Common Method: DatabaseConnector: Not Connected");
		//		//e.printStackTrace();
		//	
		//	}

	}

	public static void ExtentSuccessMessage(String strPassSuccessMessage) {
		ExtentTestManager.getTest().log(Status.PASS, strPassSuccessMessage);
	}

	public static void ExtentErrorMessage(String strPassErrorMessage) {
		ExtentTestManager.getTest().log(Status.FAIL, strPassErrorMessage);
	}

	public static String GetElementText(By locator) throws InterruptedException {

		String stxt = null;
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			stxt = element.getText();
			Log.info("System able to found the element :" + locator+"Text:-"+stxt);
		} else {
			Log.error("System not able to found the element :" + locator);
		}
		return stxt;
	}
	public void PageRefresh() {
		driver.navigate().refresh();
	}



	public String dateConversion(String inputDate) throws ParseException {

		// Define the original format of the date string
		SimpleDateFormat originalFormat = new SimpleDateFormat("EEEE, MMMM dd yyyy", Locale.ENGLISH);

		// Parse the input date string
		Date date = originalFormat.parse(inputDate);

		// Define the desired output format (DD/MM/YYYY)
		SimpleDateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");

		// Format the parsed date into the desired format
		String formattedDate = targetFormat.format(date);

		return formattedDate;
	}


	
	public String generateRandomText() {
		// Create a generator using Apache Commons Text
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
				.withinRange('a', 'z')
				.build();
		// Generate a random word of length 8
		String randomWord = generator.generate(8);
		System.out.println("Random Word: " + randomWord);
		return randomWord;
	}
	
	
}
