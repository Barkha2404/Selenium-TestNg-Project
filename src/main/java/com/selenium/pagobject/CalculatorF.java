package com.selenium.pagobject;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatorF
{

	public String url="https://juliemr.github.io/protractor-demo/";
	
	public static WebDriver w;
	public static String projectPath = System.getProperty("user.dir");

	
	@FindBy(xpath="/html/body/div/div/form/input[1]")
	public WebElement firsttxt;
	
	@FindBy(xpath="/html/body/div/div/form/select")
	public WebElement dropdownoperator;
	
	@FindBy(xpath="/html/body/div/div/form/input[2]")
	public WebElement secondtxt;
	
	@FindBy(id="gobutton")
	public WebElement gobtn;
	
	@FindBy(xpath="/html/body/div/div/form/h2")
	public WebElement result;
	
	public void openBrowser(String browserName) 
	{
		
				if(browserName.equalsIgnoreCase("chrome"))
		{
					System.setProperty("webdriver.chrome.driver", projectPath +"\\BrowserDriver\\chromedriver.exe");
					w=new ChromeDriver();
					w.manage().window().maximize();
					w.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
			if (browserName.equalsIgnoreCase("firefox")) 
		{
				WebDriverManager.firefoxdriver().setup();
				w = new FirefoxDriver();
				w.manage().window().maximize();
				w.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		}
	}
	public void openApplication()
	{
		w.get(url);
	}
	
	public void closeBrowser()
	{
		w.quit();
	}
	
	public void handleTextbox(WebElement we1,String value )
	{
		we1.sendKeys(value);
	}
	
	public void handleClickEvent(WebElement we1)
	{
		we1.click();
	}
	public String getTxtWebElement(WebElement we1)
	{
		return we1.getText();
	}
	
	public String getCurrentPageTitle() 
	{
		return w.getTitle();
	}
	
	public void handleDropDown(WebElement we1, String value) 
	{
		Select s=new Select(we1);
		s.selectByValue(value);
	}
	
	public void handleAlert()
	{
		try
		{
			w.switchTo().alert().accept();
		
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void handleFrame(WebElement we1)
	{
		w.switchTo().frame(we1);
	}
	
	public void waitSec(int sec) throws Exception
	{
		sec=sec*1000;
		Thread.sleep(sec);
	}
	public void takeScreenShot(String fileName) throws Exception
	{

		TakesScreenshot ts = (TakesScreenshot) w;
		File f = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\" + fileName));

	}
	public static String takeScreenShotListenerClass(ITestResult result, String status) throws Exception
	{
		String ScreenshotName = result.getMethod().getMethodName() + ".png";
		
		
		TakesScreenshot ts = (TakesScreenshot) w;
		File f = ts.getScreenshotAs(OutputType.FILE);
		
		if(status.equalsIgnoreCase("passed"))
		{
			FileUtils.copyFile(f,new File(projectPath + "\\Screenshot\\Pass\\" + ScreenshotName));
		}
		else if (status.equalsIgnoreCase("failed"))
		{
			FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\Fail\\" + ScreenshotName));
	
		}
		return ScreenshotName;
	}	

	public void exportPageObjectElement() {

		PageFactory.initElements(w, this);

	
	
	}

		
	
	
}
