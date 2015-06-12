package com.rmanager.test.locations;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.rmanager.framework.common.InitWebDrivers;
import com.rmanager.framework.pages.admin.home.HomePage;
import com.rmanager.framework.pages.admin.locations.AddLocationTab;
import com.rmanager.framework.pages.admin.locations.LocationPage;
import com.rmanager.framework.pages.admin.login.LoginPage;
import com.rmanager.framework.properties.appConfig;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestCreateLocation {
	 private WebDriver driver;	  
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private appConfig PropertyAppConfig =  new appConfig();
	  private boolean var;
	  
	  
	  @BeforeTest
	  public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver",PropertyAppConfig.getPathChromeNavigator());
		driver = InitWebDrivers.getChromeDriver();	 
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	   
	  }  
	  
  @Test
  public void CreateLocation()throws InterruptedException {
	  
	  Logger logger=Logger.getLogger("TestCreateLocation");
	  PropertyConfigurator.configure("Log4j.properties");
	  
	  
	  String nameLocation = "Namelocation42";
	  String displayNameLocation = "displayNamelocation42";
	  String descriptionLocation = "descriptionNamelocation42";	 
	  
	  driver.get(PropertyAppConfig.getUrlAdmin());
	  logger.info("Browser Opened");
	  LoginPage loginPage = new LoginPage(driver);
	  logger.info("LoginPage Opened");
	  HomePage homePage = loginPage.clickLoginButton();
	  
	  LocationPage locationPage= homePage.clickLocationButton();
	  AddLocationTab locationTab = locationPage.clickAddLocationButton();
	  
	  /*Steps*/	 
	 
	  locationTab.setNameLocation(nameLocation);
	  locationTab.setNameLocation(nameLocation);
	  locationTab.setDisplayNameLocation(displayNameLocation);	  
	  locationTab.setDescriptionLocation(descriptionLocation);	  
	  locationTab.clickButtonSaveLocation();
	  
	  /*Refresh the page*/
	  driver.navigate().refresh();	
	  /*Find the location created*/
	  var = locationPage.getLocationByCustomName(nameLocation);  
	  /*Asserts*/
	  
	  Assert.assertTrue( var, "The location: " + nameLocation + "was not created");
	  System.out.println(var);
	  /*delete location*/	  
  }
  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    
    
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);      
    }
}
}

