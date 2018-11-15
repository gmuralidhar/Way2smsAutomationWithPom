package com.way2sms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.way2sms.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//*[contains(text(),'INDIA’S #1 SMS PLATFORM')]")
	WebElement loginPageHeader;
	
	@FindBy(id = "mobileNo")
	WebElement mobileNumberInputField;
	
	@FindBy(id = "password")
	WebElement passwordInputField;
	
	@FindBy(xpath = "//button[contains(@onclick , 'validLogin')]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//*[@class='error']")
	WebElement errorMsgunderMobileNumber;
	
	@FindBy(xpath = "//*[@id='mainErr']")
	WebElement errorMsgUnderPassword;
	
	
	//Constructor: Initialize webdriver from base class
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginPageHeaderText() {
		return loginPageHeader.getText();
	}
	
	public void login(String phNo, String pwd) {
		mobileNumberInputField.sendKeys(phNo);
		
		passwordInputField.sendKeys(pwd);
		
		loginBtn.click();
	} 
	
	public String getErrorMsgUnderMobileNumber() {
		
		return errorMsgunderMobileNumber.getText();
	
	}
	
	public String getErrorMsgUnderPassword() {
		
		return errorMsgUnderPassword.getText();
	
	}
	
	
	
}
