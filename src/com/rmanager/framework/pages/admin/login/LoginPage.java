package com.rmanager.framework.pages.admin.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.rmanager.framework.pages.admin.home.HomePage;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver =driver;
	}	
	public HomePage clickLoginButton(){
		driver.findElement(By.xpath("//button")).click();
		return new HomePage(driver);
	}
}
