package com.Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class LoginPage extends Base_Class{
	private By L_username = By.id("txtEmailId");
	private By L_password = By.id("txtPassword");
	private By L_SignIn = By.id("btnLogIn");
	private By NotificationpopLAtebutton= By.xpath("//*[text()='Later']");

	////////////////////////////////Methods///////////////////////

	public void Notificationpopup() throws InterruptedException {
		Thread.sleep(5000);
		if(ElementDisplayed(NotificationpopLAtebutton)) {
			ExtentSuccessMessage("The user was successfully able to see the Notification pop up.");
			Log.info("The user was successfully able to see the Notification pop up.");
			click(NotificationpopLAtebutton);
			ExtentSuccessMessage("User successfully Clicked on the Notification pop up.");
			Log.info("User successfully Clicked on the Notification pop up.");
		}else {
			ExtentSuccessMessage("User is unsuccessfully not able to see the Notification pop up.");
			Log.info("User is unsuccessfully not able to see the Notification pop up.");
		}
	}
	public void LoginToApplication(String Username,String Password) throws InterruptedException {
		EnterUserName(Username);
		EnterPassword(Password);
		ClickOnLoginButton();
		Notificationpopup();
	}
	public void EnterUserName(String value) throws InterruptedException {
		if(ElementDisplayed(L_username)) {
			ExtentSuccessMessage("The user was successfully able to see the username field.");
			Log.info("The user was successfully able to see the username field.");
			input(L_username, value);
			ExtentSuccessMessage("User successfully entered the '"+value+"' into the username field.");
			Log.info("User successfully entered the '"+value+"' into the username field.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see theusername field.");
			Log.error("User is unsuccessfully not able to see theusername field.");
		}
	}

	public void EnterPassword(String value) throws InterruptedException {
		if(ElementDisplayed(L_password)) {
			ExtentSuccessMessage("The user was successfully able to see the password field.");
			Log.info("The user was successfully able to see the password field.");
			input(L_password, value);
			ExtentSuccessMessage("User successfully entered the '"+value+"' into the password field.");
			Log.info("User successfully entered the '"+value+"' into the password field.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see thepassword field.");
			Log.error("User is unsuccessfully not able to see thepassword field.");
		}
	}

	public void ClickOnLoginButton() throws InterruptedException {
		if(ElementDisplayed(L_SignIn)) {
			ExtentSuccessMessage("The user was successfully able to see the Sign In Button.");
			Log.info("The user was successfully able to see the Sign In Button.");
			click(L_SignIn);
			ExtentSuccessMessage("User successfully Clicked on the Sign In Button.");
			Log.info("User successfully Clicked on the Sign In Button.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the sign-in button.");
			Log.error("User is unsuccessfully not able to see the sign-in button.");
		}
	}


}
