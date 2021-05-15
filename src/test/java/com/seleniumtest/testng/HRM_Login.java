package com.seleniumtest.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class HRM_Login 

{
	String projectPath;
	WebDriver w;
	
	@BeforeTest
	  public void beforeTest() 
	{
		projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\BrowserDriver\\chromedriver.exe");
		
		w= new ChromeDriver();
		w.manage().window().maximize();
		
	
	}
	
	@Test
  public void Login() throws Exception
	{
		w.get("https://opensource-demo.orangehrmlive.com");
		w.findElement(By.id("txtUsername")).clear();
		w.findElement(By.id("txtUsername")).sendKeys("Admin");
		w.findElement(By.id("txtPassword")).clear();
		w.findElement(By.id("txtPassword")).sendKeys("admin123");
		w.findElement(By.className("button")).click();
		w.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		
		w.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).click();
		
		
		Thread.sleep(2000);
		Reporter.log("OrangeHRM_Login Successfull !!",true);
	
	
	}
  

  @AfterTest
  public void afterTest() 
  {
  
	  w.quit();
  }

}
