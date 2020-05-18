package com.qa.test;

import org.testng.Assert;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageTest extends TestBase {

	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	
	@Before
	public void setUp() {
		initialization();
		homepage = new HomePage();
	}
	
	 @Given ("^user enters url$")
	 public void user_enters_url() {
		homepage.HomePageTitle();
	 }
	 
	 @When ("^user clicks login button$")
	 public void user_clicks_login_button() {
		 homepage.SigninBtnClickable();
	 }
	 
	 @Then ("^user should land in login page$")
	 public void user_should_land_in_login_page(){
		 Assert.assertEquals(homepage.LoginPageTitle(),"Login - My Store");
	 }
	 
	 @After
	 public void tearDown() {
		 driver.quit();
	 }
}
