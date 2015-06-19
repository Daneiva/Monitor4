package com.rmanager.framework.models.admin.locations;

import org.openqa.selenium.By;

public interface RemoveLocationModel {
	By MESSAGE_REMOVE_LOCATION = By.xpath("//div[2]/div[2]/div/div/div");//There are not rooms associated

	By BUTTON_REMOVE = By.cssSelector("button.btn.btn-primary"); 
	By BUTTON_CANCEL = By.xpath("//div[3]/div/button");
	By CORNER_CANCEL = By.xpath("//span/i");	
}
