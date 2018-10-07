package com.wstpc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wstpc.Base;

public class HomePage extends Base{
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public By fxTravelMig = By.id("ubermenu-section-link-fx-travel-and-migrant-ps");
	public WebElement getFxTravelMig() {
		return driver.findElement(fxTravelMig);
	}
	
	public By currencyConvertor = By.id("ubermenu-item-cta-currency-converter-ps");
	public WebElement getCurrencyConvertor() {
		return driver.findElement(currencyConvertor);
	}
	
}
