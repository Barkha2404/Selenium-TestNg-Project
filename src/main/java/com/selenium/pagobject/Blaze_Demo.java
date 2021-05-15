package com.selenium.pagobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Blaze_Demo
{
		public String url="http://blazedemo.com/";
		
		public static WebDriver w;
		public String projectPath=System.getProperty("user.dir");

		@FindBy(name="fromPort")
		public WebElement dropDownfrom;
		
		@FindBy(name="toPort")
		public WebElement dropdownto;
		
		@FindBy(xpath="/html/body/div[3]/form/div/input")
		public WebElement findFlightbtn;
		
		@FindBy(xpath="/html/body/div[2]/table/tbody/tr[1]/td[1]/input")
		public WebElement chooseflightbtn;
		
		
}
