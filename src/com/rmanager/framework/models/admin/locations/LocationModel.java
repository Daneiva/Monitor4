package com.rmanager.framework.models.admin.locations;

import org.openqa.selenium.By;

public interface LocationModel {

By ADD_LOCATION_BUTTON= By.xpath("//div[4]/div/button");
By REMOVEE_LOCATION_BUTTON = By.xpath("//button[2]");
By LIST_LOCATIONS= By.xpath("//div[2]/div[2]/div/div");
By CUSTOM_NAME_IN_LIST_LOCATION =By.className("ngCellText");
}