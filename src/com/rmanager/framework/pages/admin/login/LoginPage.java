package com.rmanager.framework.pages.admin.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rmanager.framework.common.LoggerManager;
import com.rmanager.framework.pages.admin.home.HomePage;

public class LoginPage {
	
	 WebDriver driver;
	 //WebDriverWait wait = new WebDriverWait(driver, 10);//**//
	 By loginButton = Login.LOGIN_BUTTON;
	 
	public LoginPage(WebDriver driver){
		this.driver =driver;
	}	
	public HomePage clickLoginButton(){
		
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(loginButton));
		driver.findElement(loginButton).click();	
		LoggerManager.info("Was clicked on the Login Button in the Home Page");
		return new HomePage(driver);
	}
}
