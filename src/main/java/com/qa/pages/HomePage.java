package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath ="//a[@title='Log in to your customer account']")
	WebElement SigninBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String HomePageTitle() {
		return driver.getTitle();
	}
	
	public String HomePageUrl() {
		return driver.getCurrentUrl();
	}
	
	public Boolean SigninBtnVisible() {
		return SigninBtn.isDisplayed();
	}
	
	public Boolean SigninBtnEnabled() {
		return SigninBtn.isEnabled();
	}
	
	public void SigninBtnClickable() {
		SigninBtn.click();
	}
	
	public String LoginPageTitle() {
		return driver.getTitle();
	}
	
	
}
