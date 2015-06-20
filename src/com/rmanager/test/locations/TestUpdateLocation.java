package com.rmanager.test.locations;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rmanager.framework.common.InitWebDrivers;
import com.rmanager.framework.common.LoggerManager;
import com.rmanager.framework.pages.admin.home.HomePage;
import com.rmanager.framework.pages.admin.locations.AddLocationTab;
import com.rmanager.framework.pages.admin.locations.LocationPage;
import com.rmanager.framework.pages.admin.locations.RemoveLocationPage;
import com.rmanager.framework.pages.admin.login.LoginPage;
import com.rmanager.framework.properties.AppConfig;

public class TestUpdateLocation {
	
	  private WebDriver driver;	  
	  private AppConfig PropertyAppConfig =  new AppConfig();
	  private boolean locationIfPresent;	
	  
	  /*Variables for created*/	  
	  String nameLocation = "Namelocation100";
	  String displayNameLocation = "display"+ nameLocation;
	  String descriptionLocation = "description"+ nameLocation;
	  String msgError= "The location: " + nameLocation + "was not UPdated";
	  
	  /*Variables for updated*/	  
	  String nameUpdateLocation = "Update"+ nameLocation;
	  String displayNameUpdateLocation = "display"+ nameUpdateLocation;
	  String descriptionUpdateLocation = "description"+ nameUpdateLocation;
	 
	  @BeforeTest
	  public void before() throws Exception {		
	
		  LoggerManager.info("Test Update Location <Before, Should be created a Locattion> ");

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
		   		  
	  }	 
  @Test
  public void UpdateLocation() throws InterruptedException {
	 
	  LoggerManager.info("Test Update Location");
	  
	  
	  LocationPage locationPage  =  new LocationPage(driver);
	  /*Steps*/	  
	  /*Find the location for updated*/
	  locationIfPresent = locationPage.getLocationByName(nameLocation);
		  
	  if(locationIfPresent = true){
	  /*Select the location for updated*/
	  locationPage.selectLocationByCustomName(displayNameLocation);	  
	  AddLocationTab locationTab = new AddLocationTab(driver); 	  	
	  locationTab.setNameLocation(nameUpdateLocation);
	  locationTab.setDisplayNameLocation(displayNameUpdateLocation);	
	  locationTab.setDescriptionLocation(descriptionUpdateLocation);	
	  locationTab.clickButtonSaveLocation();	
	  /*Refresh the page*/
	  driver.navigate().refresh();	
	  LoggerManager.info("Refresh the page");
	  /*Find the location created*/
	  locationIfPresent = locationPage.getLocationByName(nameUpdateLocation);
	  LoggerManager.info(nameUpdateLocation+ "<= Location updated exists: "+ locationIfPresent);
	  /*Asserts*/	  
	  Assert.assertTrue( locationIfPresent,msgError );
	  LoggerManager.info("Assert Test Update <Location: " + nameUpdateLocation+ "> was updated!");
	  
	  /*Refresh the page*/
	  driver.navigate().refresh();	
	  LoggerManager.info("Refresh the page - Test Update Location");
	  }
  }
  
  @AfterTest
  public void tearDown() throws Exception {
	  
	  LoggerManager.info("Test Update Location <After, Should be deleted a Locattion> ");
	 	 
	  /*Find the location created*/
	  LocationPage locationPage  =  new LocationPage(driver);
	  locationIfPresent = locationPage.getLocationByName(nameUpdateLocation);
	 
	  /*delete location*/	
	  if (locationIfPresent = true){  	 		  
		  
			  locationPage.checkLocationFound();
			  locationPage.clickRemoveButton();
			  
			  RemoveLocationPage locationRemove = new RemoveLocationPage(driver);
			  locationRemove.clickButtonRemoveLocation(); 			 
			  
			  /*Refresh the page*/
			  driver.navigate().refresh();	
			  LoggerManager.info("Refresh the page");
			  LoggerManager.info("Location created exists: "+ locationIfPresent + " Is deleted(Ok!)!!");	  
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
