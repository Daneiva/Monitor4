package com.rmanager.framework.pages.admin.locations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rmanager.framework.models.admin.locations.AddLocationInfo;
import com.rmanager.framework.models.admin.locations.Location;
import com.rmanager.framework.pages.admin.locations.*;

public class LocationPage {
	
	WebDriver driver;
	
	By AddLocationButton = Location.ADD_LOCATION_BUTTON;
	By ListLocations = Location.LIST_LOCATIONS;
	By CustonNameInList = Location.CUSTOM_NAME_IN_LIST_LOCATION;
	By lastLocationInList = AddLocationInfo.LAST_POSITION_LIST_LOCATIONS;
	
	public LocationPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void CheckLocationFound(){
		int lastPosition = (((driver.findElements(lastLocationInList).size())));         
	    driver.findElement(By.xpath("//div[@id='locationGrid']/div[2]/div/div["+lastPosition+"]/div[2]/div[2]/div")).click();	    	    
	}
	public AddlocationTab clickRemoveButton(){
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[2]")));
	    driver.findElement(By.xpath("//button[2]")).click();
	    
	}
	public AddLocationTab clickAddLocationButton(){
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(AddLocationButton));
		driver.findElement(AddLocationButton).click();
		return new AddLocationTab(driver);
	}
	
	public boolean getLocationByCustomName(String locationCustomName){
		/*Looking for the created location*/
		boolean found= false;
		
	    List<WebElement> locations = driver.findElements(CustonNameInList);
	    
	    for(int i = 1 ; i < locations.size(); i+=2){
	    	if(locations.get(i).getText().equals(locationCustomName)){
	    		found = true;
	    		break;
	    	}
	    }
	    //logger.info("Look for the location");
	    return found;
	}
	
}
