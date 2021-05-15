package com.selenium.test.testing.selenium_march;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest
{

	public static void main(String[] args)
	
	{
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\BrowserDriver\\chromedriver.exe");
		
		WebDriver w= new ChromeDriver();
		
		w.manage().window().maximize();// to maximize window 
		
		//Step 1 : Open Application with uRL  
		w.get("http://demo.testfire.net/bank/login.apx");
		
		//Step 2: Enter User Name 
		w.findElement(By.id("uid")).sendKeys("admin");
		
		//Step 3: Enter password 
		w.findElement(By.id("passw")).sendKeys("admin");
		
		//click login
		w.findElement(By.name("btnSubmit")).click();
		
		//Step 5: Click logout
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
		
		//close browser 
		w.quit();
		
		
	}

}