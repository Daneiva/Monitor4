package com.rmanager.framework.pages.admin.conferenceroom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rmanager.framework.common.LoggerManager;
import com.rmanager.framework.models.conferenceroom.RoomInfoPageModel;
import com.rmanager.framework.pages.admin.locations.LocationPage;

public class RoomInfoPage {
	
	WebDriver driver;
	By NameRoom=RoomInfoPageModel.NAME_ROOM;
	By txtBoxDisplayNameRoom=RoomInfoPageModel.TXTBOX_DISPLAYNAME_ROOM;
	By txtBoxCodeRoom=RoomInfoPageModel.TXTBOX_CODE_ROOM;
	By txtBoxCapacityRoom=RoomInfoPageModel.TXTBOX_CAPACITY_ROOM;
	By bttnSave = RoomInfoPageModel.SAVE_BUTTON_ROOM;
	By linkOutOfOrder = RoomInfoPageModel.LINK_OUT_OF_ORDER;
	By linkResourceAssociations = RoomInfoPageModel.LINK_RESOURCES_ASSOCIATIONS;
	
	public RoomInfoPage (WebDriver driver){
		this.driver = driver;
	}
	public OutOfOrderPage clickLinkOutOfOrder(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(linkOutOfOrder));
		driver.findElement(linkOutOfOrder);
		WebElement link = (new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable(linkOutOfOrder));
		driver.findElement(linkOutOfOrder);
		link.click();
		LoggerManager.info("Was clicking in the link: Out Of Order Planning");
		
		return new OutOfOrderPage(driver);
	}
	public ResourcesAssociationsPage clickLinkResourceAssociations(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(linkResourceAssociations));
		driver.findElement(linkResourceAssociations).click();
		LoggerManager.info("Was clicking in the link:  Resource Associations");
		
		return new  ResourcesAssociationsPage(driver);
	}
	public ConferenceRoomPage clickButtonSaveUpdateInfoRoom(){
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(bttnSave));
		driver.findElement(bttnSave).click();
		LoggerManager.info("Was clicking in the Save Button");
		return new ConferenceRoomPage(driver); 
	}
	public String getDisplayNameRoom(){
		WebElement textFieldDisplayNameRoom = new WebDriverWait(driver,60).
				until(ExpectedConditions.presenceOfElementLocated(txtBoxDisplayNameRoom));
		String getNameRoom = textFieldDisplayNameRoom.getAttribute("Value");
		LoggerManager.info("Display Name Room Subject: <" + getNameRoom+ ">");
		return getNameRoom ;
	}
	public void setDisplayNameRoom(String DisplayNameRoom){
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(txtBoxDisplayNameRoom));	
		driver.findElement(txtBoxDisplayNameRoom).clear();
		driver.findElement(txtBoxDisplayNameRoom).sendKeys(DisplayNameRoom);
		LoggerManager.info("Set <Display Name - Room> by: " +DisplayNameRoom);
	}
	public String getCodeRoom(){
		WebElement textFieldCodeRoom = new WebDriverWait(driver,60).
				until(ExpectedConditions.presenceOfElementLocated(txtBoxCodeRoom));
		String getCodeRoom = textFieldCodeRoom.getAttribute("Value");
		LoggerManager.info("Code Subject: <" + getCodeRoom+ ">");
		return getCodeRoom ;
	}
	public void setCodeRoom(String CodeRoom){
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(txtBoxCodeRoom));	
		driver.findElement(txtBoxCodeRoom).clear();
		driver.findElement(txtBoxCodeRoom).sendKeys(CodeRoom);
		LoggerManager.info("Set <Code- Room> by: " +CodeRoom);
	}
	public String getCapacityRoom(){
		WebElement textFieldCapacityRoom = new WebDriverWait(driver,60).
				until(ExpectedConditions.presenceOfElementLocated(txtBoxCapacityRoom));			
		String getCapacityRoom = textFieldCapacityRoom.getAttribute("Value");
		LoggerManager.info("Capacity Subject: <" + getCapacityRoom + ">");
		return getCapacityRoom ;
	}
	public void setCapacityRoom(String CapacityRoom){
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(txtBoxCapacityRoom));
		driver.findElement(txtBoxCapacityRoom).clear();
		driver.findElement(txtBoxCapacityRoom).sendKeys(CapacityRoom);
		LoggerManager.info("Set <Capacity- Room> by: " +CapacityRoom);
	}
}

	
	
