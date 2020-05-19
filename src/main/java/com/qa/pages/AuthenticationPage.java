package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AuthenticationPage extends TestBase {

	@FindBy (id="email")
	WebElement LoginId;
	
	@FindBy(id="passwd")
	WebElement LoginPwd;
	
	@FindBy(id="SubmitLogin")
	WebElement SigninBtn;
	
	@FindBy(xpath="//li[text()='Authentication failed.']")
	WebElement AuthenticationFailedAlert;
	
	@FindBy(xpath="//li[text()='Invalid email address.']")
	WebElement InvalidEmailAddAlert;
	
	@FindBy(xpath="//li[text()='An email address required.']")
	WebElement EmallAddRequiredAlert;
	
	@FindBy(xpath="//li[text()='Password is required.']")
	WebElement PasswordRequiredAlert;
	
	public AuthenticationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String authenticationPageTitle() {
		return driver.getTitle();
	}
	
	public String authenticationPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void typeLoginId(String loginID) {
		LoginId.sendKeys(loginID);
	}
	
	public void typeLoginPwd(String loginpwd) {
		LoginPwd.sendKeys(loginpwd);
	}
	
	public void clickSigninBtn() {
		SigninBtn.click();
	}
	
	public String authenticationFailedAlert() {
		return AuthenticationFailedAlert.getText();
	}
	
	public String InvalidEmailAddressAlert() {
		return InvalidEmailAddAlert.getText();
	}
	
	public String EmailAddressRequiredAlert() {
		return EmallAddRequiredAlert.getText();
	}
	
	public String passwordRequiredAlert() {
		return PasswordRequiredAlert.getText();
	}
}
 