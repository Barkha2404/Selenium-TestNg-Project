package com.seleniumtest.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class TestYouLogin {
	
	String projectPath;
	WebDriver w;
	
	@BeforeTest
	  public void beforeTest()
	
	{
		 projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\BrowserDriver\\chromedriver.exe");
		
		 w= new ChromeDriver();
		
		w.manage().window().maximize();// to maximize window 
	}
	
		  @Test(priority=0)
		  public void TestYou_Login() throws Exception
		  
		  {

				//Step 1 : Open Application with uRL  
				w.get("http://www.testyou.in/Login.aspx");
				
				w.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).clear();
				w.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("Selenium99");
				
				w.findElement(By.id("ctl00_CPHContainer_txtPassword")).clear();
				w.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys("Selenium99");
				
				w.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();
				
				Thread.sleep(2000);
				
				w.findElement(By.id("ctl00_headerTopStudent_lnkbtnSignout")).click();
				
				Reporter.log("TestYouLogin Successfull !!",true);
		  }
		  
		
		  @AfterTest
		  public void afterTest() 
		  
		  {
			  w.quit();
			  
		  }
		
		}
