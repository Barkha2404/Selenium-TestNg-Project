package com.seleniumtest.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class MutualLogin
{
	String projectPath;
	WebDriver w;
	
	
	 @BeforeTest
	  public void preCondition()
	 {
	 
		 	projectPath=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",projectPath+ "\\BrowserDriver\\chromedriver.exe");
			w= new ChromeDriver();
			w.manage().window().maximize();// to maximize window 
		 
	 }
			@Test(priority=0,description="Test Case to verify 'admin'login functionality",groups="Altoro Mutual-Login",enabled=true)
		  public void loginAltoroMutual_admin() throws Exception
			
			{
		    
				w.get("http://demo.testfire.net/bank/login.apx");
				w.findElement(By.id("uid")).sendKeys("admin");
				w.findElement(By.id("passw")).sendKeys("admin");				
				w.findElement(By.name("btnSubmit")).click();		
				Thread.sleep(2000);
				w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
				
				Reporter.log("AltoroMutual_Login Successfull !!",true);
			
			}
			
			
			/*@Test(priority=1,description="Test Case to verify 'jsmith'login functionality",invocationCount=2,groups="Altoro Mutual-Login",enabled=true)
			  public void loginAlotroMutual_jsmith() throws Exception
				
				{
			    
					w.get("http://demo.testfire.net/bank/login.apx");
					w.findElement(By.id("uid")).sendKeys("jsmith");
					w.findElement(By.id("passw")).sendKeys("Demo1234");				
					w.findElement(By.name("btnSubmit")).click();		
					Thread.sleep(2000);
					w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
					
					
				
				}
				
			@Test(priority=2,description="Test Case to verify 'sspeed'login functionality",groups="Altoro Mutual-Login",enabled=false)
			  public void loginAlotroMutual_sspeed() throws Exception
				
				{
			    
					w.get("http://demo.testfire.net/bank/login.apx");
					w.findElement(By.id("uid")).sendKeys("sspeed");
					w.findElement(By.id("passw")).sendKeys("Demo1234");				
					w.findElement(By.name("btnSubmit")).click();		
					Thread.sleep(2000);
					w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
					
					
				
				}
				
			
			@Test(priority=3,description="Test Case to verify 'tuser'login functionality",groups="Altoro Mutual-Login",enabled=true)
			  public void loginAlotroMutual_tuser() throws Exception
				
				{
			    
					w.get("http://demo.testfire.net/bank/login.apx");
					w.findElement(By.id("uid")).sendKeys("tuser");
					w.findElement(By.id("passw")).sendKeys("tuser");				
					w.findElement(By.name("btnSubmit")).click();		
					Thread.sleep(2000);
					w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
					
					
				
				}*/
				
			
			@Test(priority=4,description="Group Sample",groups="Sample-groups",invocationCount=1)
			  public void loginAlotroMutual_Sample() 
				
				{
			    
					System.out.println("Sample Test");
					
				
				}

			  @AfterTest
			  public void postCondition() 
			  
			  {
				  w.quit();
			  }

}
