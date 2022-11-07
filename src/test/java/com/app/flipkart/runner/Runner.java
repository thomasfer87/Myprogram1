package com.app.flipkart.runner;

import org.junit.runner.RunWith;

import com.app.flipkart.stepDefinition.HomePage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(features="C:\\Users\\User\\eclipse-workspace\\com.app.flipkart\\src\\test\\java\\com\\app\\"
			+ "flipkart\\feature", glue="stepDefinition",dryRun=false,monochrome=true,
			publish=true)
	public class Runner {
		
	}


