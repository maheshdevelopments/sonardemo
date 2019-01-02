package com.kg.sonardemo.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "..\\sonardemo\\src\\test\\java\\com\\kg\\sonardemo\\feature", 
glue = "com.kg.sonardemo.definition", dryRun = false, strict = true,
plugin = { "pretty", "html:target/html", "json:target/cucumber.json" })
public class RunCukesTest {

}