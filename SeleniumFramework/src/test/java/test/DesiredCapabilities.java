package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilities {
	public static void main(String[] args) {
		WebDriverManager.iedriver().setup();	
		WebDriver driver = new InternetExplorerDriver();		
		
		driver.get("https://www.google.com");

		driver.findElement(By.name("q")).sendKeys("a b c d");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		driver.close();

	}
}
