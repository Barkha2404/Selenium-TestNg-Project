package com.selenium.pageobject_test;

import org.testng.annotations.Test;

import com.selenium.pagobject.CalculatorF;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;

@Listeners(com.selenium.pagobject.ListenersCode.class)
public class Calculator_test
{
	CalculatorF c;
	
	@BeforeTest
	  public void beforeTest() 
	{
		c=new CalculatorF();
		c.openBrowser("chrome");
		c.exportPageObjectElement();
	}
	
  @Test(priority = 0,description = "Test Case to verify addition operator ")
  public void addition() throws Exception
  {
	  c.openApplication();
	  c.handleTextbox(c.firsttxt,"5");
	  c.handleDropDown(c.dropdownoperator, "ADDITION"); 
	  c.handleTextbox(c.secondtxt,"5");
	  c.handleClickEvent(c.gobtn);
	  
	  c.waitSec(2);
	  
	  System.out.println("Addition :"+c.getTxtWebElement(c.result));
	  System.out.println("Page Title:"+c.getCurrentPageTitle());
	  
	  c.takeScreenShot("additionresult.png");
	  
  }
  @Test(priority = 1,description = "Test Case to verify Substract operator ")
  public void substract()throws Exception
  {
	  c.openApplication();
	  c.handleTextbox(c.firsttxt, "5");
	  c.handleDropDown(c.dropdownoperator, "SUBTRACTION");
	  c.handleTextbox(c.secondtxt, "3");
	  c.handleClickEvent(c.gobtn);
	  c.waitSec(2);
	  
	  System.out.println("Substraction:"+c.getTxtWebElement(c.result));
	  c.takeScreenShot("Substraction.png");
  }

  @AfterTest
  public void afterTest() 
  {
	  c.closeBrowser();
  }

}
