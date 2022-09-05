package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM.Login;

public class LoginValidation2 extends Base {
	
	@Test(enabled = true)
	public void delaywait()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/button[1]")));

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/button[1]")).click();
	}
 
	
    @Parameters({"ProductCategory","Product"})
	@Test(dependsOnMethods = {"delaywait"})
	public void Hover_Menu(String prodtype,String prod) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		Login obj1 = new Login(driver);
		obj1.HomeandKitchen(prodtype,prod);
		System.out.println("Done Mouse hover on 'Home and Kitchen' from Menu");
		Reporter.log("home and kitchen successfully executed");
		obj1.SwitchTabs();
		obj1.Addcarttab();
		obj1.titleValidation();
	}
	
	
	
}

