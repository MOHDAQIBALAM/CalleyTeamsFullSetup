package com.Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class DashboardPage extends Base_Class{
	private By L_TeamDropdown = By.xpath("//*[text()='Team']");
	private By L_AgentTab = By.xpath("//span[normalize-space()='Agents']");
	private By L_CallListDropdown = By.xpath("//*[text()='Call List ']");
	private By L_Add_Power_Import_Tab = By.xpath("//span[normalize-space()='Add - Power Import']");
	private By Usericon =By.xpath("//a[contains(@class,'nav-user')]");
	private By Logout =By.xpath("//*[@class='dropdown-menu dropdown-menu-right profile-dropdown desktop_profilesetup show']//*[contains(@href,'logout')][@class='dropdown-item notify-item']");
	
	
	////////////////////////////////Methods///////////////////////
	public void NavigateToAgentTab() throws InterruptedException {
		MouseHoverOnTeamDropdown();
		ClickOnAgentTab();
	}
	
	public void NavigateToAdd_Power_Import_Tab() throws InterruptedException {
		MouseHoverOnCallListDropdown();
		ClickOnAdd_Power_Import_Tab();
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
	
	public void ClickOnAdd_Power_Import_Tab() throws InterruptedException {
		if(ElementDisplayed(L_Add_Power_Import_Tab)) {
			ExtentSuccessMessage("The user was successfully able to see the Add_Power_Import_Tab.");
			Log.info("The user was successfully able to see the Add_Power_Import_Tab.");
			click(L_Add_Power_Import_Tab);
			ExtentSuccessMessage("User successfully Clicked on the Add_Power_Import_Tab.");
			Log.info("User successfully Clicked on the Add_Power_Import_Tab.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Add_Power_Import_Tab.");
			Log.error("User is unsuccessfully not able to see the Add_Power_Import_Tab.");
		}
	}
	
	public void MouseHoverOnCallListDropdown() throws InterruptedException {
		if(ElementDisplayed(L_CallListDropdown)) {
			ExtentSuccessMessage("The user was successfully able to see the Call List Dropdown.");
			Log.info("The user was successfully able to see the Call List Dropdown.");
			MouseHoverOnElement(L_CallListDropdown);
			ExtentSuccessMessage("User successfully Mouse Hover on the Call List Dropdown.");
			Log.info("User successfully Mouse Hover on the Call List Dropdown.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Call List Dropdown.");
			Log.error("User is unsuccessfully not able to see the Call List Dropdown.");
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
	
	public void applicationlogout() throws InterruptedException {
		ClickOnUsericon();
		ClickOnLogout();
	}
	
	public void ClickOnUsericon() throws InterruptedException {
		if(ElementDisplayed(Usericon)) {
			ExtentSuccessMessage("The user was successfully able to see the User icon.");
			Log.info("The user was successfully able to see the User icon.");
			click(Usericon);
			ExtentSuccessMessage("User successfully Clicked on the User icon.");
			Log.info("User successfully Clicked on the User icon.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the User icon.");
			Log.error("User is unsuccessfully not able to see the User icon.");
		}
	}
	public void ClickOnLogout() throws InterruptedException {
		ScrollUntilElementVisible(Logout);
		if(ElementDisplayed(Logout)) {
			ExtentSuccessMessage("The user was successfully able to see the Logout.");
			Log.info("The user was successfully able to see the Logout.");
			click(Logout);
			ExtentSuccessMessage("User successfully Clicked on the Logout.");
			Log.info("User successfully Clicked on the Logout.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Logout.");
			Log.error("User is unsuccessfully not able to see the Logout.");
		}
	}
	


}
