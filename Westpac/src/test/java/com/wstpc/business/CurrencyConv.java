package com.wstpc.business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.wstpc.page.CurrencyConvPage;

public class CurrencyConv extends CurrencyConvPage{
	
	public WebElement ele=null;
	
	public CurrencyConv(WebDriver driver) {
		super(driver);
	}
	
	public void SwitchFrame() {	
		ele=getHomeFrame();
		driver.switchTo().frame(ele);
	}
	
	public void CurrencyAmount(String amount) {
		ele=getAmountField();
		ele.clear();
		ele.sendKeys(amount);
	}
	
	public void selectSourceCurrency(String SourceCurrency) {
		ele=getSourceCurrency();
		Select dropdown= new Select(ele);
		dropdown.selectByVisibleText(SourceCurrency);
	}
	
	public void selectTargetCurrency(String TargetCurrency) {
		ele=getTargetCurrency();
		Select dropdown= new Select(ele);
		dropdown.selectByVisibleText(TargetCurrency);
	}
	
	public void ClickConvert() {
		ele=getConvertBtn();
		ele.click();
	}
	
	public String ErrorMsg() {
		String errormsg=null;
		errormsg=getErrMsg().getText();
		return errormsg;		
	}
	
	public String ResultMsg() {
		String errormsg=null;
		errormsg=getResultMsg().getText();
		return errormsg;		
	}
}
