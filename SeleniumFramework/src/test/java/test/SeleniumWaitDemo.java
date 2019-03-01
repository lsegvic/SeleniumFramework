package test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitDemo {

	public static void main(String[] args) throws Exception {
		seleniumWaits();
	}

	public static void seleniumWaits () throws Exception {

		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.com");

		driver.findElement(By.name("q")).sendKeys("Automation step by step");

		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);	

		//WebDriverWait wait = new WebDriverWait(driver, 20);



		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkElement = driver.findElement(By.linkText("Automation Step By Step - AACC.org"));


				if (linkElement.isEnabled()) {
					System.out.println("element found");				
				}
				return linkElement;
			} 					

		});
		
		element.click();

		driver.close();
		driver.quit();
	}


} 
