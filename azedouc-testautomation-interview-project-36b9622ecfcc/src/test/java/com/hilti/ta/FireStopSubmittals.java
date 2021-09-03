package com.hilti.ta;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "target/test-classes/features/fireStopSubmittals.feature" },
glue = { "com.hilti.ta.steps"},
plugin = {"html:target/cukes", "json:target/cucumber-report.json", "junit:target/cucumber-report.xml", "pretty"},
strict = true,
monochrome = true)

public class FireStopSubmittals extends AbstractTestNGCucumberTests{

}
