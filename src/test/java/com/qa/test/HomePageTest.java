package com.qa.test;

import org.testng.Assert;

import com.qa.base.TestBase;
import com.qa.pages.AuthenticationPage;
import com.qa.pages.HomePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageTest extends TestBase {

	HomePage homepage;
	AuthenticationPage authenticationpage;
	
	public HomePageTest() {
		super();
	}
	
	@Before
	public void setUp() {
		initialization();
		homepage = new HomePage();
		authenticationpage = new AuthenticationPage();
	}
	
	// Sign in button clickable
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
	 
	 // Sign in button visible
	 @Then ("^user should be able to see login button$")
	 public void user_should_be_able_to_see_login_button() {
		 Assert.assertTrue(homepage.SigninBtnVisible(),"SignIn button is visible");
	 }
	 
	 // Positive login test
	  @And ("^user clicks login button1$")
	  public void user_clicks_login_button1() {
		  homepage.SigninBtnClickable();
	  }
	  
	  @When ("^user enter valid email address and valid password$")
	  public void user_enter_valid_email_address_and_valid_password() {
		  authenticationpage.typeLoginId(prop.getProperty("Username"));
		  authenticationpage.typeLoginPwd(prop.getProperty("Password"));
	  }
	 
	  @And ("^user clicks Signin button$")
	  public void user_clicks_Signin_button() {
		  authenticationpage.clickSigninBtn();
	  }
	  
	  @Then ("^user should land in account page$")
	  public void user_should_land_in_account_page() {
		 Assert.assertEquals(driver.getTitle(), "My account - My Store");
	  }
	  
	  // Negative login test with valid username & invalid password
	  @When ("^user enter valid email address and invalid password$")
	  public void user_enter_valid_email_address_and_invalid_password() {
		  authenticationpage.typeLoginId(prop.getProperty("Username"));
		  authenticationpage.typeLoginPwd(prop.getProperty("InvalidPassword"));
	  }
	  
	  @Then ("^user should not be allowed to login with invalid password$")
	  public void user_should_not_be_allowed_to_login_with_invalid_password() {
		  Assert.assertEquals(authenticationpage.authenticationFailedAlert(), "Authentication failed.");
	  }
	  
	  // Negative login test with invalid username & invalid password
	  @When ("^user enter invalid email address and invalid password$")
	  public void user_enter_invalid_email_address_and_invalid_password() {
		  authenticationpage.typeLoginId(prop.getProperty("InvalidUsername"));
		  authenticationpage.typeLoginPwd(prop.getProperty("InvalidPassword"));
	  }
	  
	  @Then ("^user should not be allowed to login with invalid email address and invalid password$")
	  public void user_should_not_be_allowed_to_login_with_invalid_email_address_and_invalid_password(){
		  Assert.assertEquals(authenticationpage.InvalidEmailAddressAlert(),"Invalid email address.");
	  }
	  
	  //Negative login test with no username & valid password
	  @When ("^user leaves email address blank and enters valid password$")
	  public void user_leaves_email_address_blank_and_enters_valid_password() {
		  authenticationpage.typeLoginPwd(prop.getProperty("Password"));
	  }
	  
	  @Then ("^user should not be allowed to login with no email address and valid password$")
	  public void user_should_not_be_allowed_to_login_with_no_email_address_and_valid_password() {
		  Assert.assertEquals(authenticationpage.EmailAddressRequiredAlert(), "An email address required.");
	  }
	  
	  // Negative login test with valid username & no password
	  @When ("^user enters valid email address and leaves password blank$")
	  public void user_enters_valid_email_address_and_leaves_password_blank() {
		  authenticationpage.typeLoginId(prop.getProperty("Username"));
	  }
	  
	  @Then ("^user should not be allowed to login with valid email address and no password$")
	  public void user_should_not_be_allowed_to_login_with_valid_email_address_and_no_password() {
		  Assert.assertEquals(authenticationpage.passwordRequiredAlert(),"Password is required.");
	  }
	  
	  // Negative login test with no username & no password
	  @When ("^user leaves email address and password section blank$")
	  public void user_leaves_email_address_and_password_section_blank() {
		  //not typing anything in the username and password field
	  }
	  
	  @Then ("^user should not be allowed to login with no email address and no password$")
	  public void user_should_not_be_allowed_to_login_with_no_email_address_and_no_password() {
		  Assert.assertEquals(authenticationpage.EmailAddressRequiredAlert(),"An email address required.");
	  }
	  
	  //Negative login test with invalid email address & valid password
	  @When ("^user enters invalid email address but valid password$")
	  public void user_enters_invalid_email_address_but_valid_password() {
		  authenticationpage.typeLoginId(prop.getProperty("InvalidUsername"));
		  authenticationpage.typeLoginPwd(prop.getProperty("Password"));
	  }
	  
	  @Then ("^user should not be allowed to login with invalid email address and valid password$")
	  public void user_should_not_be_allowed_login_with_invalid_email_address_and_valid_password() {
		  Assert.assertEquals(authenticationpage.InvalidEmailAddressAlert(),"Invalid email address.");
	  }
	  
	 @After
	 public void tearDown() {
		 driver.quit();
	 }
}
