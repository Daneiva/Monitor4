package com.rmanager.framework.pages.admin.locations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.rmanager.test.*;

import com.rmanager.framework.models.admin.locations.AddLocationInfo;
import com.rmanager.framework.pages.admin.home.HomePage;

public class AddLocationTab {
	
	WebDriver driver;	
	
	By txtName = AddLocationInfo.TXTBOX_NAME;
	By txtDisplayName = AddLocationInfo.TXTBOX_DISPLAYNAME;
	By txtDescription= AddLocationInfo.TXTBOX_DESCRIPTION;
	By bttnSave=AddLocationInfo.BUTTON_SAVE;
	By bttnCancel=AddLocationInfo.BUTTON_CANCEL;

		
	
	public AddLocationTab(WebDriver driver){
		this.driver =driver;
	}
	
	public void setNameLocation(String Name){			
		new WebDriverWait(driver,100).until(ExpectedConditions.presenceOfElementLocated(txtName));
		//driver.findElement(txtName).clear();
		driver.findElement(txtName).sendKeys(Name);
	}
	
	public void setDisplayNameLocation(String DisplayName){			
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(txtDisplayName));
		//driver.findElement(txtDisplayName).clear();
		driver.findElement(txtDisplayName).sendKeys(DisplayName);
	}	
	
	public void setDescriptionLocation(String Description){		
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(txtDescription));
		//driver.findElement(txtDescription).clear();
		driver.findElement(txtDescription).sendKeys(Description);
	}
	
	public HomePage clickButtonSaveLocation(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(bttnSave));
		driver.findElement(bttnSave).click();				
		return new HomePage(driver);
	}
	
	
}
