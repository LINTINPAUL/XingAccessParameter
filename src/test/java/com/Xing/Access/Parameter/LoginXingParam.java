package com.Xing.Access.Parameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginXingParam {
	
	@Parameters({ "username", "password" })
	@Test
	public void xing(String username, String password) throws InterruptedException {
		
	
		System.out.println("Parameter for User Name passed as :- " + username);
		System.out.println("Parameter for Password passed as :- " + password);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.xing.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='consent-accept-button']/div/span")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"javascript-content\"]/div[2]/form/button/div")).click();
		Thread.sleep(5000);

		Assert.assertTrue(driver.getTitle().matches("XING"), "Invalid credentials");
		System.out.println("Login successful");
		driver.findElement(By.xpath("//*[@id=\"personalBarProfilePicture\"]")).click();
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div/div/div[1]/header/div/div[3]/div/div/a[7]")).click();
		System.out.println("Logout successful");
		driver.quit();
		
		
	}
}