package com.app.flipkart.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.app.flipkart.base.BaseClass;

public class HomePageLocators extends BaseClass {

	public HomePageLocators() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Electronics']")
	private WebElement electronics;

	public WebElement getElectronics() {
		return electronics;
	}
	@FindBy(xpath="//*[text()='Laptop and Desktop']")
	private WebElement laptopsAndDesktops;

	public WebElement getLaptopsAndDesktops() {
		return laptopsAndDesktops;
	}
	@FindBy(xpath="//*[text()='Gaming Laptops']")
	private WebElement gamingLaptops;
	
	public WebElement getGamingLaptops(){
		return gamingLaptops;
		
	}
	@FindBy(xpath="//div[@class='_30jeq3']")
	private List<WebElement> products;
	
	public List<WebElement> getProducts(){
		return products;
	}
	
	

}
