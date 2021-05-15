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

public class Insuranceweb {
	String projectPath;
	WebDriver w;
	
	@BeforeTest
	  public void preConditions()
	{
		projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();
	}
  @Test(priority=0,description="To verify Login Functionality")
  public void login_fin() throws Exception 
  {
	  w.get("http://demo.borland.com/InsuranceWebExtJS/");
	  w.findElement(By.id("login-form:email")).clear();
	  w.findElement(By.id("login-form:email")).sendKeys("seleniumtesting@gmail.com");
	  
	  w.findElement(By.id("login-form:password")).clear();
	  w.findElement(By.id("login-form:password")).sendKeys("test@123");
	  
	  Thread.sleep(1000);
	  
	  w.findElement(By.id("login-form:login")).click();
	  

	  Thread.sleep(3000);
	  
	  String login=w.findElement(By.cssSelector("label.login")).getText();
	  Assert.assertEquals(login, "Selenium Testing");
	  System.out.println("SuccessFull Login:"+login);
  }
  @Test(priority=1,description="To select Auto Quote and details")
  public void auto_quote() throws Exception
  {
	  
	  WebElement service=w.findElement(By.id("quick-link:jump-menu"));
	  Select s=new Select(service);
	  s.selectByIndex(1);
	  
	  String pageTitle=w.getTitle();
	  Assert.assertTrue(pageTitle.contains("Automobile Instant Quote"));
	  System.out.println("Page Title for Auto Quote Page -->"+pageTitle);
	  
	  WebElement PageLabel=w.findElement(By.xpath("//*[@id=\"content-main\"]/h1"));
	  String Label=PageLabel.getText();
	  Assert.assertEquals(Label, "Automobile Instant Quote");
	  System.out.println("Page Label for Page-->"+Label);
	  
	  w.findElement(By.id("autoquote:zipcode")).clear();
	  w.findElement(By.id("autoquote:zipcode")).sendKeys("400001");
	  
	  w.findElement(By.id("autoquote:e-mail")).clear();
	  w.findElement(By.id("autoquote:e-mail")).sendKeys("test@gmail.com");
	  
	  Thread.sleep(1000);
	  	  
	  w.findElement(By.id("autoquote:vehicle:0")).click();
	  w.findElement(By.xpath("//*[@id=\"autoquote:next\"]")).click();
	  
	  Thread.sleep(2000);
	  
	  w.findElement(By.id("autoquote:age")).clear();
	  w.findElement(By.id("autoquote:age")).sendKeys("40");
	  
	  w.findElement(By.cssSelector("input[value='Male']")).click();
	  w.findElement(By.id("autoquote:type:0")).click();
	  
	  w.findElement(By.xpath("//*[@id=\"autoquote:next\"]")).click();
	  
	  w.findElement(By.id("autoquote:year")).clear();
	  w.findElement(By.id("autoquote:year")).sendKeys("2014");
	  
	
	  Thread.sleep(1000);  
	 w.findElement(By.xpath("//*[@id=\"ext-gen4\"]")).click();
	
	 Thread.sleep(2000);
	 
	 w.findElement(By.xpath("//*[@id=\"ext-gen8\"]/div[4]")).click();
	 Thread.sleep(1000);
	 
	 w.findElement(By.xpath("//*[@id=\"ext-gen6\"]")).click();
	 Thread.sleep(1000);
	 w.findElement(By.xpath("//*[@id=\"ext-gen12\"]/div[2]")).click();
	 
	 w.findElement(By.id("autoquote:finInfo:0")).click();
	 Thread.sleep(2000);
	 w.findElement(By.name("autoquote:next")).click();
	 
	 String recordresult=w.findElement(By.id("quote-result:drecord")).getText();
	 Assert.assertEquals(recordresult, "Excellent");
	 System.out.println("Driving Record Result as:"+recordresult);
	 
	 Thread.sleep(1000);
	 String genderResult=w.findElement(By.id("quote-result:gender")).getText();
	 Assert.assertEquals(genderResult, "Male");
	 System.out.println("Gender Result as :"+genderResult);
	 
	 String typeResult=w.findElement(By.id("quote-result:type")).getText();
	 Assert.assertEquals(typeResult, "car");
	 System.out.println("Automobile Type Result as:"+typeResult);
	 
	 String yearResult=w.findElement(By.id("quote-result:year")).getText();
	 Assert.assertEquals(yearResult, "2014");
	 System.out.println("Year Result Type as:"+yearResult);
	 
	 String makeResult=w.findElement(By.id("quote-result:make")).getText();
	 Assert.assertEquals(makeResult, "Toyota");
	 System.out.println("Make Result as :"+makeResult);
	  
	 String modelResult=w.findElement(By.id("quote-result:model")).getText();
	 Assert.assertEquals(modelResult, "Avalon");
	 System.out.println("Model Result as :"+modelResult);
	 
	 
	 String statusResult=w.findElement(By.id("quoteResult")).getText();
	 Assert.assertEquals(statusResult, "Own");
	 System.out.println("current vehicle status as"+statusResult);
	 
	 String quoteResult=w.findElement(By.xpath("//*[@id=\"quote-result\"]/h1[2]")).getText();
			 Assert.assertEquals(quoteResult, "Your Instant Quote is USD 1.200,00 every twelve months.");
	 System.out.println("Quotation text as :"+quoteResult);

	 
	 
  }
  
  

  @AfterTest
  public void afterTest()
  {
	  w.quit();
  }

}
