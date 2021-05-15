package com.practiceassignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SuperCalculator {
	
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
	
  @Test(priority = 0, description = "Addition 5+5 to get result 10")
  public void calculateAdd() throws Exception
  {
	  	w.get("https://juliemr.github.io/protractor-demo/");
	  	Thread.sleep(1000);
	  	w.findElement(By.xpath("/html/body/div/div/form/input[1]")).clear();
	  	w.findElement(By.xpath("/html/body/div/div/form/input[1]")).sendKeys("5");
	  	
	  	WebElement operator=w.findElement(By.xpath("/html/body/div/div/form/select"));
	  	
	  	Select op=new Select(operator);
	  	
	  	op.selectByValue("ADDITION");
	  	
	  	w.findElement(By.xpath("/html/body/div/div/form/input[2]")).clear();
	  	w.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys("5");
	  	
	  	Thread.sleep(1000);
	  	w.findElement(By.id("gobutton")).click();
	  	Thread.sleep(3000);
	  	String Aoutput=w.findElement(By.cssSelector("h2.ng-binding")).getText();
	  	Assert.assertEquals(Aoutput, "10");
	  	
	  	
  }
  
  @Test(priority=1,description="Substraction 5-3 to get result 2")
  public void calculateSub() throws Exception
  {
	  Thread.sleep(2000);
	  
	  w.findElement(By.xpath("/html/body/div/div/form/input[1]")).clear();
	  w.findElement(By.xpath("/html/body/div/div/form/input[1]")).sendKeys("5");
	  Thread.sleep(1000);
	  WebElement operator=w.findElement(By.xpath("/html/body/div/div/form/select"));
	  	
	  	Select op=new Select(operator);
	  
	  	op.selectByValue("SUBTRACTION");
	  	w.findElement(By.xpath("/html/body/div/div/form/input[2]")).clear();
	  	w.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys("3");
	  	Thread.sleep(1000);
	  	w.findElement(By.id("gobutton")).click();
	  	String soutput=w.findElement(By.cssSelector("h2.ng-binding")).getText();
	  	Assert.assertEquals(soutput, "2");
	  	
  }

  
  @Test(priority=2,description="Substraction 3*3 to get result 9")
  public void calculatemulti() throws Exception
  {
	  		Thread.sleep(2000);
	  
			  w.findElement(By.xpath("/html/body/div/div/form/input[1]")).clear();
			  w.findElement(By.xpath("/html/body/div/div/form/input[1]")).sendKeys("3");
			  
			  Thread.sleep(1000);
			  WebElement operator=w.findElement(By.xpath("/html/body/div/div/form/select"));
			  	
			  Select op=new Select(operator);
			  
			  op.selectByValue("MULTIPLICATION");
			  w.findElement(By.xpath("/html/body/div/div/form/input[2]")).clear();
			  w.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys("3");
			  Thread.sleep(1000);
			  w.findElement(By.id("gobutton")).click();
	
			  String moutput=w.findElement(By.cssSelector("h2.ng-binding")).getText();
			  	Assert.assertEquals(moutput, "9");
  }
  @Test(priority=3,description="Substraction 4/2 to get result 2")
  public void calculatediv() throws Exception
  {
	  		Thread.sleep(2000);
	  
			  w.findElement(By.xpath("/html/body/div/div/form/input[1]")).clear();
			  w.findElement(By.xpath("/html/body/div/div/form/input[1]")).sendKeys("4");
			  
			  Thread.sleep(1000);
			  WebElement operator=w.findElement(By.xpath("/html/body/div/div/form/select"));
			  	
			  Select op=new Select(operator);
			  
			  op.selectByValue("DIVISION");
			  w.findElement(By.xpath("/html/body/div/div/form/input[2]")).clear();
			  w.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys("2");
			  Thread.sleep(1000);
			  w.findElement(By.id("gobutton")).click();
			  Thread.sleep(2000);
			  String doutput=w.findElement(By.cssSelector("h2.ng-binding")).getText();
			  	Assert.assertEquals(doutput, "2");
			  
			  
	  
  }
  @AfterTest
  public void postConditions() 
  {
	  w.quit();
  }

}
