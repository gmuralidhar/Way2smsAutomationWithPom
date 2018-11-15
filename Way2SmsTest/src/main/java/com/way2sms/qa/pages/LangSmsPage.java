package com.way2sms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.way2sms.qa.base.TestBase;

public class LangSmsPage extends TestBase{

	@FindBy(xpath = "//div[contains(text(),'Language SMS')]")
	WebElement languageSMSHeaderText;
	
	@FindBy(name = "toMobile")
	WebElement toMobileInputField;
	
	@FindBy(className = "ip-select-sm")
	WebElement languageDropDown;
	
	@FindBy(className = "free-sms-text")
	WebElement textMsgInputArea;
	
	@FindBy(id = "sendButton")
	WebElement sendBtn;
	
	//Constructor: Initialize webdriver from base class
	public LangSmsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public String getLanguageSMSHeaderText() {
		return languageSMSHeaderText.getText();
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
	
	public void selectDropDownValue() {
		Select s = new Select(languageDropDown); //Select class to select drop down value
		  
		s.selectByValue("te");
		  
		//		s.selectByVisibleText("Telugu");
		  
		//		s.selectByIndex(1);
	}

}
