package com.rmanager.framework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rmanager.framework.properties.appConfig;


public class InitWebDrivers {
	  //create an object of SingleObject
		private static InitWebDrivers instance = new InitWebDrivers();
		private static appConfig PropertyAppConfig =  new appConfig();	
		   public static WebDriver driver;

		   //make the constructor private so that this class cannot be
		   //instantiated
		   private InitWebDrivers(){
			   		   
		   }

		   //Get the only object available
		   public static InitWebDrivers getInstance(){
		      return instance;
		   }

		   public static WebDriver getFirefoxDriver(){
			   if(driver == null){
				   driver = new FirefoxDriver();
				   driver.manage().window().maximize();
			   }
		      return driver;
		   }
		   public static WebDriver getChromeDriver(){
			   if (driver==null){
				   System.setProperty("webdriver.chrome.driver", PropertyAppConfig.getPathChromeNavigator() );			 	
				   driver = new ChromeDriver();   
				   driver.manage().window().maximize();
			   }
			   return driver;
		   }
}
