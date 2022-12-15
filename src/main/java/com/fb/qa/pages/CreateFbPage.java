package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.BaseClass;

public class CreateFbPage extends BaseClass {

	@FindBy(xpath = "//a[@class='_42ft _4jy0 signup_btn _4jy4 _4jy2 selected _51sy'][text()='Sign Up']")
	WebElement navSignUpEle;
	
	@FindBy(xpath = "//a[@class='_42ft _4jy0 signup_btn _4jy4 _4jy2 selected _51sy'][text()='Sign Up']")
	WebElement popSignUpEle;

	@FindBy(xpath = "(//div[@class='_43rm'][text()='Get Started'])[1]")
	WebElement pageBusiORBrand;

	@FindBy(xpath = "(//div[@class='_43rm'][text()='Get Started'])[2]")
	WebElement pageCommORPFigure;

	// web element for login
	@FindBy(id = "email")
	WebElement idEle;

	@FindBy(id = "pass")
	WebElement passEle;

	@FindBy(xpath = "//button[@id='loginbutton']")
	WebElement loginButton;
	
	
	public CreateFbPage() {
		PageFactory.initElements(driver, this);
	}

	public void gotoSignUpFromNavELe() {
		navSignUpEle.click();
	}

	
	public void loginFromCreateFbPage(String username, String password) throws InterruptedException {
		idEle.sendKeys(username);
		Thread.sleep(3000);
		passEle.sendKeys(password);
		Thread.sleep(3000);
		loginButton.submit();
	}
	
	public void gotoSignUpFromPopELe() {
		navSignUpEle.click();
	}
	public void gotoCreateBusiORBrandFBPage() throws InterruptedException {
		Thread.sleep(3000);
		pageBusiORBrand.click();
	}

	public void gotoCreateCommuORPFigureFBPage() throws InterruptedException {
		Thread.sleep(3000);
		pageCommORPFigure.click();
	}

	
	
	

}
