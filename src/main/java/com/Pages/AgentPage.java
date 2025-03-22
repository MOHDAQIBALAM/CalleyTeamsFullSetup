package com.Pages;

import static org.testng.Assert.assertEquals;

import org.apache.http.util.Asserts;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.mongodb.assertions.Assertions;

public class AgentPage extends Base_Class{
	private By L_TeamDropdown = By.xpath("//*[text()='Team']");
	private By L_AgentTab = By.xpath("//span[normalize-space()='Agents']");
	private By L_AgentName = By.xpath("//*[contains(@name,'txt_name')]");
	private By L_AgentMobileNo = By.xpath("//*[contains(@name,'txt_mobile')]");
	private By L_AgentEmail= By.xpath("//*[contains(@name,'txt_email')]");
	private By L_AgentPassword= By.xpath("//*[contains(@name,'txt_pass')]");
	private By L_AgentSubmit= By.xpath("//*[contains(@name,'btn_submit')]");
	private By L_AgentSuccessMsg= By.xpath("//*[@class='sweet-alert showSweetAlert visible']//p[contains(@style,'display')]");
	private By L_Ok_Button= By.xpath("//*[@class='confirm']");
	private By L_ListNameFromWeb= By.xpath("(//*[@id=\"dt_table\"]//tbody//tr//td)[4]//a");
	
	public static String AgentSuccessMsg;
	public static String ListName;
	
	////////////////////////////////Methods///////////////////////
	
	
	public void NavigateToAgentTab() throws InterruptedException {
		MouseHoverOnTeamDropdown();
		ClickOnAgentTab();
	}
	
	public void AddAgent(String AgentName,String MobileNo,String Emailid,String Password) throws InterruptedException {

		String Emailsid=generateRandomText()+Emailid;
		EnterAgentName(AgentName);
		EnterAgentMobileNo(MobileNo);
		EnterAgentEmail(Emailsid);
		EnterAgentPassword(Password);
		ClickOnAgentSubmit();
	}
	
	
	
	public void EnterAgentName(String value) throws InterruptedException {
		if(ElementDisplayed(L_AgentName)) {
			ExtentSuccessMessage("The user was successfully able to see the AgentName field.");
			Log.info("The user was successfully able to see the AgentName field.");
			input(L_AgentName, value);
			ExtentSuccessMessage("User successfully entered the '"+value+"' into the AgentName field.");
			Log.info("User successfully entered the '"+value+"' into the AgentName field.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the AgentName field.");
			Log.error("User is unsuccessfully not able to see the AgentName field.");
		}
	}
	
	public void EnterAgentEmail(String value) throws InterruptedException {
		if(ElementDisplayed(L_AgentEmail)) {
			ExtentSuccessMessage("The user was successfully able to see the Agent_Email field.");
			Log.info("The user was successfully able to see the Agent_Email field.");
			input(L_AgentEmail, value);
			ExtentSuccessMessage("User successfully entered the '"+value+"' into the Agent_Email field.");
			Log.info("User successfully entered the '"+value+"' into the Agent_Email field.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Agent_Email field.");
			Log.error("User is unsuccessfully not able to see the Agent_Email field.");
		}
	}
	public void EnterAgentMobileNo(String value) throws InterruptedException {
		if(ElementDisplayed(L_AgentMobileNo)) {
			ExtentSuccessMessage("The user was successfully able to see the Agent_Mobile_No field.");
			Log.info("The user was successfully able to see the Agent_Mobile_No field.");
			input(L_AgentMobileNo, value);
			ExtentSuccessMessage("User successfully entered the '"+value+"' into the Agent_Mobile_No field.");
			Log.info("User successfully entered the '"+value+"' into the Agent_Mobile_No field.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Agent_Mobile_No field.");
			Log.error("User is unsuccessfully not able to see the Agent_Mobile_No field.");
		}
	}
	
	
	public void EnterAgentPassword(String value) throws InterruptedException {
		if(ElementDisplayed(L_AgentPassword)) {
			ExtentSuccessMessage("The user was successfully able to see the Agent_Password field.");
			Log.info("The user was successfully able to see the Agent_Password field.");
			input(L_AgentPassword, value);
			ExtentSuccessMessage("User successfully entered the '"+value+"' into the Agent_Password field.");
			Log.info("User successfully entered the '"+value+"' into the Agent_Password field.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Agent_Password field.");
			Log.error("User is unsuccessfully not able to see the Agent_Password field.");
		}
	}
	public void MouseHoverOnTeamDropdown() throws InterruptedException {
		if(ElementDisplayed(L_TeamDropdown)) {
			ExtentSuccessMessage("The user was successfully able to see the Team Dropdown.");
			Log.info("The user was successfully able to see the Team Dropdown.");
			MouseHoverOnElement(L_TeamDropdown);
			ExtentSuccessMessage("User successfully Mouse Hover on the Team Dropdown.");
			Log.info("User successfully Mouse Hover on the Team Dropdown.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Team Dropdown.");
			Log.error("User is unsuccessfully not able to see the Team Dropdown.");
		}
	}
	
	public void ClickOnAgentTab() throws InterruptedException {
		if(ElementDisplayed(L_AgentTab)) {
			ExtentSuccessMessage("The user was successfully able to see the Agent Tab.");
			Log.info("The user was successfully able to see the Agent Tab.");
			click(L_AgentTab);
			ExtentSuccessMessage("User successfully Clicked on the Agent Tab.");
			Log.info("User successfully Clicked on the Agent Tab.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Agent Tab.");
			Log.error("User is unsuccessfully not able to see the Agent Tab.");
		}
	}
	
	public void ClickOnOkbutton() throws InterruptedException {
		if(ElementDisplayed(L_Ok_Button)) {
			ExtentSuccessMessage("The user was successfully able to see the Ok button.");
			Log.info("The user was successfully able to see the Ok button.");
			click(L_Ok_Button);
			ExtentSuccessMessage("User successfully Clicked on the Ok button.");
			Log.info("User successfully Clicked on the Ok button.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Ok button.");
			Log.error("User is unsuccessfully not able to see the Ok button.");
		}
	}
	
	
	
	public void ClickOnAgentSubmit() throws InterruptedException {
		if(ElementDisplayed(L_AgentSubmit)) {
			ExtentSuccessMessage("The user was successfully able to see the Agent submit button.");
			Log.info("The user was successfully able to see the Agent submit button.");
			click(L_AgentSubmit);
			ExtentSuccessMessage("User successfully Clicked on the Agent submit button.");
			Log.info("User successfully Clicked on the Agent submit button.");
			Fetch_Successmsg();
			ClickOnOkbutton();
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Agent submit button.");
			Log.error("User is unsuccessfully not able to see the Agent submit button.");
		}
	}

	public void Fetch_Successmsg() throws InterruptedException {
		AgentSuccessMsg =GetElementText(L_AgentSuccessMsg);
		assertEquals(AgentSuccessMsg, "Agent Added Successfully!");
		ExtentSuccessMessage("Successfully Assertion Done");

	}
	
	public void Fetch_ListName(String Value) throws InterruptedException {
		ListName =GetElementText(L_ListNameFromWeb);
		assertEquals(ListName, Value);
		ExtentSuccessMessage("Successfully Assertion Done");

	}
	
	
}
