package com.w2a.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwapnoTest {
	public String key = "webdriver.chrome.driver";
	public String value = "C:\\Users\\ibnsa\\Downloads\\New folder\\chromedriver.exe";
	public String baseURL = "https://www.shwapno.com/";
	public WebDriver driver;
	
	@BeforeTest
	public void setUp() {
//		System.out.println("Opera is launching");
		System.setProperty(key, value);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	
  @Test
  public void operation() {
	  Select drpCity = new Select(driver.findElement(By.id("state")));
	  drpCity.selectByVisibleText("Dhaka");
	  Select drpArea = new Select(driver.findElement(By.id("city")));
	  drpArea.selectByVisibleText("Gopibag");
	  driver.findElement(By.id("btnFindStore")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
}