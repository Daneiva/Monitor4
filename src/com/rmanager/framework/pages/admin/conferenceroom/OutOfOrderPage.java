package com.rmanager.framework.pages.admin.conferenceroom;

import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rmanager.framework.common.LoggerManager;
import com.rmanager.framework.common.Utils;
import com.rmanager.framework.models.conferenceroom.OutOfOrderPageModel;
import com.rmanager.framework.pages.admin.locations.LocationPage;

public class OutOfOrderPage  {
	WebDriver driver;	
	
		By startHourOutOfOrder = OutOfOrderPageModel.START_HOUR_OUT_OF_ORDER;
		By startMinsOutOfOrder = OutOfOrderPageModel.START_MINS_OUT_OF_ORDER;
		By startAmPmOutOfOrder  = OutOfOrderPageModel.START_AM_PM_OUT_OF_ORDER;
		By endHourOutOfOrder = OutOfOrderPageModel.END_HOUR_OUT_OF_ORDER;
		By endMinsOutOfOrder = OutOfOrderPageModel.END_MINS_OUT_OF_ORDER;
		By endAmPmOutOfOrder = OutOfOrderPageModel.END_AM_PM_OUT_OF_ORDER;
		By titleOutOfOrder= OutOfOrderPageModel.TITLE_OUT_OF_ORDER;
		By descriptionOutOfOrder= OutOfOrderPageModel.DESCRIPTIOM_OUT_OF_ORDER;
		By saveButtonOutOfOrder	= OutOfOrderPageModel.SAVE_BUTTON_OUT_OF_ORDER;
	
	public OutOfOrderPage(WebDriver driver){
		this.driver = driver;
	}
	public String getTItle(){
		return Utils.getValueTextField(new WebDriverWait(driver,60).
		until(ExpectedConditions.presenceOfElementLocated(titleOutOfOrder)));
	}
	public void setStartTime(){
		ArrayList<String> startTime= Utils.intervalTime();
		System.out.println(startTime);
		new WebDriverWait(driver,60).
		until(ExpectedConditions.presenceOfElementLocated(startHourOutOfOrder));
		new WebDriverWait(driver,60).
		until(ExpectedConditions.presenceOfElementLocated(startMinsOutOfOrder));
		new WebDriverWait(driver,60).
		until(ExpectedConditions.presenceOfElementLocated(startAmPmOutOfOrder));
		driver.findElement(startHourOutOfOrder).clear();
		driver.findElement(startHourOutOfOrder).sendKeys(startTime.get(0));
		driver.findElement(startMinsOutOfOrder).clear();
		driver.findElement(startMinsOutOfOrder).sendKeys(startTime.get(1));
		driver.findElement(startAmPmOutOfOrder).clear();
		driver.findElement(startAmPmOutOfOrder).sendKeys(startTime.get(2));
 	    LoggerManager.info("Set <To: Time Out Of Order> by: "
					+ startTime.get(0)+":"+ startTime.get(1) +" "+ startTime.get(2));
	}
	
	public void setEndTime(){
		ArrayList<String> endTime= Utils.intervalTime();
		new WebDriverWait(driver,60).
		until(ExpectedConditions.presenceOfElementLocated(endHourOutOfOrder));
		new WebDriverWait(driver,60).
		until(ExpectedConditions.presenceOfElementLocated(endMinsOutOfOrder));
		new WebDriverWait(driver,60).
		until(ExpectedConditions.presenceOfElementLocated(endAmPmOutOfOrder));
		driver.findElement(endHourOutOfOrder).clear();
		driver.findElement(startHourOutOfOrder).sendKeys(endTime.get(3));
		driver.findElement(endMinsOutOfOrder).clear();
		driver.findElement(startHourOutOfOrder).sendKeys(endTime.get(4));
		driver.findElement(endAmPmOutOfOrder).clear();
		driver.findElement(startHourOutOfOrder).sendKeys(endTime.get(5));		
 	    LoggerManager.info("Set <To: Time Out Of Order> by: "
 	    					+ endTime.get(3) +":"+ endTime.get(4)+" "+ endTime.get(5));
	}
	public void setDescription(){
		
		new WebDriverWait(driver,60).
		until(ExpectedConditions.presenceOfElementLocated(descriptionOutOfOrder));
		 driver.findElement(descriptionOutOfOrder).clear();
			driver.findElement(descriptionOutOfOrder).sendKeys(Utils.generateRandomString());
			LoggerManager.info("Description: "+ Utils.generateRandomString());	
			
	}
	public String setRandomTitle() {

        String [] combo = {   "Temporarily Out of Order", 
			        		"Closed for maintenance", 
			        		"Closed for reparations", 
			        		"Reserved for a special event",
        					"Different: AGARSTSASDFAS"};        
        Random random = new Random();
        // randomly selects an index from the combo
        int select = random.nextInt(combo.length); 
        new WebDriverWait(driver,80).
        until(ExpectedConditions.presenceOfElementLocated(titleOutOfOrder));        
                
        driver.findElement(titleOutOfOrder).clear();
        
		driver.findElement(titleOutOfOrder).sendKeys(combo[select]);
		LoggerManager.info("Random Title: "+combo[select]);
	return combo[select];
	}
	
	public LocationPage clickSaveButtonOutOfOrder(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(saveButtonOutOfOrder));
		driver.findElement(saveButtonOutOfOrder).click();
		LoggerManager.info("Was Clicking Save Button Out Of Order");
		return new LocationPage(driver);
	}
}
