package com.rmanager.framework.pages.admin.locations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rmanager.framework.common.LoggerManager;
import com.rmanager.framework.models.admin.locations.AddLocationInfoModel;
import com.rmanager.framework.models.admin.locations.LocationModel;

public class LocationPage {
	
	WebDriver driver;
	By RemoveButton = LocationModel.REMOVEE_LOCATION_BUTTON;
	By AddLocationButton = LocationModel.ADD_LOCATION_BUTTON;
	By ListLocations = LocationModel.LIST_LOCATIONS;
	By CustonNameInList = LocationModel.CUSTOM_NAME_IN_LIST_LOCATION;
	By LastLocationInList = AddLocationInfoModel.LAST_POSITION_LIST_LOCATIONS;
		
	public LocationPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void checkLocationFound(){
		int lastPosition = (((driver.findElements(LastLocationInList).size())));
		new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(LastLocationInList));
		driver.findElement(By.xpath("//div[@id='locationGrid']/div[2]/div/div["+lastPosition+"]/div[2]/div[2]/div")).click();
		new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='locationGrid']/div[2]/div/div["+lastPosition+"]/div[2]/div[2]/div")));
		LoggerManager.info("check Location Found LP");
	}
	public RemoveLocationPage clickRemoveButton(){
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(RemoveButton));
	    driver.findElement(By.xpath("//button[2]")).click();
	    new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[2]")));
	    LoggerManager.info("click Remove Button");
	    return new RemoveLocationPage(driver);
	}
	public AddLocationTab clickAddLocationButton(){
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(AddLocationButton));
		driver.findElement(AddLocationButton).click();
		LoggerManager.info("Was clicked on the <Add> Button by Locations, Location Add-Tab Opened");
		return new AddLocationTab(driver);
	}	
	public boolean getLocationByName(String locationCustomName){
		/*Looking for the created location*/
		boolean found= false;
		
		//getSelenium().waitForPageToLoad(WAIT_FOR_PAGE_TO_LOAD_TIMEOUT);
	    List<WebElement> locations = driver.findElements(CustonNameInList);
	    
	    for(int i = 1 ; i < locations.size(); i+=2){
	    	if(locations.get(i).getText().equals(locationCustomName)){
	    		found = true;
	    		break;
	    	}
	    }	   
	    LoggerManager.info("Location, exists?"+ found);
	    return found;
	}
	public boolean selectLocationByCustomName(String locationCustomName){
		/*Looking for the created location*/
		
		boolean found= false;
		Actions action = new Actions(driver);
		
	    List<WebElement> locations = driver.findElements(CustonNameInList);
	    
	    for(int i = 0 ; i < locations.size(); i+=2){
	    	if(locations.get(i).getText().equals(locationCustomName)){
	    		found = true;
	    		new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(CustonNameInList));
	    		action.doubleClick(locations.get(i)).perform();	    	    
	    		break;	    		
	    	}	    
	    }	
	    LoggerManager.info("select Location By Custom Name"+ found);
	    return found;
	    
	}	
}
