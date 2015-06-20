package com.rmanager.framework.models.conferenceroom;

import org.openqa.selenium.By;

public interface OutOfOrderPageModel {
	By START_HOUR_OUT_OF_ORDER = By.xpath("(//input[@type='text'])[4]");
	By START_MINS_OUT_OF_ORDER = By.xpath("(//input[@type='text'])[5]");
	By START_AM_PM_OUT_OF_ORDER= By.xpath("(//button[@type='button'])[55]");
	By END_HOUR_OUT_OF_ORDER = By.xpath("(//input[@type='text'])[7]");
	By END_MINS_OUT_OF_ORDER = By.xpath("(//input[@type='text'])[8]");
	By END_AM_PM_OUT_OF_ORDER= By.xpath("(//button[@type='button'])[105]");
	By TITLE_OUT_OF_ORDER = By.xpath("(//input[@type='text'])[9]");
	By DESCRIPTIOM_OUT_OF_ORDER = By.xpath("//textarea");
	By SAVE_BUTTON_OUT_OF_ORDER = By.xpath("//div[3]/div[2]/button");
}
