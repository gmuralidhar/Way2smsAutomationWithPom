package com.way2sms.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.way2sms.qa.base.TestBase;

public class GrpSmsPage extends TestBase {
	
	
	@FindBy(xpath = "//div[contains(text(),'Group SMS')]")
	WebElement groupSMSHeaderText;
	
	@FindBy(name = "nicName")
	WebElement nickNameInputField;
	
	@FindBy(name = "toMobile")
	WebElement toMobileInputField;
	
	@FindBy(className = "free-sms-text")
	WebElement textMsgInputArea;
	
	@FindBy(id = "sendButton")
	WebElement sendBtn;
	
	//Constructor: Initialize webdriver from base class
		public GrpSmsPage() {
			PageFactory.initElements(driver, this);
		}	
		
		
		public String getCurrentURL() {
			return driver.getCurrentUrl();
		}
		
		public String getGroupSMSHeaderText() {
			return groupSMSHeaderText.getText();
		}
		
		public void clearValueInNickName() {
			nickNameInputField.clear();
		}
		
		public void sendNickName(String nicName) {
			nickNameInputField.sendKeys(nicName);
		}
		
		public void sendPhoneNumber(String phNum) {
			toMobileInputField.sendKeys(phNum);
		}
		
		public void sendTextMessage(String textMsg) {
			textMsgInputArea.sendKeys(textMsg);
		}
		
		public void clickSendButton() {
			sendBtn.click();
		}
		
		
		List < WebElement > contacts = driver.findElements(By.xpath("//div[@id = 'contacts1']/li"));
		
		public void selectAllContacts() throws InterruptedException {
			System.out.println("Total Contacts : " + contacts.size());

			for (int i = 1; i <= contacts.size(); i++) {
				
				  driver.findElement(By.xpath("//div[@id = 'contacts1']/li[" + i + "]")).click();
			   
				  Thread.sleep(2000);
			   
			  }
		}
		  	
}
