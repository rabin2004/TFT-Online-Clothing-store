#Author: rabin@transfotechacademy.io
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Log in Button must be visible & functional in Homepage 

  @tag1
  Scenario: Login Button in Homepage should be clickable
    Given user enters url
    When user clicks login button
    Then user should land in login page

  Scenario: Login Button in Homepage should be visible
    Given user enters url
    Then user should be able to see login button
    
 	Scenario: Positive login test
    Given user enters url
    And user click login button
    When user enter valid email address and valid password
    And click login button
    Then user should land in account page
    
 	Scenario: Negative login test (valid email address & invalid password)
    Given user enters url
    And user click login button
    When user enter valid email address and invalid password
    And user clicks login button
    Then user should not be allowed to login with invalid password
    
	Scenario: Negative login test (invalid email address & invalid password)
    Given user enters url
    And user click login button
    When user enter invalid email address and invalid password
    And user clicks login button
    Then user should not be allowed to login with invalid email address and invalid password   

