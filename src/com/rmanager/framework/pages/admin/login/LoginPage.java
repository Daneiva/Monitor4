package com.rmanager.framework.pages.admin.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rmanager.framework.pages.admin.home.HomePage;

public class LoginPage {
	
	 WebDriver driver;
	 //WebDriverWait wait = new WebDriverWait(driver, 10);//**//
	 By loginButton = Login.LOGIN_BUTTON;
	 
	public LoginPage(WebDriver driver){
		this.driver =driver;
	}	
	public HomePage clickLoginButton(){
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
		(new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(loginButton));
		driver.findElement(loginButton).click();				
		return new HomePage(driver);
	}
}
