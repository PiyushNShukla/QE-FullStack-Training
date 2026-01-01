package com.ibm.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features="src/test/resources/features",
		glue= {
				"com.ibm.stepdefinitions",
				"com.ibm.hooks"
		},
		plugin= {
				"pretty",
				"html:target/cucumber-report.html"
		}
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
