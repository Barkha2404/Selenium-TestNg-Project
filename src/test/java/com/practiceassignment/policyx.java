package com.practiceassignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class policyx {
	
	String projectPath;
	WebDriver w;
	
	@BeforeTest
	  public void preConditions()
	{

		projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\BrowserDriver\\chromedriver.exe");
		w= new ChromeDriver();
		w.manage().window().maximize();
	
	}

	  @Test
	  public void login_page() throws Exception
	  {
		  w.get("https://www.policyx.com/"); 
		  WebElement loginPageLabel= w.findElement(By.xpath("//*[@id=\"page1\"]/section[1]/div/div/div[2]/h1"));
		  String LoginLabel=loginPageLabel.getText();
		  Assert.assertEquals(LoginLabel,"India's Most Trusted Insurance Portal");
		  
		  String loginpageTitle= w.getTitle();
		  Assert.assertTrue(loginpageTitle.contains("Insurance"));
		  
		  w.findElement(By.xpath("//*[@id=\"page1\"]/header/div/div[4]/div[4]/a")).click();
		  WebElement claimTitle=w.findElement(By.xpath("//*[@id=\"page1\"]/div[2]/div/div/div[1]/h1"));
		  String claimTitletext=claimTitle.getText();
		  Assert.assertEquals(claimTitletext, "CLAIM ASSISTANCE");
		  
		  
		  String pageT=w.getTitle();
		  Assert.assertTrue(pageT.contains("Claim Process"));
		  Thread.sleep(2000);
		
		  
		  
	  }
	  
	  @AfterTest
	  public void afterTest()
	  {
		  w.quit();
	  }

}
