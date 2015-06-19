package com.rmanager.framework.pages.admin.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rmanager.framework.common.LoggerManager;
import com.rmanager.framework.models.common.HomePageModel;
import com.rmanager.framework.pages.admin.conferenceroom.ConferenceRoomPage;
import com.rmanager.framework.pages.admin.locations.*;

public class HomePage {

	WebDriver driver;

	By LocationButton = HomePageModel.LOCATION_BUTTON;
	By ResourcesButton = HomePageModel.RESOURCES_BUTTON;
	By ConferenceRoomButton = HomePageModel.CONFERENCE_ROOM_BUTTON;
	
			
	public HomePage(WebDriver driver){
		this.driver =driver;
	}		
	public LocationPage clickLocationButton(){
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(LocationButton));
		driver.findElement(LocationButton).click();
		LoggerManager.info("Was clicked on the  Location Button");
		return new LocationPage(driver);
	}	
	public ConferenceRoomPage clickConferenceRoomButton(){
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(LocationButton));
		driver.findElement(ConferenceRoomButton).click();
		LoggerManager.info("Was clicked on the Conference Room Button");
		return new ConferenceRoomPage(driver);
	}
	public LocationPage clickResourcesButton(){
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(ResourcesButton));
		driver.findElement(ResourcesButton).click();
		LoggerManager.info("Was clicked on the  Resources Button");
		return new LocationPage(driver);
	}
}
