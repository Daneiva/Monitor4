package com.rmanager.test.conferencerooms;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.rmanager.framework.common.InitWebDrivers;
import com.rmanager.framework.common.LoggerManager;
import com.rmanager.framework.common.Utils;
import com.rmanager.framework.pages.admin.conferenceroom.OutOfOrderPage;
import com.rmanager.framework.pages.admin.conferenceroom.RoomInfoPage;
import com.rmanager.framework.pages.admin.home.HomePage;
import com.rmanager.framework.pages.admin.login.LoginPage;
import com.rmanager.framework.properties.AppConfig;

public class TestCreateOutOfOrder {
	 private WebDriver driver;	  
	 private AppConfig PropertyAppConfig =  new AppConfig();
	 boolean isPresentOutOfOrder;
	 String msgError= "The Out Of Order was not created!";
	 private String roomSelected= "SM-Room4";
  @Test
  public void TestCresateOutOfOrder() {
	  LoggerManager.info("Test created Out Of Order Planning");
	  /*Steps*/	 
	  driver.get(PropertyAppConfig.getUrlAdmin());
	  driver.navigate().refresh();	
	  LoginPage loginPage = new LoginPage(driver);		 
	  HomePage homePage = loginPage.clickLoginButton();
      homePage.clickConferenceRoomButton();		  
	  RoomInfoPage roomInfoTab = Utils.selectRoomByName(driver, roomSelected);
	  OutOfOrderPage outOfOrderPage = roomInfoTab.clickLinkOutOfOrder();
	  //outOfOrderPage.setStartTime();
	  //outOfOrderPage.setEndTime();
	  outOfOrderPage.setRandomTitle();
	  outOfOrderPage.setDescription();
	  outOfOrderPage.clickSaveButtonOutOfOrder();
	  isPresentOutOfOrder = Utils.existOutOfOrder(driver,roomSelected);
	  /*Asserts*/	  
	  Assert.assertTrue( isPresentOutOfOrder,msgError );
	  LoggerManager.info("Assert Test Create Out Of Order Planing was created:"+ isPresentOutOfOrder);
	  LoggerManager.info(" Test Create Out Of Order");
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
