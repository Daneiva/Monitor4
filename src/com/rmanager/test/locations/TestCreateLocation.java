package com.rmanager.test.locations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.rmanager.framework.common.InitWebDrivers;
import com.rmanager.framework.common.LoggerManager;
import com.rmanager.framework.pages.admin.home.HomePage;
import com.rmanager.framework.pages.admin.locations.AddLocationTab;
import com.rmanager.framework.pages.admin.locations.LocationPage;
import com.rmanager.framework.pages.admin.locations.RemoveLocationPage;
import com.rmanager.framework.pages.admin.login.LoginPage;
import com.rmanager.framework.properties.AppConfig;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestCreateLocation {
	
	  private WebDriver driver;	  
	  private AppConfig PropertyAppConfig =  new AppConfig();
	  
	  private boolean locationIfPresent;	  
	  
	  /*Variables*/
	  String nameLocation = "NamelocationCreated444";
	  String displayNameLocation = "display"+ nameLocation;
	  String descriptionLocation = "description"+ nameLocation;
	  String msgError= "The location: " + nameLocation + "was not created";
	  	  
	  @Test
	  public void CreateLocation()throws InterruptedException {
	  
	  LoggerManager.info("Test Create Location");	 
		
	  /*Steps*/	 
	  driver.get(PropertyAppConfig.getUrlAdmin());
	  driver.navigate().refresh();	
	  
	  LoginPage loginPage = new LoginPage(driver);
	 
	  HomePage homePage = loginPage.clickLoginButton();	  
	  LocationPage locationPage= homePage.clickLocationButton();	 
	  AddLocationTab locationTab = locationPage.clickAddLocationButton();	  
	  locationTab.setNameLocation(nameLocation);	  
	  locationTab.setDisplayNameLocation(displayNameLocation);	 
	  locationTab.setDescriptionLocation(descriptionLocation);	 
	  locationTab.clickButtonSaveLocation();	 	
	  /*Refresh the page*/
	  driver.navigate().refresh();	
	  LoggerManager.info("Refresh the page");
	  
	  /*Find the location created*/
	  locationIfPresent = locationPage.getLocationByName(nameLocation);
	  
	  /*Asserts*/	  
	  Assert.assertTrue( locationIfPresent,msgError );
	  LoggerManager.info("Assert Test Create Location<location created is: " + nameLocation + "> was created!");
	  /*Refresh the page*/
	  driver.navigate().refresh();	
	  LoggerManager.info("Refresh the page - Test Create Location");
	  }
	 
	  @AfterTest
	  public void tearDown() throws Exception {
		  
		  LoggerManager.info("Test Create Location <After Test, Should be deleted a Locattion> ");
		 	 
		  /*Find the location created*/
		  LocationPage locationPage  =  new LocationPage(driver);
		  locationIfPresent = locationPage.getLocationByName(nameLocation);
		 
		  /*delete location*/	
		  if (locationIfPresent = true){  	 		  
			  
				  locationPage.checkLocationFound();
				  locationPage.clickRemoveButton();
				  
				  RemoveLocationPage locationRemove = new RemoveLocationPage(driver);
				  locationRemove.clickButtonRemoveLocation(); 			 
				  
				  /*Refresh the page*/
				  driver.navigate().refresh();	
				  LoggerManager.info("Refresh the page, ");
				  LoggerManager.info("Location created exists: "+ locationIfPresent+ " Is deleted(Ok!)!!");	  
		  }
		  else 
		  {
				  driver.navigate().refresh();	
				  LoggerManager.info("Refresh the page");
				  LoggerManager.info("Location created exists: "+ locationIfPresent+ "Is not deleted(NOK!)");	  
		  }
	  }
  @BeforeSuite
  public void seBeforeSuitetUp() throws Exception {	  
	  driver  =  InitWebDrivers.getChromeDriver();
  }
  @AfterSuite
  public void AfterSuite() throws Exception{	  
	  driver.quit();
  }
}

