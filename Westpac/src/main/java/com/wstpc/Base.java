package com.wstpc;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {

	public static WebDriver driver =null;
	
	
	public WebDriver getDriver(String URL) {		
		System.setProperty("webdriver.chrome.driver", System. getProperty("user.dir")+"\\DriverServer\\chromedriver.exe");
		driver = new ChromeDriver();
		//String URL="https://westpac.co.nz";
		
		
		driver.get(URL);
		return driver;		
	}
	
	public void getScreenshot(String Testcasename) throws IOException
	{
		try {
			Date today = new Date();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshot\\"+Testcasename+"_"+today.getHours()+"_"+today.getMinutes()+"_"+today.getSeconds()+".png"));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
}
