package com.rmanager.framework.models.common;

import org.openqa.selenium.By;

public interface HomePageModel {
	By LOCATION_BUTTON = By.xpath("//a[contains(text(),'Locations')]");
	By RESOURCES_BUTTON = By.xpath("//a[contains(text(),'Resources')]");
}
