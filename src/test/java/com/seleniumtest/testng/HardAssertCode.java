package com.seleniumtest.testng;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HardAssertCode {
	
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
	  @Test(priority=0,description="test to verify login page functionality")
	  public void login_page() throws Exception 
	  {
		  
		  //verify page title"Altoro Mutual"
		  w.get("http://demo.testfire.net/login.jsp");
		  String loginpageTitle= w.getTitle();
		  Assert.assertEquals(loginpageTitle, "Altoro Mutual");
		  //.assertEquals-match
		  
		  String pageURL=w.getCurrentUrl();
		  Assert.assertTrue(pageURL.contains("login.jsp"),"URL is Wrong");
		  //http://demo.testfire.net/login.jsp(assert equals)
		  
		  //verify page label should have"login"
		  
		  WebElement loginPageLabel= w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		  String LoginLabel=loginPageLabel.getText();
		  //Assert.assertEquals(LoginLabel,"Login");
		  Assert.assertTrue(LoginLabel.contains("Login"),"Login is different then expected");  
	  
	  
		  w.findElement(By.id("uid")).sendKeys("admin");
			w.findElement(By.id("passw")).sendKeys("admin");				
			w.findElement(By.name("btnSubmit")).click();		
			Thread.sleep(2000);
	  }
	  
	  
	
	  @Test(priority=1,description="test to verify logout page functionality",dependsOnMethods="login_page")
	  public void logout()
	  {
		  
		  String homePageTitle=w.getTitle();
		  Assert.assertEquals(homePageTitle, "Altoro Mutual");
		  
		  WebElement homePageLabel =w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
	
		  String homeLabel=homePageLabel.getText();
		  Assert.assertEquals(homeLabel, "Admin");
		  //Assert.assertTrue
		  w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
				  
		  
		  
	  
	  }
	
	  @AfterTest
	  public void afterTest() 
	  {
		  	w.quit();
	  }

}
