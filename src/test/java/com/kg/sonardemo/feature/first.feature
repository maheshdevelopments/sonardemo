Feature: Calculator 
	In order to avoid silly mistakes
    As a math idiot
    I want to be told the sum of two numbers

Scenario: Add two numbers 
	Given I have entered 50
	And I have also entered 70
	When I press add
	Then the result should be 120 on the screen