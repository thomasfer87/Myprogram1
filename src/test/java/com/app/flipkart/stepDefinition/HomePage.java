package com.app.flipkart.stepDefinition;

import com.app.flipkart.pageexecutor.HomePageExecutor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.app.flipkart.base.BaseClass;
import com.app.flipkart.locators.HomePageLocators;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage extends HomePageExecutor {

	// @Given("Enter the URL")
	public void enter_the_url() {
		launchBrowserMethod();
		urlPass("https://www.flipkart.com/");
	}

	// @When("click electronics")
	public void click_electronics() {
		electronicsClick();
	}

	// @Then("Validate the Home page title")
	public void validate_the_home_page_title() {

		try {
			Robot rt = new Robot();
			rt.keyPress(KeyEvent.VK_ESCAPE);
			rt.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		HomePage page = new HomePage();
		page.enter_the_url();
		timwWait(200);
		page.validate_the_home_page_title();
		timwWait(200);
		page.click_electronics();
		timwWait(500);
		products();
	}
}
