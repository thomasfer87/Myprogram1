package com.app.flipkart.pageexecutor;

import com.app.flipkart.base.BaseClass;
import com.app.flipkart.locators.HomePageLocators;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomePageExecutor extends HomePageLocators {

	public static void electronicsClick() {

		Actions ac = new Actions(driver);
		ac.moveToElement(new HomePageLocators().getElectronics());
		ac.perform();
		timwWait(1000);
		ac.moveToElement(new HomePageLocators().getLaptopsAndDesktops());
		ac.perform();
		timwWait(1000);
		ac.moveToElement(new HomePageLocators().getGamingLaptops()).click();
		ac.perform();

	}

	public static void products() {
		List<WebElement> li = BaseClass.listofProducts(new HomePageLocators().getProducts());
	}
}
