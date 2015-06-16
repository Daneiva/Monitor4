package com.rmanager.test.locations;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.rmanager.framework.common.InitWebDrivers;
import com.rmanager.framework.pages.admin.home.HomePage;
import com.rmanager.framework.pages.admin.locations.AddLocationTab;
import com.rmanager.framework.pages.admin.locations.LocationPage;
import com.rmanager.framework.pages.admin.locations.RemoveLocationPage;
import com.rmanager.framework.pages.admin.login.LoginPage;
import com.rmanager.framework.properties.appConfig;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class TestCreateLocation {
	  private WebDriver driver;	  
	  private appConfig PropertyAppConfig =  new appConfig();
	  private boolean locationIfPresent;	  
	  
	  /*Variables*/
	  String nameLocation = "Namelocation11";
	  String displayNameLocation = "display"+ nameLocation;
	  String descriptionLocation = "description"+ nameLocation;
	  String msgError= "The location: " + nameLocation + "was not created";
	  
	  @BeforeTest
	  public void setUp() throws Exception {		
		driver = InitWebDrivers.getChromeDriver();	 	   
	  }  
	  
	  @Test
	  public void CreateLocation()throws InterruptedException {
	  
	  Logger logger = Logger.getLogger("Test Create Location");
	  PropertyConfigurator.configure("src/log4j.properties");

	  /*Steps*/	 
	  driver.get(PropertyAppConfig.getUrlAdmin());
	  logger.info("Browser Opened");
	  LoginPage loginPage = new LoginPage(driver);
	  logger.info("Login Page Opened");
	  HomePage homePage = loginPage.clickLoginButton();
	  logger.info("Home Page Opened");
	  LocationPage locationPage= homePage.clickLocationButton();
	  logger.info("Location Page Opened");
	  AddLocationTab locationTab = locationPage.clickAddLocationButton();
	  logger.info("Location add Tab Opened");	 	 
	  locationTab.setNameLocation(nameLocation);
	  logger.info("Set name location");	
	  locationTab.setNameLocation(nameLocation);
	  logger.info("Set name location");	
	  locationTab.setDisplayNameLocation(displayNameLocation);
	  logger.info("Set Display name location");	
	  locationTab.setDescriptionLocation(descriptionLocation);
	  logger.info("Set Description location");	
	  locationTab.clickButtonSaveLocation();
	  logger.info("Click Button Save location");	
	  /*Refresh the page*/
	  driver.navigate().refresh();	
	  logger.info("Refresh the page");
	  /*Find the location created*/
	  locationIfPresent = locationPage.getLocationByCustomName(nameLocation);
	  logger.info("Location created exists: "+ locationIfPresent);
	  /*Asserts*/	  
	  Assert.assertTrue( locationIfPresent,msgError );
	  logger.info("Assert location If created");
	
  }
  @AfterTest
  public void tearDown() throws Exception {
	  Logger logger = Logger.getLogger("After Test: Delete location created");
	  PropertyConfigurator.configure("src/log4j.properties");
	  
	  /*Find the location created*/
	  LocationPage location  =  new LocationPage(driver);
	  locationIfPresent = location.getLocationByCustomName(nameLocation);
	  logger.info("Location created exists: "+ locationIfPresent);
	  /*delete location*/	
	  if (locationIfPresent = true){
			  location.CheckLocationFound();
			  location.clickRemoveButton();
			  RemoveLocationPage locationRemove = new RemoveLocationPage(driver);
			  locationRemove.clickButtonRemoveLocation();  
			  logger.info("clickButtonRemoveLocation");
			  
			  /*Refresh the page*/
			  driver.navigate().refresh();	
			  locationIfPresent = location.getLocationByCustomName(nameLocation);
			  logger.info("Refresh the page");
			  logger.info("Location created exists: "+ locationIfPresent);	  
	  }
	  else 
	  {
			  driver.navigate().refresh();	
			  logger.info("Refresh the page");
			  logger.info("Location created exists: "+ locationIfPresent);
	  }
	driver.quit();
  }
}

