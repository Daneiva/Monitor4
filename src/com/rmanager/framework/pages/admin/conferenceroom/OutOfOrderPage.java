package com.rmanager.framework.pages.admin.conferenceroom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.rmanager.framework.models.conferenceroom.OutOfOrderPageModel;

public class OutOfOrderPage  {
	WebDriver driver;
	
	
		By startHourOutOfOrder = OutOfOrderPageModel.START_HOUR_OUT_OF_ORDER;
		By startMinsOutOfOrder= OutOfOrderPageModel.START_MINS_OUT_OF_ORDER;
		By startAmPmOutOfOrder= OutOfOrderPageModel.START_AM_PM_OUT_OF_ORDER;
		By endHourOutOfOrder = OutOfOrderPageModel.END_HOUR_OUT_OF_ORDER;
		By endMinsOutOfOrder = OutOfOrderPageModel.END_MINS_OUT_OF_ORDER;
		By endAmPmOutOfOrder = OutOfOrderPageModel.END_AM_PM_OUT_OF_ORDER;
		By titleOutOfOrder= OutOfOrderPageModel.TITLE_OUT_OF_ORDER;
		By descriptiomOutOfOrder= OutOfOrderPageModel.DESCRIPTIOM_OUT_OF_ORDER;
		By saveButtonOutOfOrder	= OutOfOrderPageModel.SAVE_BUTTON_OUT_OF_ORDER;
		
		
		
	
	public OutOfOrderPage(WebDriver driver){
		this.driver = driver;
	}
}
