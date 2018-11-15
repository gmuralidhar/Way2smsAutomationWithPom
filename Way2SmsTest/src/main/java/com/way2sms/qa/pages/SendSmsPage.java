package com.way2sms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.way2sms.qa.base.TestBase;

public class SendSmsPage extends TestBase{
	
	@FindBy(xpath = "//div[contains(text(),'SendSMS')]")
	WebElement sendSMSHeaderText;
	
	@FindBy(name = "toMobile")
	WebElement toMobileInputField;
	
	@FindBy(className = "free-sms-text")
	WebElement textMsgInputArea;
	
	@FindBy(id = "sendButton")
	WebElement sendBtn;
	
	//Constructor: Initialize webdriver from base class
	public SendSmsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public String getSendSMSHeaderText() {
		return sendSMSHeaderText.getText();
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
		
	
}
