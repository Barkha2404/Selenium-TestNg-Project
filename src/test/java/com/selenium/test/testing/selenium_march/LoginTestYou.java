package com.selenium.test.testing.selenium_march;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestYou {

	public static void main(String[] args) throws Exception
	
	{
	
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\BrowserDriver\\chromedriver.exe");
		
		WebDriver w= new ChromeDriver();
		
		w.manage().window().maximize();// to maximize window 
		
		//Step 1 : Open Application with uRL  
		w.get("http://www.testyou.in/Login.aspx");
		
		w.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).clear();
		w.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("Selenium99");
		
		w.findElement(By.id("ctl00_CPHContainer_txtPassword")).clear();
		w.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys("Selenium99");
		
		w.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();
		
		Thread.sleep(2000);
		
		w.findElement(By.id("ctl00_headerTopStudent_lnkbtnSignout")).click();
	}

}
