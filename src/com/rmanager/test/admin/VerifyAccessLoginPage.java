package com.rmanager.test.admin;

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.rmanager.framework.common.InitWebDrivers;
import com.rmanager.framework.pages.admin.login.LoginPage;
import com.rmanager.framework.properties.AppConfig;

public class VerifyAccessLoginPage {
	  //variables a utilizar
      private WebDriver driver;	  

	  private StringBuffer verificationErrors = new StringBuffer();
	  private AppConfig PropertyAppConfig =  new AppConfig();	 
	@BeforeTest
	  public void setUp() throws Exception {		
		
		//driver = InitWebDrivers.getFirefoxDriver();
		driver = InitWebDrivers.getChromeDriver();	 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	   
	  }
  @Test
  public void methodLoginPage() throws InterruptedException {
	  driver.get(PropertyAppConfig.getUrlAdmin());	  
	  LoginPage loginPage = new LoginPage(driver);	  
	  loginPage.clickLoginButton();
	  Thread.sleep(5000);
  }
  
  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
