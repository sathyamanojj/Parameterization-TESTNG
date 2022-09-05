package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM.Login;

public class Mobiles_Electronics2 extends Base {
	@Test(enabled = false)
	public void delaywait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/button[1]")));

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/button[1]")).click();
		
	}
	
	 @Parameters({"ProductCategory","Product"})
	@Test
	public void Mobile_Electronics( String prodtype,String prod)throws InterruptedException {

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Login obj1 = new Login(driver);
		obj1.Mobile_and_Electronics(prodtype,prod);
		System.out.println("Done Mouse hover on 'Mobile and Electronics' from Menu");
		Reporter.log("Mobile and Electronics successfully executed");
		obj1.SwitchTabsMobile();
		obj1.Addcarttab();
		obj1.titleValidation();
	}

}

