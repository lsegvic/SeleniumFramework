package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.GoogleSearchPageObjects;

public class TestNGListenerDemo {

	@Test
	public void test1() {
		System.out.println("I am inside test1");
	}

	@Test
	public void test2() {
		System.out.println("I am inside test2");

		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();		

		driver.get("https://www.google.com");

		driver.findElement(By.name("q")).sendKeys("Automation step by step");

		driver.findElement(By.name("abc")).sendKeys(Keys.RETURN);	
		
		driver.close();
	}

	@Test
	public void test3() {
		System.out.println("I am inside test3");
		throw new SkipException("This test is skipped");
	}

}
