package com.way2sms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.way2sms.qa.base.TestBase;

public class SideNavWebElements extends TestBase{
	
	@FindBy(xpath = "//img[contains(@src,'/resources/images/logo_way2sms.png')]")
	WebElement way2smsImg;
	
	@FindBy(xpath = "/html/body/div[4]/div[4]/aside/section/small")
	WebElement welcomeText;
	
	@FindBy(xpath = "//span[contains(text(),'Send SMS')]")
	WebElement sendSMSTab;
	
	@FindBy(xpath = "//span[contains(text(),'Language SMS')]")
	WebElement languageSMSTab;
	
	@FindBy(xpath = "//span[contains(text(),'Group SMS')]")
	WebElement groupSMSTab;
	
	//Constructor: Initialize webdriver from base class
		public SideNavWebElements() {
			PageFactory.initElements(driver, this);
		}
		
		
		public Boolean getWay2SmsImgIsDisplayed() {
			return way2smsImg.isDisplayed();
		}
		
		public String getWlecomeText() {
			return welcomeText.getText();
		}
		
		public void clickSendSmsTab() {
			sendSMSTab.click();
		}
		
		public void clickLanguageSmsTab() {
			languageSMSTab.click();
		}
		
		public void clickGroupSmsTab() {
			groupSMSTab.click();
		}
		

}
