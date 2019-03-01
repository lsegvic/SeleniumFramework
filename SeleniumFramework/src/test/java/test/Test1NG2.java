package test;

import java.util.concurrent.SynchronousQueue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1NG2 {
	
	static WebDriver driver = null;

	@BeforeTest
	public void setupTest() {
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}
	
	@Test
	public static void googleSearch2() {	
		
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);						
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");

	}
}
