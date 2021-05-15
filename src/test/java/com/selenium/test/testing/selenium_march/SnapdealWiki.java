package com.selenium.test.testing.selenium_march;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SnapdealWiki {

	public static void main(String[] args) throws Exception
	{
		
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\BrowserDriver\\chromedriver.exe");

		WebDriver w= new ChromeDriver();
		w.manage().window().maximize();// to maximize window 
		
		w.get("https://google.co.in/");
		w.findElement(By.name("q")).click();
		w.findElement(By.name("q")).sendKeys("Snapdeal");
		
		w.findElement(By.name("btnK")).click();
		
		Thread.sleep(2000);
		
	
		
		
	}

}
