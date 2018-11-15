package com.way2sms.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.way2sms.qa.base.TestBase;
import com.way2sms.qa.pages.LoginPage;
import com.way2sms.qa.pages.SideNavWebElements;

public class LoginTest extends TestBase {
	LoginPage loginPage;
	SideNavWebElements sideNavWebElements;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization(); // Call initialization method from testBase class
		loginPage = new LoginPage();
		sideNavWebElements = new SideNavWebElements();
	}
	
	@Test(priority = 0)
	 public void varifyLoginPage() throws InterruptedException {
		 /* 
		  * Verify title of the page 
		  * Verify Sign in screen header text
		  */
		
		String appTitle = loginPage.getPageTitle(); //Get the title of the page
		
		System.out.println("Actual : " + appTitle + " &&& Excpected : Free SMS, Send Free SMS, Free SMS to india, Send Free SMS to india, Free text messaging, Send free SMS from PC to Mobile, Bulk SMS, Corporate SMS, SMS for Business need, SMS for Corporate, SMS API, SMS for Business need in india.");

		Assert.assertEquals(appTitle, "Free SMS, Send Free SMS, Free SMS to india, Send Free SMS to india, Free text messaging, Send free SMS from PC to Mobile, Bulk SMS, Corporate SMS, SMS for Business need, SMS for Corporate, SMS API, SMS for Business need in india.");
		
		String loginHeader = loginPage.getLoginPageHeaderText(); // get Login Page Header Text
		
		System.out.println("Actual : " + loginHeader + " &&& Excpected : INDIA’S #1 SMS PLATFORM");

		Assert.assertEquals(loginHeader, "INDIA’S #1 SMS PLATFORM");

		Thread.sleep(3000);
		
	}
	
	@Test(priority = 1)
	 public void loginWithWrongPass() throws InterruptedException {
		 /*
		  * Login with Wrong Password
		  * Verify invalid number or password error text
		  */
		
		loginPage.login(prop.getProperty("phoneNumber"), "muraly"); 
		
		Thread.sleep(1000);
		
		String invalidUserNameOrPassErrorMsg = loginPage.getErrorMsgUnderPassword(); //Get Invalid password Error Msg

		System.out.println("Actual : " + invalidUserNameOrPassErrorMsg + " &&& Excpected : Incorrect number or password! Try Again.");

		Assert.assertEquals(invalidUserNameOrPassErrorMsg, "Incorrect number or password! Try Again.");
	}
	
	 @Test(priority = 2)
	 public void loginWithInvalidPhoneNumber() throws InterruptedException {
		 
		 /*
		  * Login with invalid phone Number
		  * Verify invalid phone number error text
		  */

	  loginPage.login("998900141", prop.getProperty("password"));
	  
	  Thread.sleep(1000);

	  String invalidPhoneNumberErrorMsg = loginPage.getErrorMsgUnderMobileNumber(); //Get Invalid phone number Error Msg

	  System.out.println("Actual : " + invalidPhoneNumberErrorMsg + " &&& Excpected : Enter valid mobile number");

	  Assert.assertEquals(invalidPhoneNumberErrorMsg, "Enter valid mobile number");
	  
	 }

	 @Test(priority = 3)
	 public void loginWithValidPhoneNumberButNotRegistered() throws InterruptedException {
		 
		 /*
		  * Login with Valid Phone Number but not registered
		  * Verify phone number not registered error text
		  */

	  loginPage.login("9989001410", prop.getProperty("password"));
		 
	  Thread.sleep(1000);

	  String validPhoneNumberButNotRegisteredErrorMsg = loginPage.getErrorMsgUnderMobileNumber(); //Get Invalid Username Error Msg

	  System.out.println("Actual : " + validPhoneNumberButNotRegisteredErrorMsg + " &&& Excpected : Your mobile number is not register with us.");

	  Assert.assertEquals(validPhoneNumberButNotRegisteredErrorMsg, "Your mobile number is not register with us.");
	  
	 }


	 @Test(priority = 4)
	 public void loginWithEmptydPhoneNumber() throws InterruptedException {
		 /*
		  * Login with empty phone number
		  * Verify empty password error text
		  */

  loginPage.login("", prop.getProperty("password"));
		 
	  Thread.sleep(1000);

	  String emptydPhoneNumberErrorMsg = loginPage.getErrorMsgUnderMobileNumber(); //Get enter phone number Error Msg

	  System.out.println("Actual : " + emptydPhoneNumberErrorMsg + " &&& Excpected : Enter your mobile number");

	  Assert.assertEquals(emptydPhoneNumberErrorMsg, "Enter your mobile number");

	 }

	 @Test(priority = 5)
	 public void loginWithEmptydPassword() throws InterruptedException {
		 /*
		  * Login with empty password
		  * Verify empty password error text
		  */

	  loginPage.login(prop.getProperty("phoneNumber"), "");
		 
	  Thread.sleep(1000);

	  String emptyPasswordErrMsg = loginPage.getErrorMsgUnderPassword(); //Get Invalid Username Error Msg

	  System.out.println("Actual : " + emptyPasswordErrMsg + " &&& Excpected : Enter password");

	  Assert.assertEquals(emptyPasswordErrMsg, "Enter password");

	 }

	 @Test(priority = 6)
	 public void loginWithValidCredentials() throws InterruptedException {
		 /*
		  * Login with valid credentials
		  * Verify way2sms image && welcome text is displayed or not on dash board screen 
		  */

	  loginPage.login(prop.getProperty("phoneNumber"), prop.getProperty("password"));
	  
	  Thread.sleep(5000);

	  Boolean imagStatus = sideNavWebElements.getWay2SmsImgIsDisplayed();
	  
	  Boolean way2SmsImg = true;
	  
	  Assert.assertEquals(imagStatus, way2SmsImg);

	  String welcomeSmallText = sideNavWebElements.getWlecomeText();

	  System.out.println("Actual : " + welcomeSmallText + " &&& Excpected : welcome");

	  Assert.assertEquals(welcomeSmallText, "welcome");

	 }
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
