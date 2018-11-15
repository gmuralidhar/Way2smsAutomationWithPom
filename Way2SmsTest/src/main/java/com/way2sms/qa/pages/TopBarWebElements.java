package com.way2sms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.way2sms.qa.base.TestBase;

public class TopBarWebElements extends TestBase{

	@FindBy(className = "logout")
	WebElement logOutBtn;
	
	//Constructor: Initialize webdriver from base class
		public TopBarWebElements() {
			PageFactory.initElements(driver, this);
		}
		
		public void clickLogOutBtn() {
			logOutBtn.click();
		}
}
