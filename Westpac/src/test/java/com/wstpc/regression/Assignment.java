package com.wstpc.regression;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wstpc.Base;
import com.wstpc.business.CurrencyConv;
import com.wstpc.business.Home;

public class Assignment {
	
	public static WebDriver driver;
	Base b=new Base();
	private static ExtentReports extent=  new ExtentReports("./Report/ExtentReport/extent.html", true);;
	ExtentTest test;
	
	@Parameters({ "URL" })
	
	@Test (priority = 0)
	public void CurrencyConvertorErrValidation(String URL) throws Throwable{
		test = extent.startTest("CurrencyConvertor Error Validation Test", "Test to validate currency convertor null value error Message");
		//Base b = new Base();
		driver=b.getDriver(URL);
		Home home=PageFactory.initElements(driver, Home.class);
		test.log(LogStatus.PASS, "URL Launched successfully");
		driver.manage().window().maximize();
		home.mouseHoverFxTravel();
		test.log(LogStatus.PASS, "Mouse Hover FXTravelMigrant complete");
		home.ClickCurrConv();
		test.log(LogStatus.PASS, "Clicking Currency Convertor successful");
		Thread.sleep(6000);
		CurrencyConv currencyConv=PageFactory.initElements(driver, CurrencyConv.class);
		currencyConv.SwitchFrame();
		test.log(LogStatus.PASS, "Page navigated successfully to Currency Convertor Page");		
		currencyConv.ClickConvert();
		test.log(LogStatus.PASS, "Clicking Convert button successful");
		String actualError=currencyConv.ErrorMsg();
		String expectedError="Please enter the amount you want to convert.";
		if(actualError.equalsIgnoreCase(expectedError))
		{
			driver.switchTo().defaultContent();
			test.log(LogStatus.PASS, "Error message populated as expected");
			b.getScreenshot("CurrencyConv_ErrorValidation");			
		}
		else
		{
			driver.switchTo().defaultContent();
			test.log(LogStatus.FAIL, "Error message not as expected!!");
			b.getScreenshot("CurrencyConv_ErrorValidation");
		}
		driver.switchTo().defaultContent();	
	}
	
	 @DataProvider
	 public Object[][] sendData(){
	        return new Object[][]{
	                {"New Zealand Dollar", "United States Dollar"},{"United States Dollar", "New Zealand Dollar"},{"Pound Sterling", "New Zealand Dollar"},{"Swiss Franc", "Euro"}
	        };
	 }
	
	@Test (priority = 1, dataProvider="sendData")		
	public void CurrencyConversion(String sourceCurrency, String targetCurrency) throws Throwable{				
		test = extent.startTest("CurrencyConvertion", "Test to validate if the currency conversion is working fine");
		CurrencyConv currencyConv=PageFactory.initElements(driver, CurrencyConv.class);
		currencyConv.SwitchFrame();
		test.log(LogStatus.PASS, "Page navigated successfully to Currency Convertor Page");				
		currencyConv.selectSourceCurrency(sourceCurrency);
		test.log(LogStatus.PASS, "Selecting the currency to convert from was successful");
		currencyConv.selectTargetCurrency(targetCurrency);
		test.log(LogStatus.PASS, "Selecting the currency to convert to was successful");
		currencyConv.CurrencyAmount("1000");
		test.log(LogStatus.PASS, "Entering amount to convert was successful");
		currencyConv.ClickConvert();
		test.log(LogStatus.PASS, "Clicking Convert button successful");
		Thread.sleep(3000);
		String ActualMsg= currencyConv.ResultMsg();
		Assert.assertTrue(ActualMsg.contains(targetCurrency));
		b.getScreenshot("CurrrencyConversion");
		driver.switchTo().defaultContent();
	}
			
	@AfterTest
	public void afterTest() {		
		extent.endTest(test);
		extent.flush(); 
		driver.quit();
	}	
}
