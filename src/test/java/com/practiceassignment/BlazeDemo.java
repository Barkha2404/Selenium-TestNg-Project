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

public class BlazeDemo {
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
  	
	@Test(priority=0,description="test to verify Page Title ")
	public void blaze_demo() throws Exception
		
		{
				w.get("http://blazedemo.com/");
				String pageTitle=w.getTitle();
				Assert.assertTrue(pageTitle.contains("BlazeDemo"));
				System.out.println("Page Title is:"+pageTitle);
		}
		
	@Test(priority=1,description="test to select departure ")
	public void blaze_dept() throws Exception
		  {
		
			Thread.sleep(1000);
			WebElement dropdown_fromPort = w.findElement(By.name("fromPort"));
			Select d=new Select(dropdown_fromPort);
			d.selectByValue("Boston");
		  }
	
	@Test(priority=2,description="Test to select destination")
	public void blaze_des() throws Exception
	{
			
			
		WebElement dropdown_toPort = w.findElement(By.name("toPort"));
		Select ds=new Select(dropdown_toPort);
		ds.selectByIndex(2);
		
		w.findElement(By.xpath("/html/body/div[3]/form/div/input")).click();	
		Thread.sleep(2000);
		w.findElement(By.cssSelector("input[value='Choose This Flight']")).click();
		Thread.sleep(2000);
	}
		
  @Test(priority=3,description="Test to verify Airline")
  public void blaze_flight() throws Exception
  {
	  	String airline = w.findElement(By.xpath("/html/body/div[2]/p[1]")).getText(); // (Airline: United)
		Assert.assertTrue(airline.contains("United"));
	
		
		//  String airlineValue[] = airline.split(" ");
		//	System.out.println(airlineValue[0]);
		//	System.out.println(airlineValue[1]);
		

		String flightNo = w.findElement(By.xpath("/html/body/div[2]/p[2]")).getText(); // (Flight Number: UA954)
		Assert.assertTrue(flightNo.contains("UA954"));
		
		

	//	String flightNoValue[] = flightNo.split(" ");
	//	System.out.println(flightNoValue[0]);
	//	System.out.println(flightNoValue[1]);
	//	System.out.println(flightNoValue[2]);

		// Assert.assertEquals(flightNoValue[2], "UA954");
		
		String totalCost=w.findElement(By.xpath("/html/body/div[2]/p[5]/em")).getText();
		String price =w.findElement(By.xpath("/html/body/div[2]/p[3]")).getText();
		System.out.println("Price ->"+price);
		String splitPrice[]=price.split(" ");
		
		 //Converting String value to int
			int price_int=Integer.parseInt(splitPrice[1]);
			
			String fees_tax=w.findElement(By.xpath("/html/body/div[2]/p[4]")).getText();
			System.out.println("Fees Tax ->"+fees_tax);
			
			String splitfees_tax[]=fees_tax.split(" ");
			
			 //Converting String value to double
			double fees_tax_double=Double.parseDouble(splitfees_tax[4]);
			
			//Add
			double total_of_price_feesTax=price_int + fees_tax_double;
			
			 //Converting double value to String
			String totalCost_Validation=String.valueOf(total_of_price_feesTax);
			  
			  Assert.assertEquals(totalCost, totalCost_Validation);
			  
			  
			  System.out.println("Total cost after addition : "+total_of_price_feesTax);
			  
			  

			  


  }
  @Test(priority=4,description="Test to fill form details ")
  public void blaze_form() throws Exception
  {
	  w.findElement(By.id("inputName")).clear();
	  w.findElement(By.id("inputName")).sendKeys("Jones Pence");
	  
	  w.findElement(By.xpath("//*[@id=\"address\"]")).clear();
	  w.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Observatory Circle, U.S");
	  
	  w.findElement(By.id("city")).clear();
	  w.findElement(By.id("city")).sendKeys("Phoenix");
	  
	  w.findElement(By.id("state")).clear();
	  w.findElement(By.id("state")).sendKeys("Arizona (AZ)");
	  
	  w.findElement(By.name("zipCode")).clear();
	  w.findElement(By.name("zipCode")).sendKeys("85001");
	  
	  WebElement cardType=w.findElement(By.id("cardType"));
	  Select s=new Select(cardType);
	  
	 s.selectByIndex(1);
	 
	 w.findElement(By.name("creditCardNumber")).clear();
	 w.findElement(By.name("creditCardNumber")).sendKeys("12345678");
	 
	 w.findElement(By.id("creditCardMonth")).clear();
	 w.findElement(By.id("creditCardMonth")).sendKeys("12");
	 
	 w.findElement(By.name("creditCardYear")).clear();
	 w.findElement(By.name("creditCardYear")).sendKeys("2018");
	 
	 w.findElement(By.xpath("//*[@id=\"nameOnCard\"]")).clear();
	 w.findElement(By.xpath("//*[@id=\"nameOnCard\"]")).sendKeys("Jones Pence");
	 
	 Thread.sleep(2000);
	 
	 w.findElement(By.id("rememberMe")).click();
	 w.findElement(By.xpath("/html/body/div[2]/form/div[11]/div/input")).click();
	 
  
  
  
  
  
  
  }

			  @AfterTest
			  public void postConditions()
			  {
				w.quit();
			  }

}
