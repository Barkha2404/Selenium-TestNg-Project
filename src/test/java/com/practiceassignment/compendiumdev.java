package com.practiceassignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class compendiumdev {
	
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
	
	
	
  @Test(priority=0,description="test to verify Home Page ")
  public void softTest()throws Exception
  {
	  w.get("https://compendiumdev.co.uk/");
	  Thread.sleep(1000);
	  WebElement PageLabel= w.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/div/h1"));
	  String Label1=PageLabel.getText();
	  Assert.assertEquals(Label1,"Do you want to test and develop software better?");
	  String pageTitle=w.getTitle();
	  Assert.assertTrue(pageTitle.contains("Software Testing"));
	  
  }
  @Test(priority=1,description="test to verify Hire me Page ",dependsOnMethods="softTest")
  public void hireMe()throws Exception
  {
	  w.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[1]/a")).click();
	  WebElement labelConsult=w.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/h1"));
	  String Label1consult=labelConsult.getText();
	  Assert.assertTrue(Label1consult.contains("Consultancy"));
	  String TitleC=w.getTitle();
	  Assert.assertEquals(TitleC, "Consultancy");
	  Thread.sleep(2000);

	  
  }
  
  @Test(priority=2,description="test to verify e training Page",dependsOnMethods="softTest")
  public void e_training() throws Exception
  {
	 
	  
		  w.findElement(By.linkText("e-training")).click();		 
		 WebElement ELabel=w.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/h1"));
		 String ElearnLabel=ELabel.getText();
		 Assert.assertTrue(ElearnLabel.contains("Online Training" ));
		 String ETitle=w.getTitle();
		 Assert.assertEquals(ETitle, "Online Training");
		 Thread.sleep(2000);
		 
		 
  }
  
  @Test(priority=3,description="test to verify Books page",dependsOnMethods="softTest")
  public void books() throws Exception
  {
	 

	  	w.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[3]/a")).click();
	  	WebElement Blabel=w.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/h1"));
	  	String BooksLabel=Blabel.getText();
		Assert.assertTrue(BooksLabel.contains("Our Books"));
	  	String Btitle=w.getTitle();
	  	Assert.assertEquals(Btitle,"Our Books");
	  
	  	Thread.sleep(2000);
  }
  
		  @Test(priority=4,description="test to verify face to face page",dependsOnMethods="softTest")
		public void f2f() throws Exception
		{
			w.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[4]/a")).click();
			WebElement FLabel=w.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/h1"));
			String FaceLabel=FLabel.getText();
			Assert.assertTrue(FaceLabel.contains("Training"));
			String Ftitle=w.getTitle();
			Assert.assertEquals(Ftitle, "Training");
		}
  
  

  @AfterTest
  public void postConditions()
  {
 	w.quit();
  }

}
