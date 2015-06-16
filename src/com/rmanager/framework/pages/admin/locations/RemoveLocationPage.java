package com.rmanager.framework.pages.admin.locations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rmanager.framework.models.admin.locations.RemoveLocationModel;
import com.rmanager.framework.pages.admin.home.HomePage;

public class RemoveLocationPage {

	WebDriver driver;
	
	By messagRemoveLocation = RemoveLocationModel.MESSAGE_REMOVE_LOCATION;
	By buttonRemove  = RemoveLocationModel.BUTTON_REMOVE; 
	By buttonCancel = RemoveLocationModel.BUTTON_CANCEL;
	By cornerCancel = RemoveLocationModel.CORNER_CANCEL;
	
public RemoveLocationPage (WebDriver driver){
	this.driver = driver;
}
public LocationPage clickButtonRemoveLocation(){
(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(buttonRemove));
driver.findElement(buttonRemove).click();				
return new LocationPage(driver);
}

}
