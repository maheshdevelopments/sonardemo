package com.kg.sonardemo.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class MyStepDefinitions {

    @Given("^I have entered 50$")
    public void i_have_entered_50() {
        // TeamControllerTest teamControllerTest=new TeamControllerTest();
        // teamControllerTest.allTest();
        System.out.println("Given");
    }

    @When("^I press add$")
    public void i_press_add() {
        System.out.println("When");
    }

    @Then("^the result should be 120 on the screen$")
    public void the_result_should_be_120_on_the_screen() {
        System.out.println("Then");
    }

    @And("^I have also entered 70$")
    public void i_have_also_entered_70() {
        System.out.println("And");
    }

}