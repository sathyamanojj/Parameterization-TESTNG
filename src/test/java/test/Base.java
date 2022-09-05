package test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utils.common;

public class Base {
	
	common common;
	String browser = "chrome";
	String url = "https://www.shopclues.com/";
	// Navigate to the web application: https://www.shopclues.com/
	

	static WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		common = new common();
		common.setupBrowser(browser, url);
		driver = common.getDriver();
		//Maximize browser window
		 driver.manage().window().maximize();
		
		/*
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

					wait.until(
							ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/button[1]")));

					driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/button[1]")).click();
					*/
	}

	@AfterTest
	public void afterTest() {
		common.quitBrowser();
	} 


}

