package com.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class CSVUploadPage extends Base_Class{
	private By L_SelectAgentDropdown = By.xpath("//*[@title='Please select an agent']");
	private By L_SelectAgentDropdown1 = By.xpath("//*[@class='page-title']");

	private By ListName= By.xpath("//*[contains(@name,'txtlistname')]");
	private By SelectALLAgent =By.xpath("(//*[@class='multiselect-container dropdown-menu show']//label//input)[1]");
	private By ChooseFile =By.xpath("//*[@id='Upload_Nmbr']");
	private By uploadFile =By.xpath("//*[@id='btnUp']");
	private By SelectFirstColumn =By.id("ddlbelongto_1");
	private By SelectSecondColumn =By.id("ddlbelongto_2");
	private By SelectThirdColumn =By.id("ddlbelongto_3");
	private By Import_Data =By.xpath("//*[@value='Import Data']");
	

	

	

	

	////////////////////////////////Methods///////////////////////



	public void EnterListName(String value) throws InterruptedException {
		if(ElementDisplayed(ListName)) {
			ExtentSuccessMessage("The user was successfully able to see the List Name field.");
			Log.info("The user was successfully able to see the List Name field.");
			input(ListName, value);
			ExtentSuccessMessage("User successfully entered the '"+value+"' into the List Name field.");
			Log.info("User successfully entered the '"+value+"' into the List Name field.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the List Name field.");
			Log.error("User is unsuccessfully not able to see the List Name field.");
		}
	}


	public void SelectAgentDropdown() throws InterruptedException {
		if(ElementDisplayed(L_SelectAgentDropdown)) {
			ExtentSuccessMessage("The user was successfully able to see the Select Agent dropdown");
			Log.info("The user was successfully able to see the Select Agent dropdown");
			click(L_SelectAgentDropdown);
			ExtentSuccessMessage("User successfully Clicked on the Select Agent dropdown");
			Log.info("User successfully Clicked on the Select Agent dropdown");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Select Agent dropdown");
			Log.error("User is unsuccessfully not able to see the Select Agent dropdown");
		}

		if(ElementDisplayed(SelectALLAgent)) {
			ExtentSuccessMessage("The user was successfully able to see the Select ALL Agent dropdown");
			Log.info("The user was successfully able to see the Select ALL Agent dropdown");
			click(SelectALLAgent);
			ExtentSuccessMessage("User successfully Clicked on the Select ALL Agent dropdown");
			Log.info("User successfully Clicked on the Select ALL Agent dropdown");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Select All Agent dropdown");
			Log.error("User is unsuccessfully not able to see the Select ALL Agent dropdown");
		}
		click(L_SelectAgentDropdown1);

	}



	public void ClickOnChooseFile() throws InterruptedException {
		//		ScrollUntilElementVisible(ChooseFile);
		if(ElementDisplayed(ChooseFile)) {
			ExtentSuccessMessage("The user was successfully able to see the Choose File.");
			Log.info("The user was successfully able to see the Choose File");
			click(ChooseFile);
			ExtentSuccessMessage("User successfully Clicked on the Choose File");
			Log.info("User successfully Clicked on the Choose File");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Choose File");
			Log.error("User is unsuccessfully not able to see the Choose File");
		}


	}

	public void ClickOnuploadFile() throws InterruptedException {
		//		ScrollUntilElementVisible(uploadFile);
		if(ElementDisplayed(uploadFile)) {
			ExtentSuccessMessage("The user was successfully able to see the upload File.");
			Log.info("The user was successfully able to see the upload File");
			click(uploadFile);
			ExtentSuccessMessage("User successfully Clicked on the upload File");
			Log.info("User successfully Clicked on the upload File");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the upload File");
			Log.error("User is unsuccessfully not able to see the upload File");
		}


	}

	public void FileUpload() throws InterruptedException, AWTException {
		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Sample File.csv";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");

	}
	

	public void SelectFirstColumn(String value) throws InterruptedException {
		if(ElementDisplayed(SelectFirstColumn)) {
			ExtentSuccessMessage("The user was successfully able to see the Select First Column.");
			Log.info("The user was successfully able to see the Select First Column.");
			select(value,SelectFirstColumn);
			ExtentSuccessMessage( "Choose '"+value+"' for Select First Column.");
			Log.info( "Choose '"+value+"' for Select First Column.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Select First Column.");
			Log.error("User is unsuccessfully not able to see the Select First Column.");
		}
	}
	public void SelectSecondColumn(String value) throws InterruptedException {
		if(ElementDisplayed(SelectSecondColumn)) {
			ExtentSuccessMessage("The user was successfully able to see the Select Second Column.");
			Log.info("The user was successfully able to see the Select Second Column.");
			select(value,SelectSecondColumn);
			ExtentSuccessMessage( "Choose '"+value+"' for Select Second Column.");
			Log.info( "Choose '"+value+"' for Select Second Column.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Select Second Column.");
			Log.error("User is unsuccessfully not able to see the Select Second Column.");
		}
	}
	public void SelectThirdColumn(String value) throws InterruptedException {
		if(ElementDisplayed(SelectThirdColumn)) {
			ExtentSuccessMessage("The user was successfully able to see the Select Third Column.");
			Log.info("The user was successfully able to see the Select Third Column.");
			select(value,SelectThirdColumn);
			ExtentSuccessMessage( "Choose '"+value+"' for Select Third Column.");
			Log.info( "Choose '"+value+"' for Select Third Column.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Select Third Column.");
			Log.error("User is unsuccessfully not able to see the Select Third Column.");
		}
	}
	
	public void ClickOnImport_Data() throws InterruptedException {	
		ScrollUntilElementVisible(Import_Data);
		if(ElementDisplayed(Import_Data)) {
			ExtentSuccessMessage("The user was successfully able to see the Import_Data.");
			Log.info("The user was successfully able to see the Import_Data");
			click(Import_Data);
			ExtentSuccessMessage("User successfully Clicked on the Import_Data");
			Log.info("User successfully Clicked on the Import_Data");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Import_Data");
			Log.error("User is unsuccessfully not able to see the Import_Data");
		}
	}

}
