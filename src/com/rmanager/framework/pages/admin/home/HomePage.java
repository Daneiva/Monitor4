package com.rmanager.framework.pages.admin.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rmanager.framework.models.common.HomePageModel;
import com.rmanager.framework.pages.admin.locations.*;

public class HomePage {

	WebDriver driver;

	By LocationButton = HomePageModel.LOCATION_BUTTON;
	By ResourcesButton = HomePageModel.RESOURCES_BUTTON;
	
	public HomePage(WebDriver driver){
		this.driver =driver;
	}	
	
	public LocationPage clickLocationButton(){
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(LocationButton));
		driver.findElement(LocationButton).click();
		return new LocationPage(driver);
	}
	
}
