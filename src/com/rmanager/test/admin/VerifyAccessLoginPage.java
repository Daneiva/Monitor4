package com.rmanager.test.admin;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.rmanager.framework.pages.admin.login.LoginPage;
import com.rmanager.framework.properties.appConfig;

public class VerifyAccessLoginPage {
	  //variables a utilizar
      private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private appConfig PropertyAppConfig =  new appConfig();
	  
	@BeforeTest
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = PropertyAppConfig.getBaseURL();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  @Test
  public void methodLoginPage() {
	  
	  driver.get(baseUrl + "/admin/#/login");
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.clickLoginButton();
  }
  
  @AfterTest
  public void tearDown() throws Exception {
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
