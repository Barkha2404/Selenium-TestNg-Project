package com.seleniumtest.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class softAssertCode
{
	String projectPath;
	WebDriver w;
	SoftAssert st;
	
	@BeforeTest
	  public void preConditions()
	{
		projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\BrowserDriver\\chromedriver.exe");
		w= new ChromeDriver();
		w.manage().window().maximize();
		
	}

	
	
  @Test
  public void Login_Page() throws Exception
  {
	  st=new SoftAssert();
	  
	  w.get("http://demo.testfire.net/login.jsp");
	  String loginpageTitle= w.getTitle();
	  st.assertEquals(loginpageTitle, "Altoro Mutual");
	  
	  String pageURL=w.getCurrentUrl();
	  st.assertTrue(pageURL.contains("login.jsp"),"URL is Wrong");
	  
	  WebElement loginPageLabel= w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
	  String LoginLabel=loginPageLabel.getText();  
	  st.assertTrue(LoginLabel.contains("Login"),"Login is different then expected");
	  
	  w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");				
		w.findElement(By.name("btnSubmit")).click();		
		Thread.sleep(2000);
		
		st.assertAll();
		
  }
  @Test(priority=1,description="test to verify logout page functionality",dependsOnMethods="Login_Page")
  
  public void logout()
  {
	  
	  String homePageTitle=w.getTitle();
	  st.assertEquals(homePageTitle, "Altoro Mutual");
	  
	  WebElement homePageLabel =w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));

	  String homeLabel=homePageLabel.getText();
	  st.assertTrue(homeLabel.contains("Admin"));
	  	  
	  w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
			  
	  st.assertAll();
	  
  }
			  @AfterTest
			  public void postConditions() 
			  	{
				  w.quit();
			  	}
  	
}
