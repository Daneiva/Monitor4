package com.rmanager.framework.models.admin.locations;

import org.openqa.selenium.By;

public interface AddLocationInfoModel {

	By TXTBOX_NAME= By.id("location-add-name");
	By TXTBOX_DISPLAYNAME= By.id("location-add-display-name");
	By XX_PARENTLOCATION= By.xpath("");
	By TXTBOX_DESCRIPTION= By.xpath("//textarea");
	By BUTTON_SAVE= By.xpath("//button[2]");
	By BUTTON_CANCEL= By.xpath("//div[3]/div/button");
	By LAST_POSITION_LIST_LOCATIONS= By.xpath("//div[@id='locationGrid']/div[2]/div/*");
}
