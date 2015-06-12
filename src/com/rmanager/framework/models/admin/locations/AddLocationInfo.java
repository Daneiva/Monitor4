package com.rmanager.framework.models.admin.locations;

import org.openqa.selenium.By;

public interface AddLocationInfo {

	By TXTBOX_NAME= By.xpath("//input");
	By TXTBOX_DISPLAYNAME= By.xpath("//div[2]/input");
	By XX_PARENTLOCATION= By.xpath("");
	By TXTBOX_DESCRIPTION= By.xpath("//textarea");
	By BUTTON_SAVE= By.xpath("//button[2]");
	By BUTTON_CANCEL= By.xpath("//div[3]/div/button");
	By LAST_POSITION_LIST_LOCATIONS= By.xpath("//div[@id='locationGrid']/div[2]/div/*");
	
}
