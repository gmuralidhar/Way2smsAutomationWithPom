package com.way2sms.qa.testcases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.way2sms.qa.base.TestBase;
import com.way2sms.qa.pages.GrpSmsPage;
import com.way2sms.qa.pages.LangSmsPage;
import com.way2sms.qa.pages.LoginPage;
import com.way2sms.qa.pages.SendSmsPage;
import com.way2sms.qa.pages.SideNavWebElements;
import com.way2sms.qa.pages.TopBarWebElements;

public class SendSMSTest extends TestBase{
	LoginPage loginPage;
	SideNavWebElements sideNavWebElements;
	TopBarWebElements topBarWebElements;
	SendSmsPage sendSmsPage;
	LangSmsPage langSmsPage;
	GrpSmsPage grpSmsPage;
	
	public SendSMSTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization(); // Call initialization method from testBase class
		
		loginPage = new LoginPage();
		sideNavWebElements = new SideNavWebElements();
		topBarWebElements = new TopBarWebElements();
		sendSmsPage = new SendSmsPage();
		langSmsPage = new LangSmsPage();
		grpSmsPage = new GrpSmsPage();
		
		loginPage.login(prop.getProperty("phoneNumber"), prop.getProperty("password")); //Log-in into the app
		
	}
	
	@Test(priority = 0)
	 public void sendSmSTest() throws InterruptedException {
		 /*
		  * Verify Send sms header text showing or not on send sms screen 
		  * Also Verify current URl and expected url or same or not 
		  * Enter a phone number
		  * Enter a text message
		  * Click send button
		  */
		 
	  String sendSMSHeaderText = sendSmsPage.getSendSMSHeaderText(); //Get Send Sms header text
	  
	  System.out.println("Actual : " + sendSMSHeaderText + " &&& Excpected : SendSMS");
	  
	  Assert.assertEquals(sendSMSHeaderText, "SendSMS");
	  
	  String sendSMSURL = sendSmsPage.getCurrentURL(); //Get Current Url
	  
	  System.out.println("Current url: " + sendSMSURL);
	  
	  Assert.assertEquals(sendSMSURL, "http://www.way2sms.com/send-sms");
	  
	  sendSmsPage.sendPhoneNumber("9989001416"); //Send Phone number 
	  
	  sendSmsPage.sendTextMessage("Hi Murali"); //Send Text msg
	  
	  Thread.sleep(1000);
	  
	  sendSmsPage.clickSendButton();
	  
	  Thread.sleep(3000);
	 }

	 @Test(priority = 1)
	 public void sendLangSms() throws InterruptedException {
		 /*
		  * click language tab on side nav
		  * Verify language sms header text showing or not on language sms screen 
		  * Also Verify current URl and expected url or same or not
		  * Enter a phone number
		  * select telugu language from dropdown
		  * Enter a text message
		  * Click send button
		  */
		 
	  sideNavWebElements.clickLanguageSmsTab();
	  
	  Thread.sleep(1000);
	  
	  String sendLangSMSHeaderText = langSmsPage.getLanguageSMSHeaderText(); //get send sms header text
	  
	  System.out.println("Actual : " + sendLangSMSHeaderText + " &&& Excpected : Language SMS");
	  
	  Assert.assertEquals(sendLangSMSHeaderText, "Language SMS");
	  
	  String sendLangSMSURL = langSmsPage.getCurrentURL(); //Get Current Url
	  
	  System.out.println("Current url: " + sendLangSMSURL);
	  
	  Assert.assertEquals(sendLangSMSURL, "http://www.way2sms.com/lang-sms");
	  
	  langSmsPage.sendPhoneNumber("8186867724"); //
	  
	  langSmsPage.selectDropDownValue();
	  
	  langSmsPage.sendTextMessage("Rijo");
	  
	  Thread.sleep(5000);
	  
	  Actions a = new Actions(driver); //Actions class to click TAB key in keyboard
	  
	  a.sendKeys(Keys.TAB).build().perform();
	  
	  Thread.sleep(10000);
	  
	  langSmsPage.clickSendButton();
	  
	  Thread.sleep(1000);
	  
	 }

	 @Test(priority = 2)
	 public void testGrpSms() throws InterruptedException {
		 /*
		  * Verify Group sms header text showing or not on group sms screen 
		  * Also Verify current URl and expected url or same or not
		  * Enter a phone number
		  * Count all contacts from right side contacts display
		  * Select all contacts from right side contacts display
		  * s
		  * Enter a text message
		  * Click send button
		  */
		 
	  sideNavWebElements.clickGroupSmsTab();
	  
	  Thread.sleep(1000);

	  String sendLangSMSHeaderText = grpSmsPage.getGroupSMSHeaderText();//get language sms header text
	  
	  System.out.println("Actual : " + sendLangSMSHeaderText + " &&& Excpected : Group SMS");
	  
	  Assert.assertEquals(sendLangSMSHeaderText, "Group SMS");
	  
	  String sendLangSMSURL = grpSmsPage.getCurrentURL(); //Get Current Url
	  
	  System.out.println("Current url: " + sendLangSMSURL);
	  
	  Assert.assertEquals(sendLangSMSURL, "http://www.way2sms.com/group-sms");
	  

	  grpSmsPage.clearValueInNickName(); //Clear value in Nick Name
	  
	  grpSmsPage.sendNickName("QA Team"); //Send Value to Nick Name
	  
	  Thread.sleep(3000);

	  grpSmsPage.selectAllContacts(); //Select all existing contacts 

	  Thread.sleep(5000);
	  
	  grpSmsPage.sendTextMessage("Hi QA Team"); //Send Text Msg
	  
	  Thread.sleep(1000);

	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH"); //Get current time format in hours
	  
	  LocalDateTime now = LocalDateTime.now(); //Get local time
	  
	  System.out.println("Current time : " + dtf.format(now));
	  
	  int currentTimeInHours = Integer.parseInt(dtf.format(now));

	  if (currentTimeInHours > 9 && currentTimeInHours < 21) {
		  
	   driver.findElement(By.id("sendButton")).click();
	   
	   Thread.sleep(1000);
	   
	  } else {
		  
	   System.out.println("Group Msg feature should work in-between 9AM to 9PM only");
	   
	  }

	 }
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		
		topBarWebElements.clickLogOutBtn(); //Click logout button
		
		Thread.sleep(3000);
		
		driver.quit();
	}
	
}
