package com.rmanager.framework.models.conferenceroom;

import java.util.Random;

import org.openqa.selenium.By;

public interface ConferenceRoomPageModel {
	
	Random room = new Random();
	int valorDado = room.nextInt(9)+3;  // between 0 and 9, more 3.	
	
	By RANDOM_ROOM_LINK = By.xpath("//div["+valorDado+"]/div[3]/div[2]/div/span[2]");
	
	By TITLE_TABLE_ROOMS = By.cssSelector("div.ngGroupPanelDescription.ng-binding");
	//By ROOM_NAME_IN_LIST = By.ByClassName("");
	By LIST_ROOM = By.xpath("//div[@id='roomsGrid']/div[2]/div");
	By SUBLIST_ROOM =By.xpath("div");
	
}

