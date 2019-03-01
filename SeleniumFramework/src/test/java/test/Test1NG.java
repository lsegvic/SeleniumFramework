package test;

import java.util.concurrent.SynchronousQueue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1NG {
	
	static WebDriver driver = null;
	public static String browserName=null;


	@BeforeTest
	public void setupTest() {
		
		PropertiesFile.getProperties();
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();	
			driver = new FirefoxDriver();
		}
		driver.get("https://www.google.com");
	}
	
	@Test
	public static void googleSearch() {	
		
		
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);						
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		//driver.quit();
		System.out.println("Test completed successfully");
		PropertiesFile.setProperties();
	}
}
