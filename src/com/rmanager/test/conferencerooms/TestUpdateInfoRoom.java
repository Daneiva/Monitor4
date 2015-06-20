package com.rmanager.test.conferencerooms;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rmanager.framework.common.InitWebDrivers;
import com.rmanager.framework.common.LoggerManager;
import com.rmanager.framework.pages.admin.conferenceroom.ConferenceRoomPage;
import com.rmanager.framework.pages.admin.conferenceroom.RoomInfoPage;
import com.rmanager.framework.pages.admin.home.HomePage;
import com.rmanager.framework.pages.admin.login.LoginPage;
import com.rmanager.framework.properties.AppConfig;

public class TestUpdateInfoRoom {
	  private WebDriver driver;	  
	  private AppConfig PropertyAppConfig =  new AppConfig();
	  
	  String roomSelected =  "SM-Room7";//,"SM-Room8","SM-Room6","SM-Room1","SM-Room10","SM-Room11","SM-Room12","SM-Room13";
	 
	  String displayNameRoomOld;
	  String capacityRoomOld;
	  String codeRoomOld;
	  
	  String msgError= "The Room: " + roomSelected + " was not updateed";  
	  Random Value = new Random();
	  
		/*Variables*/
		String randomCapacity = Integer.toString(Value.nextInt(999)+1);// between 1 and 999, more 1.
		String randomCode = "Code-" + randomCapacity;
		String displayNameRoom = "Room Info Update"; 
	  
	  @Test
	  public void testUpdateInfoRoom() {
		  LoggerManager.info("Test Update Info Room <After, > ");
		  /*Steps*/	 
		  driver.get(PropertyAppConfig.getUrlAdmin());
		  driver.navigate().refresh();	
		  
		  LoginPage loginPage = new LoginPage(driver);
			 
		  HomePage homePage = loginPage.clickLoginButton();
		  ConferenceRoomPage conferenceRoomPage = homePage.clickConferenceRoomButton();	  
		  //RoomInfoPage roomInfoTab = conferenceRoomPage.selectRandomRoom();
		  RoomInfoPage roomInfoTab = conferenceRoomPage.selectRoomByName(roomSelected);
		  displayNameRoomOld = roomInfoTab.getDisplayNameRoom();
		  roomInfoTab.setDisplayNameRoom(displayNameRoom);
		  
		  roomInfoTab.setCodeRoom(randomCode);
		  roomInfoTab.setCapacityRoom(randomCapacity);
		  roomInfoTab.clickButtonSaveUpdateInfoRoom();
		 
		  boolean ifRoomUpdatedExist = conferenceRoomPage.getRoomByName(displayNameRoom);
		  /*Asserts*/
		  Assert.assertTrue( ifRoomUpdatedExist, msgError );
	  }
  @AfterTest
  public void tearDown() throws Exception {	  
	  LoggerManager.info("Test Updated Info Room <After, The room data should be updated with original Display Name>");
	  /*Steps*/	 
	  ConferenceRoomPage conferenceRoomPage = new ConferenceRoomPage(driver);
	  //RoomInfoPage roomInfoTab = conferenceRoomPage.selectRandomRoom();
	  RoomInfoPage roomInfoTab = conferenceRoomPage.selectRoomByName(displayNameRoom);
	  displayNameRoomOld = roomInfoTab.getDisplayNameRoom();
	  roomInfoTab.setDisplayNameRoom(roomSelected);
	  roomInfoTab.clickButtonSaveUpdateInfoRoom();
	 
	  boolean ifRoomUpdatedExist = conferenceRoomPage.getRoomByName(roomSelected);
	  LoggerManager.info("The original Display Name of room is = "+ ifRoomUpdatedExist);
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
