package com.wstpc;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Base {
	
	public void getScreenshot(String Testcasename, WebDriver driver) throws IOException
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
