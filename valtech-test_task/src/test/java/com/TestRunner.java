package com;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = {"com.steps"}, plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
