package com.way2sms.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.way2sms.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	//Contructor method to initialize config.properties
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/kushal/Documents/Murali/Workspace/SeleniumWorkSpace/Way2SmsTest/src/main/java/com/way2sms/qa/config/config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//initialization of browsers and handle multiple windows
	public static void initialization() throws InterruptedException {
		
		String browserName = prop.getProperty("browser");//Read the browser property in config.properties file
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "/Users/kushal/Documents/Murali/Workspace/All_Jar_Files/Browser_Jars/chromedriver");
			
			driver = new ChromeDriver();
			
			driver.manage().window().fullscreen();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "/Users/kushal/Documents/Murali/Workspace/All_Jar_Files/Browser_Jars/geckodriver");
			
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			
		}	
		
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		/* Code for handle multiple windows */

		  String mainWindow = driver.getWindowHandle();

		  Thread.sleep(3000);

		  System.out.println(mainWindow);

		  Set < String > set = driver.getWindowHandles();//To get all windows
		  
		  System.out.println("Total number of windows opened "+set.size());
		  
		  if(set.size()>1) {
		  
			  System.out.println(set);
			
			  // Using Iterator to iterate with in windows
			  Iterator < String > itr = set.iterator();
			
			  while (itr.hasNext()) {
			
			   String childWindow = itr.next();
			
			   //System.out.println(childWindow);
			
			   // Compare whether the main windows is not equal to child window. If not equal, we will close.
			   if (!mainWindow.equals(childWindow)) {
			
			    driver.switchTo().window(childWindow);
			
			    //System.out.println(driver.switchTo().window(childWindow).getTitle());
			
			    driver.close(); //Close child window
			   }
			  }
			  // This is to switch to the main window
			  driver.switchTo().window(mainWindow);
		  
		  }

		 }
		
}
