package com.rmanager.framework.models.conferenceroom;

import org.openqa.selenium.By;

public interface RoomInfoPageModel {

	By NAME_ROOM = By.cssSelector("button.btn.btn-default");
	By TXTBOX_DISPLAYNAME_ROOM = By.xpath("(//input[@type='text'])[4]");
	By TXTBOX_CODE_ROOM = By.xpath("(//input[@type='text'])[5]");
	By TXTBOX_CAPACITY_ROOM = By.xpath("(//input[@type='text'])[6]");
	By SAVE_BUTTON_ROOM=By.xpath("//div[3]/div[2]/button");
	By SAVE_CANCEL_ROOM=By.cssSelector("button.btn-clear");
	By LINK_OUT_OF_ORDER=By.xpath("(//a[@onclick='checkBreadCrumb(this)'])[3]");
	By LINK_RESOURCES_ASSOCIATIONS=By.xpath("(//a[@onclick='checkBreadCrumb(this)'])[2]");
	
}
