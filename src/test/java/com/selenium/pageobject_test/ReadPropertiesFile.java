package com.selenium.pageobject_test;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile
{
	public static void main(String[] args) throws Exception
	{
		String filePath=System.getProperty("user.dir")+"\\Config\\config.properties";
		FileInputStream fi=new FileInputStream(filePath);
		Properties prop= new Properties();
		prop.load(fi);
		
		
		String os_value=prop.getProperty("os");
		String browser_value=prop.getProperty("browser");
		String url_blaze_value=prop.getProperty("url_blaze");
		
		System.out.println(os_value);
		System.out.println(browser_value);
		System.out.println(url_blaze_value);
		
		fi.close();
	}
	
	
	
}
