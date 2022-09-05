package POM;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Login {
	private WebDriver driver;

	@CacheLookup
	@FindBy(xpath = "//*[@id='nav_46']/a")
	WebElement menuOption;

	@CacheLookup
	@FindBy(xpath = "//*[@id='column_1']/ul/li[4]/a")
	WebElement selectcurtain;

	@CacheLookup
	@FindBy(id = "det_img_124453395")
	WebElement FirstItemVisible;

	@CacheLookup
	@FindBy(xpath = "//*[@class='img_section img_280\']")
	WebElement image;

	@CacheLookup
	@FindBy(xpath = "//*[@id='add_cart']")
	WebElement AddtoCart;

	@CacheLookup
	@FindBy(xpath = "//div[@id='snackbar' and @class ='show']")
	WebElement ProductTitle;

	@CacheLookup
	@FindBy(xpath = "//*[@id='nav_82']/a")
	WebElement Essentials;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'column_0\']/ul/li[4]/a")
	WebElement coffee;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'det_img_143522179\']")
	WebElement coffeeFirstproduct;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav_44\']/a")
	WebElement MobileandElectronics;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'column_2\']/ul/li[7]/a")
	WebElement Cables;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'det_img_152401132\']")
	WebElement CablesFirstProduct;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waits() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/button[1]")));

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/button[1]")).click();
	}

	public void HomeandKitchen(String prodtype ,String prod) {
		
				if(prodtype.equalsIgnoreCase("HomeKitchen"))
				{
		Actions actions = new Actions(driver);
		actions.moveToElement(menuOption).perform();
		selectcurtain.click();
		if(prod.equalsIgnoreCase("curtainss"))
		{
			try {
				SwitchTabs();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				}

	}

	public void SwitchTabs() throws InterruptedException {
		ArrayList<String> tab1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(1));
		Thread.sleep(5000);

		image.click();
	}

	public void Addcarttab() throws InterruptedException {
		ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(2));

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement AddtoCart = driver.findElement(By.xpath("//*[@id='add_cart']"));
		// Dimension abc =AddtoCart.getSize();
		// System.out.println(abc);
		// Scroll the web page till the web element is found
		js.executeScript("window.scrollBy(200,48)", "");

		AddtoCart.click();
		System.out.println("added to cart succesfully");

	}

	public void titleValidation() {
		String expectedTitle = "Product added to cart";
		// String actualTitle= driver.findElement(By.xpath("//div[@id='snackbar' and
		// @class ='show']")).getText();
		String actualTitle = ProductTitle.getText();
		System.out.println("actual value produced is " + actualTitle);
		System.out.println("expected value produced is " + expectedTitle);
		// String actualTitle = driver.getTitle();
		// System.out.println("actual title is " +actualTitle);

		Reporter.log("Expected title = " + expectedTitle);
		Reporter.log("Actual title = " + actualTitle);

		assertTrue(actualTitle.equals(expectedTitle), "Product added to cart");
	}

	public void DailyEssentials(String prodtype ,String prod) {

		

		if(prodtype.equalsIgnoreCase("Daily Essentials"))
		{
			Actions actions = new Actions(driver);
			actions.moveToElement(Essentials).perform();
			coffee.click();
if(prod.equalsIgnoreCase("Coffee &amp; Tea"))
{
	try {
		SwitchTabscoffee();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
		}
	}

	public void SwitchTabscoffee() throws InterruptedException {
		ArrayList<String> tab1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(1));
		Thread.sleep(5000);
		coffeeFirstproduct.click();

	}

	public void Mobile_and_Electronics(String prodtype ,String prod) {

		
		if(prodtype.equalsIgnoreCase("MobileElectronics"))
		{
			Actions actions = new Actions(driver);
			actions.moveToElement(MobileandElectronics).perform();
			Cables.click();
if(prod.equalsIgnoreCase("Cabless"))
{
	try {
		SwitchTabsMobile();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
		}

	}

	public void SwitchTabsMobile() throws InterruptedException {
		ArrayList<String> tab1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(1));
		Thread.sleep(5000);
		CablesFirstProduct.click();

	}

	public void delaywait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/button[1]")));

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/button[1]")).click();
	}
/*
	public void SelectProduct(String prodcategory) throws InterruptedException {
		int category;
		if (prodcategory == "Home and Kitchen") {
			category = 1;
		} else if (prodcategory == "Daily Essentials") {
			category = 2;
		} else {
			category = 3;
		}

		switch (category) {
		case 1: {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Login obj1 = new Login(driver);
			obj1.delaywait();
			obj1.HomeandKitchen();
			System.out.println("Done Mouse hover on 'Home and Kitchen' from Menu");
			obj1.SwitchTabs();
			obj1.Addcarttab();
			obj1.titleValidation();
			break;
		}
		case 2: {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Login obj1 = new Login(driver);
			obj1.DailyEssentials();
			System.out.println("Done Mouse hover on 'Essentials' from Menu");
			obj1.SwitchTabscoffee();
			obj1.Addcarttab();
			obj1.titleValidation();
			break;
		}
		case 3: {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Login obj1 = new Login(driver);
			obj1.Mobile_and_Electronics();
			System.out.println("Done Mouse hover on 'Mobile and Electronics' from Menu");
			obj1.SwitchTabsMobile();
			obj1.Addcarttab();
			obj1.titleValidation();
			break;
		}

		} 
	} */
}
	
