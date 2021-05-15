package com.seleniumtest.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CalculatorTest {

	String projectPath;
	WebDriver w;
	SoftAssert st;
	
	@BeforeTest
	  public void preConditions()
	{
		projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\BrowserDriver\\chromedriver.exe");
		w= new ChromeDriver();
		w.manage().window().maximize();
	}
	
  @Test(priority=0,description="Test to verify Calculator functioanlity")
  public void CalculatorApp()throws Exception
    {
	  st=new SoftAssert();
	  w.get("https://www.tcsion.com/OnlineAssessment/ScientificCalculator/Calculator.html");
	  
	  String pageTitle=w.getTitle();
	  System.out.println("Page Title is: "+pageTitle);
	  
	  String pageURL=w.getCurrentUrl();
	  System.out.println("Page URL is: "+pageURL);
	  
	  String pageLabel=w.findElement(By.xpath("//*[@id=\"helptopDiv\"]/span")).getText();
	  System.out.println("Page Label is: "+pageLabel);
	  
	  String modButton=w.findElement(By.id("keyPad_btnMod")).getText();
	  System.out.println("Text Inside Button: "+modButton);
  
	  st.assertEquals(pageTitle, "SCIENTIFIC CALCULATOR");
	  st.assertTrue(pageURL.contains("Calculator.html"),"URL is wrong!!");
	  st.assertEquals(pageLabel, "Scientific Calculator");
	  
	  
	  Thread.sleep(2000);
	  
	  st.assertAll();
	  
    }
  @Test(priority = 1, description = "Test to verify Calculator Operation ")
  public void calculatorOperation() throws Exception
  {
	  w.findElement(By.id("keyPad_btn3")).click();
	  w.findElement(By.id("keyPad_btnPlus")).click();
	  w.findElement(By.id("keyPad_btn2")).click();
	  w.findElement(By.id("keyPad_btnEnter")).click();
		Thread.sleep(1000);
		
		WebElement operationPerformed=w.findElement(By.id("keyPad_UserInput1"));
		String operation=operationPerformed.getAttribute("value");
		
		WebElement outputValue=w.findElement(By.id("keyPad_UserInput"));
		String output=outputValue.getAttribute("value");
		
		System.out.println("Operation : "+operation);
		System.out.println("Output : "+output);
		
		Assert.assertEquals(output,"5");
		
		
  }
  
  

			  @AfterTest
			  public void postConditions()
			  {
				  w.quit();
			  }

}
