package com.rmanager.framework.pages.admin.locations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rmanager.framework.common.LoggerManager;
import com.rmanager.framework.models.admin.locations.AddLocationInfoModel;

public class AddLocationTab {
	
	WebDriver driver;	
	
	By txtName = AddLocationInfoModel.TXTBOX_NAME;
	By txtDisplayName = AddLocationInfoModel.TXTBOX_DISPLAYNAME;
	By txtDescription= AddLocationInfoModel.TXTBOX_DESCRIPTION;
	By bttnSave=AddLocationInfoModel.BUTTON_SAVE;
	By bttnCancel=AddLocationInfoModel.BUTTON_CANCEL;	
	
	public AddLocationTab(WebDriver driver){
		this.driver =driver;
	}
	
	public void setNameLocation(String Name){		
		
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(txtName));
		driver.findElement(txtName).clear();
		driver.findElement(txtName).sendKeys(Name);
		LoggerManager.info("Set <Name location> by: " +Name);
	}	
	public void setDisplayNameLocation(String DisplayName){			
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(txtDisplayName));
		driver.findElement(txtDisplayName).clear();
		driver.findElement(txtDisplayName).sendKeys(DisplayName);
		LoggerManager.info("Set <Display Name location> by: " +DisplayName);
	}	
	
	public void setDescriptionLocation(String Description){		
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(txtDescription));
		driver.findElement(txtDescription).clear();
		driver.findElement(txtDescription).sendKeys(Description);
		LoggerManager.info("Set <Description location> by: " +Description);
	}	
	
	public LocationPage clickButtonSaveLocation(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(bttnSave));
		driver.findElement(bttnSave).click();
		LoggerManager.info("Was clicking in the Save Button");
		return new LocationPage(driver);
		
	}	
}
