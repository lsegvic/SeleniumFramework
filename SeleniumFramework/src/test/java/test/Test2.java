package test;

import java.util.concurrent.SynchronousQueue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.GoogleSearchPage;

public class Test2 {
	
	private static WebDriver driver = null;
	public static void main(String[] args) {
		googleSearch();
	}
	
	public static void googleSearch() {
		
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");

		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);

		//driver.findElement(By.name("q")).sendKeys("Automation step by step");		
		//driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		
		driver.close();
		
		System.out.println("Test completed successfully");
	}
}
