package com.seleniumtest.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class css_linktext {
	
	String projectPath;
	WebDriver w;
	
	@BeforeTest
	  public void beforeTest() 
	
	{

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\BrowserDriver\\chromedriver.exe");
		WebDriver w= new ChromeDriver();
		w.manage().window().maximize();// to maximize window 
		
			
	}
	
	
	
  @Test
  public void csslinktextex() throws Exception
  {
	  
	  w.get("https://opensource-demo.orangehrmlive.com/");
  

	  w.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
	  
	  w.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys("admin123");
	  
	  w.findElement(By.cssSelector("input.button")).click();
	  
	  Thread.sleep(2000);
	  
	  w.findElement(By.linkText("Welcome Paul")).click();
	  
	  Thread.sleep(2000);
	  w.findElement(By.linkText("Logout")).click();
	  
	  
	  
  }
  
  

  @AfterTest
  public void afterTest()
  
  {
	//  w.quit();
  }

}
