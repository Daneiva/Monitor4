package com.rmanager.framework.pages.admin.conferenceroom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rmanager.framework.common.LoggerManager;
import com.rmanager.framework.models.conferenceroom.ConferenceRoomPageModel;

public class ConferenceRoomPage {
	
	WebDriver driver;
	
	By ConferenceRoomRoomLink = ConferenceRoomPageModel.RANDOM_ROOM_LINK;
	By TitleTableRooms = ConferenceRoomPageModel.TITLE_TABLE_ROOMS;
	//By RoomNameInList = ConferenceRoomPageModel.ROOM_NAME_IN_LIST;
	By List = ConferenceRoomPageModel.LIST_ROOM;
	
	public ConferenceRoomPage(WebDriver driver){
		
		this.driver = driver;
	}
	public RoomInfoPage selectRandomRoom(){			
			
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(TitleTableRooms));
		LoggerManager.info("Title of Table Rooms: OK");
		WebElement WebElememtRoomLink = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(ConferenceRoomRoomLink));
		doubleClickRoom(WebElememtRoomLink);
		LoggerManager.info("Was Select Room "+WebElememtRoomLink+", Opened Room Info Page");
		return new RoomInfoPage(driver);
	}
	private void doubleClickRoom(WebElement element){
		Actions action = new Actions(driver); 			
		action.click(element);		
		action.doubleClick(element);
		action.perform();		
	}	
	public RoomInfoPage selectRoomByName(String roomName){
		/*Looking the room*/		
		boolean found= false;		
		
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(TitleTableRooms));
		WebElement list = driver.findElement(List);
		List<WebElement> subList = list.findElements(By.xpath("div")); 		
	    for(int i = 0 ; i < subList.size(); i+=1){
	    	String valueGet = (subList.get(i).getText()).trim();
	    	String valueRoom = roomName.trim();	    	
	    	if(valueGet.equals(valueRoom)){
	    		System.out.println("Room:" + subList.get(i).getText()+ " = " + roomName);
	    		found = true;	  
	    		doubleClickRoom(subList.get(i)); 
	    		LoggerManager.info("select Location By Custom Name: "+ found);
	    		break;
	    	}	    	    	
	    }	
	    return new RoomInfoPage(driver);	
	}
	public boolean getRoomByName(String roomUpName){
		/*Looking for the created location*/
		boolean found= false;		
		
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(TitleTableRooms));
		WebElement list = driver.findElement(List);
		List<WebElement> subList = list.findElements(By.xpath("div")); 		
	    for(int i = 0 ; i < subList.size(); i+=1){
	    	String valueGet = (subList.get(i).getText()).trim();
	    	String valueRoom = roomUpName.trim();
	    	if(valueGet.equals(valueRoom)){
	    		found = true;
	    		LoggerManager.info("select Room By Name"+ found);	
	    	}
	    }	   
	    LoggerManager.info("Room, exists? "+ found);
	    return found;
	}
	public void test(){
		WebElement padre = driver.findElement(By.xpath("//div[@id='roomsGrid']/div[2]/div"));
		
		List<WebElement> hijos = padre.findElements(By.xpath("div"));
		
		
		for(WebElement room:hijos ){
			room.findElement(By.xpath("div/div[2]/div/div/div/span")).click();
			System.out.println(room.getText());
		}
	}
	
}

