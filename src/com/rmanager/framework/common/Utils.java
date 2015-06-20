package com.rmanager.framework.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rmanager.framework.models.conferenceroom.ConferenceRoomPageModel;
import com.rmanager.framework.pages.admin.conferenceroom.RoomInfoPage;
import com.rmanager.framework.properties.AppConfig;

public class Utils {
	
	static AppConfig PropertyAppConfig =new AppConfig();
	
	
	public static void doubleClickRoom(WebElement element, WebDriver driver){
		Actions action = new Actions(driver); 			
		action.click(element);		
		action.doubleClick(element);
		action.perform();		
	}
	public static String getValueTextField(WebElement textFieldName){
		
		String getNameRoom = textFieldName.getAttribute("Value");
		LoggerManager.info("The value is: <" + getNameRoom+ ">");
		return getNameRoom;
	}	
	public void setValueTextField(String setValue, WebElement textFieldName){
			/*
		driver.findElement(textFieldName).clear();
		driver.findElement(textFieldName).sendKeys(setValue);
		LoggerManager.info("Set <Value> is: " + textFieldName);*/
	}
	public static ArrayList<String> intervalTime() {
		  ArrayList<String> intervalTime = new ArrayList<String>(); 		 
		  Calendar time = Calendar.getInstance();  
		  
		    intervalTime.add((time.get(Calendar.HOUR)+1)+"");
			intervalTime.add(time.get(Calendar.MINUTE)+"");
			if ((time.get(Calendar.AM_PM)+"").equals("0")){				
				intervalTime.add("AM");}
			else{
				intervalTime.add("PM");}
			intervalTime.add((time.get(Calendar.HOUR)+2)+"");
			intervalTime.add(time.get(Calendar.MINUTE)+"");
			if ((time.get(Calendar.AM_PM)+"").equals("0")){				
				intervalTime.add("AM");}
			else{
				intervalTime.add("PM");}
					
			return intervalTime;
	}
	public static RoomInfoPage selectRoomByName(WebDriver driver, String name){
		By TitleTableRooms = ConferenceRoomPageModel.TITLE_TABLE_ROOMS;
		By List = ConferenceRoomPageModel.LIST_ROOM;
		By SubList = ConferenceRoomPageModel.SUBLIST_ROOM;
		new WebDriverWait(driver,80).until(ExpectedConditions.presenceOfElementLocated(TitleTableRooms));
		String roomName= name;
		
		/*Looking the room*/		
		boolean found= false;		
		
		new WebDriverWait(driver,80).until(ExpectedConditions.presenceOfElementLocated(TitleTableRooms));
		WebElement list = driver.findElement(List);
		List<WebElement> subList = list.findElements(SubList); 		
	    for(int i = 0 ; i < subList.size(); i+=1){
	    	String valueGet = (subList.get(i).getText()).trim();
	    	String valueRoom = roomName.trim();	    	
	    	if(valueGet.equals(valueRoom)){
	    		System.out.println("Room:" + subList.get(i).getText()+ " = " + roomName);
	    		found = true;	  
	    		doubleClickRoom(subList.get(i), driver); 
	    		LoggerManager.info("select Location By Custom Name: "+ found);
	    		break;
	    	}	    	    	
	    }	
	    return new RoomInfoPage(driver);	
	}
	public static boolean existOutOfOrder(WebDriver driver,String roomName){
		By TitleTableRooms = ConferenceRoomPageModel.TITLE_TABLE_ROOMS;
		By List = ConferenceRoomPageModel.LIST_ROOM;
		By SubList = ConferenceRoomPageModel.SUBLIST_ROOM;
		//new WebDriverWait(driver,80).until(ExpectedConditions.presenceOfElementLocated(TitleTableRooms));
		//String roomName= PropertyAppConfig.getRoomSelected();
		/*Looking the room*/		
		boolean found= false;		
		
		new WebDriverWait(driver,80).until(ExpectedConditions.presenceOfElementLocated(TitleTableRooms));
		WebElement list = driver.findElement(List);
		List<WebElement> subList = list.findElements(SubList); 		
	    for(int i = 0 ; i < subList.size(); i+=1){
	    	String valueGet = (subList.get(i).getText()).trim();
	    	String valueRoom = roomName.trim();	    	
	    	if(valueGet.equals(valueRoom)){
	    		System.out.println("Room:" + subList.get(i).getText()+ " Found!");	  
	    		try{
	    			subList.get(i).findElement(By.xpath("div[2]/div[2]/out-of-order-icon/div/div/div/span"));
	    			found = true;
	    		} 
	    		catch(Exception e)
	    		{	    			
	    		}   		 
	    		break;
	    	}	    	    	
	    }	
	    LoggerManager.info("Out Of Order Planning exist? "+ found);
	    return found;	
	}
	
	public static String generateRandomString(){
        char[] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int counter = 0; counter < 25; counter++) {
            char character = chars[random.nextInt(chars.length)];
            sb.append(character);
        }
        return sb.toString();
	}

}
