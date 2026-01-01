package com.ibm.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"./MyAppFeatures/MyApp.feature"},
		glue= {"com.ibm.steps"},
		plugin= {"json:src/test/resources/cucumber-report.json"}
		
		)
public class TestRunner {

}
