package com.selenium.test.testing.selenium_march;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HRMLogin 
{

	public static void main(String[] args) throws Exception
	{
		
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\BrowserDriver\\chromedriver.exe");
		
		WebDriver w= new ChromeDriver();
		
		w.manage().window().maximize();// to maximize window 
		
		//Step 1 : Open Application with uRL  
		w.get("https://opensource-demo.orangehrmlive.com");
		
		//Step 2: Enter User Name 
		w.findElement(By.id("txtUsername")).clear();
		w.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		//Step 3: Enter password 
		w.findElement(By.id("txtPassword")).clear();
		w.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		//Step 4: Click login 
		w.findElement(By.className("button")).click();
		
		Thread.sleep(3000);
		
		//Step 5: Logout
		w.findElement(By.id("welcome")).click();
		
		Thread.sleep(2000);
		
		w.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).click();
		
		
		Thread.sleep(2000);
		
		w.quit();
		
		
	}

}
