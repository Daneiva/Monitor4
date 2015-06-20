package com.rmanager.test.locations;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
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

public class TestDeleteLocation {
	
	  private WebDriver driver;	  
	  private AppConfig PropertyAppConfig =  new AppConfig();
	  private boolean locationIfPresent;	
	  
	  /*Variables*/
	  String nameLocation = "Namelocation11";
	  String displayNameLocation = "display"+ nameLocation;
	  String descriptionLocation = "description"+ nameLocation;
	  String msgError= "The location: " + nameLocation + " was not deleted";
	  
  @BeforeTest
  public void BeforeTest() throws Exception {		
	
	LoggerManager.info("Test Delete Location <Before, Should be created a Locattion> ");
	
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
  public void DeleteLocation()throws InterruptedException {
	  
	  LoggerManager.info("Test Delete Location");	
	  
	  /*Steps*/	  
	  /*Find the location for updated*/
	  LocationPage locationPage=  new LocationPage(driver); 	 
	  /*Find the location for deleted*/
	  locationIfPresent = locationPage.getLocationByName(nameLocation);	      
	  /*Location is checked for deleted*/
		  locationPage.checkLocationFound();		  
		  locationPage.clickRemoveButton();		  
		  RemoveLocationPage locationRemove = new RemoveLocationPage(driver);
		  locationRemove.clickButtonRemoveLocation();  		 
		  
		  /*Refresh the page*/
		  driver.navigate().refresh();		  
		  LoggerManager.info("Refresh the page");
		  locationIfPresent = locationPage.getLocationByName(nameLocation);	  
		  
		  /*Asserts*/			 
		  Assert.assertFalse( locationIfPresent, msgError );
		  LoggerManager.info("Assert Test Deleted <Location: " + nameLocation + "> was deleted!");
		  /*Refresh the page*/
		  driver.navigate().refresh();	
		  LoggerManager.info("Refresh the page - Test Delete Location");
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
