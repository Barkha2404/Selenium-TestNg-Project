package com.seleniumtest.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class webObjectsP {
	
	String projectPath;
	WebDriver w;
	
	@BeforeTest
	  public void preCondition() 
	{
		projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\BrowserDriver\\chromedriver.exe");
		w= new ChromeDriver();
		w.manage().window().maximize();
	}
	
  @Test(priority = 0, description = "Test cases for Textbox Field")
  public void textBox_Field() throws Exception
  {
	  w.get("http://demo.automationtesting.in/Register.html");
	  
	  w.findElement(By.cssSelector("input[ng-model='FirstName']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Damon");
	  
	  Thread.sleep(1000);
	  w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Salvatore");
	  Thread.sleep(1000);
	  w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
	  w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("Mystic Falls 123559-CA");
	  Thread.sleep(1000);
	  w.findElement(By.cssSelector("input[ng-model='EmailAdress']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='EmailAdress']")).sendKeys("abc@orginals.com");
	  Thread.sleep(1000);
	  w.findElement(By.cssSelector("input[ng-model='Phone']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='Phone']")).sendKeys("00112233445");
	  
	  
	 
	  
	  
	  
  }
  @Test(priority = 1, description = "Test cases for Radio Button")
	public void radio_Button() 
  	{

		w.findElement(By.cssSelector("input[value='FeMale']")).click();
	}
  
  @Test(priority = 2, description = "Test cases for Checkbox")
	public void checkbox_Field() throws Exception
  {
	  Thread.sleep(1000);  
		w.findElement(By.id("checkbox1")).click();
		w.findElement(By.cssSelector("input[value='Hockey']")).click();
	}
  
  @Test(priority = 3, description = "Test cases for List Box")
	public void listbox_Field() throws Exception
{
	  w.findElement(By.id("msdd")).click();
	  Thread.sleep(1000);  
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a")).click();
	  Thread.sleep(1000);
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[12]/a")).click();
	  
	
		
	}
  
  
  
  @Test(priority = 4, description = "Test cases for Drop down")
	public void dropDown_list() throws Exception
  {
	  Thread.sleep(2000);  
	  
	  WebElement skillsDropDown= w.findElement(By.id("Skills"));
	  WebElement countriesDropDown=w.findElement(By.id("countries"));

	  Select s = new Select(skillsDropDown);
	  Select c=new Select(countriesDropDown);
	  
	  s.selectByIndex(14);
	  
	//sel.selectByValue("APIs"); // html option tag - > value
	//sel.selectByVisibleText("CSS"); // actual text from drop down
	  
	  c.selectByValue("Bulgaria");
	  
  }
		
  
  
  @AfterTest
  public void afterTest() 
  {
	  
  }

}
