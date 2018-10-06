package com.wstpc.business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.wstpc.page.HomePage;

public class Home extends HomePage{
	public WebElement ele=null;
	public Home(WebDriver driver) {
		super(driver);
	}
	
	public void mouseHoverFxTravel() {
		ele=getFxTravelMig();
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}
	
	public void ClickCurrConv() {
		ele=getCurrencyConvertor();
		ele.click();
	}



	


}
