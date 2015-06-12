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
	  
	  String nameLocation = "Namelocation22";
	  String displayNameLocation = "displayNamelocation22";
	  String descriptionLocation = "descriptionNamelocation22";	 
	  
	  driver.get(PropertyAppConfig.getUrlAdmin());
	  LoginPage loginPage = new LoginPage(driver);
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

