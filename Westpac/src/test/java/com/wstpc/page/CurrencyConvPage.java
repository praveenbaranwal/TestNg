package com.wstpc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.wstpc.Base;

public class CurrencyConvPage extends Base{
	
	public WebDriver driver;
	public CurrencyConvPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public By homePageFrame = By.id("westpac-iframe");
	public WebElement getHomeFrame() {
		return driver.findElement(homePageFrame);
	}
	
	public By convertFrom = By.id("ConvertFrom");
	public WebElement getSourceCurrency() {
		return driver.findElement(convertFrom);
	}
	
	public By convertTo = By.id("ConvertTo");
	public WebElement getTargetCurrency() {
		return driver.findElement(convertTo);
	}
	
	public By amount = By.id("Amount");
	public WebElement getAmountField() {
		return driver.findElement(amount);
	}
	
	public By convert = By.id("convert");
	public WebElement getConvertBtn() {
		return driver.findElement(convert);
	}
	
	public By errMsg = By.xpath("//div[@id='errordiv']");
	public WebElement getErrMsg() {
		return driver.findElement(errMsg);
	}
	
	public By resultMsg = By.id("resultsdiv");
	public WebElement getResultMsg() {
		return driver.findElement(resultMsg);
	}	
}
