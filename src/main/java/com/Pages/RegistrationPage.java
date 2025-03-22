package com.Pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;

public class RegistrationPage extends Base_Class {

	private By L_signupButton = By.id("cmdsinup");
	private By L_Your_Name = By.id("txtName");
	private By L_Your_Email_Id = By.id("txtEmail");
	private By L_Your_Password= By.id("txtPassword");
	private By L_Your_Whatsapp_Number = By.id("txt_mobile");
	private By L_I_Am_Not_Robort_Check_Box =By.xpath("//*[@role='checkbox']");
//	private By L_IAccepted= By.xpath("//*[@id='checkbox-signup'][@type='checkbox'] | //*[@class='checkbox p-0']");
	private By L_IAccepted= By.xpath("//*[@class='checkbox p-0']");
	private By L_SignUpButton = By.id("btnSignUp");
	private By L_OkButton= By.xpath("//*[text()='OK']");
	private By L_VerifyButton= By.xpath("//*[@value='Verify']");
	
	
	


//////////////////Methods////////////////////
	
	public void RegisterForm(String YourName,String YourEmailId,String Password,String WhatsappNo) throws InterruptedException {
		ClickOnsignupButton();
		EnterYour_Name(YourName);
		EnterYour_Email_Id(YourEmailId);
		EnterYour_Password(Password);
		EnterYour_Whatsapp_Number(WhatsappNo);

		Thread.sleep(10000);
		ClickOnSignUpButton();
		ClickOnOk_Button();
		Thread.sleep(10000);
		ClickOnVerify_Button();
	}
	
	public void EnterYour_Password(String value) throws InterruptedException {
		if(ElementDisplayed(L_Your_Password)) {
			ExtentSuccessMessage("The user was successfully able to see the Your_Password field.");
			Log.info("The user was successfully able to see the Your_Password field.");
			input(L_Your_Password, value);
			ExtentSuccessMessage("User successfully entered the '"+value+"' into the Your_Password field.");
			Log.info("User successfully entered the '"+value+"' into the Your_Password field.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Your_Password field.");
			Log.error("User is unsuccessfully not able to see the Your_Password field.");
		}
	}
	public void EnterYour_Whatsapp_Number(String value) throws InterruptedException {
		if(ElementDisplayed(L_Your_Whatsapp_Number)) {
			ExtentSuccessMessage("The user was successfully able to see the Your_Whatsapp_Number field.");
			Log.info("The user was successfully able to see the Your_Whatsapp_Number field.");
			input(L_Your_Whatsapp_Number, value);
			ExtentSuccessMessage("User successfully entered the '"+value+"' into the Your_Whatsapp_Number field.");
			Log.info("User successfully entered the '"+value+"' into the Your_Whatsapp_Number field.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Your_Whatsapp_Number field.");
			Log.error("User is unsuccessfully not able to see the Your_Whatsapp_Number field.");
		}
	}
	public void EnterYour_Email_Id(String value) throws InterruptedException {
		String email=generateRandomText()+value;
		if(ElementDisplayed(L_Your_Email_Id)) {
			ExtentSuccessMessage("The user was successfully able to see the Your_Email_Id field.");
			Log.info("The user was successfully able to see the Your_Email_Id field.");
			input(L_Your_Email_Id, email);
			ExtentSuccessMessage("User successfully entered the '"+email+"' into the Your_Email_Id field.");
			Log.info("User successfully entered the '"+email+"' into the Your_Email_Id field.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Your_Email_Id field.");
			Log.error("User is unsuccessfully not able to see the Your_Email_Id field.");
		}
	}
	
	public void EnterYour_Name(String value) throws InterruptedException {
		if(ElementDisplayed(L_Your_Name)) {
			ExtentSuccessMessage("The user was successfully able to see the Your_Name field.");
			Log.info("The user was successfully able to see the Your_Name field.");
			input(L_Your_Name, value);
			ExtentSuccessMessage("User successfully entered the '"+value+"' into the Your_Name field.");
			Log.info("User successfully entered the '"+value+"' into the Your_Name field.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Your_Name field.");
			Log.error("User is unsuccessfully not able to see the Your_Name field.");
		}
	}
	
	public void ClickOnsignupButton() throws InterruptedException {
		ScrollUntilElementVisible(L_signupButton);
		if(ElementDisplayed(L_signupButton)) {
			ExtentSuccessMessage("The user was successfully able to see the Sign up  Button.");
			Log.info("The user was successfully able to see the Sign up  Button.");
			click(L_signupButton);
			ExtentSuccessMessage("User successfully Clicked on the Sign up  Button.");
			Log.info("User successfully Clicked on the Sign up  Button.");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Sign up  button.");
			Log.error("User is unsuccessfully not able to see the Sign up  button.");
		}
	}

	public void ClickOnIAmNotRobortCheckBox () throws InterruptedException {
		getListofIframe();
//		switchToWindowByTitle("reCAPTCHA");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		if(ElementDisplayed(L_I_Am_Not_Robort_Check_Box )) {
			ExtentSuccessMessage("The user was successfully able to see the I_Am_Not_Robort_Check_Box .");
			Log.info("The user was successfully able to see the I_Am_Not_Robort_Check_Box .");
			System.out.println("The user was successfully able to see the I_Am_Not_Robort_Check_Box .");
			click(L_I_Am_Not_Robort_Check_Box );
//			Base_Class.KeyOperation("TAB");
//			Base_Class.KeyOperation("Enter");
			ExtentSuccessMessage("User successfully Clicked on the I_Am_Not_Robort_Check_Box .");
			Log.info("User successfully Clicked on the I_Am_Not_Robort_Check_Box .");
			System.out.println("The user was successfully able to see the I_Am_Not_Robort_Check_Box .");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the I_Am_Not_Robort_Check_Box .");
			Log.error("User is unsuccessfully not able to see the I_Am_Not_Robort_Check_Box .");
		}
		 driver.switchTo().defaultContent();
	}
	public void ClickOnIAcceptedCheckBox () throws InterruptedException {
		ScrollUntilElementVisible(L_IAccepted);
		if(ElementDisplayed(L_IAccepted )) {
			ExtentSuccessMessage("The user was successfully able to see the I_Accepted__Check_Box .");
			Log.info("The user was successfully able to see the I_Accepted__Check_Box .");
			click(L_IAccepted );
			ExtentSuccessMessage("User successfully Clicked on the I_Accepted__Check_Box .");
			Log.info("User successfully Clicked on the I_Accepted__Check_Box .");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the I_Accepted__Check_Box .");
			Log.error("User is unsuccessfully not able to see the I_Accepted__Check_Box .");
		}
	}
	
	public void ClickOnSignUpButton() throws InterruptedException {
		if(ElementDisplayed(L_SignUpButton )) {
			ExtentSuccessMessage("The user was successfully able to see the Sign_Up_Button .");
			Log.info("The user was successfully able to see the Sign_Up_Button .");
			click(L_SignUpButton );
			ExtentSuccessMessage("User successfully Clicked on the Sign_Up_Button .");
			Log.info("User successfully Clicked on the Sign_Up_Button .");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Sign_Up_Button .");
			Log.error("User is unsuccessfully not able to see the Sign_Up_Button .");
		}
	}


	public void ClickOnOk_Button() throws InterruptedException {
		if(ElementDisplayed(L_OkButton )) {
			ExtentSuccessMessage("The user was successfully able to see the Ok_Button .");
			Log.info("The user was successfully able to see the Ok_Button .");
			click(L_OkButton );
			ExtentSuccessMessage("User successfully Clicked on the Ok_Button .");
			Log.info("User successfully Clicked on the Ok_Button .");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Ok_Button .");
			Log.error("User is unsuccessfully not able to see the Ok_Button .");
		}
	}

	public void ClickOnVerify_Button() throws InterruptedException {
		if(ElementDisplayed(L_VerifyButton )) {
			ExtentSuccessMessage("The user was successfully able to see the Verify_Button .");
			Log.info("The user was successfully able to see the Verify_Button .");
			click(L_VerifyButton );
			ExtentSuccessMessage("User successfully Clicked on the Verify_Button .");
			Log.info("User successfully Clicked on the Verify_Button .");
		}else {
			ExtentErrorMessage("User is unsuccessfully not able to see the Verify_Button .");
			Log.error("User is unsuccessfully not able to see the Verify_Button .");
		}
	}
	

	

}