package com.fb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.BaseClass;

public class LoginPage extends BaseClass {
	WebElement email = driver.findElement(By.id("email"));
//	@FindBy(id = "email")
//	WebElement idEle;

	WebElement pass = driver.findElement(By.id("pass"));
//	@FindBy(id = "pass")
//	WebElement passEle;

	WebElement login = driver.findElement(By.name("login"));
//	@FindBy(name = "login")
//	WebElement loginEle;

	@FindBy(linkText = "Forgotten password?")
	WebElement frogetPass;
	
	@FindBy(linkText = "Create New Account")
	WebElement createNewAcc;

	@FindBy(linkText = "Create a Page")
	WebElement createAPage;
	
	// Initiazing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

//	 Actions
	public HomePage login(String username, String password) throws InterruptedException {
//		idEle.sendKeys(username);
//		passEle.sendKeys(password);
//		loginEle.click();

		email.sendKeys(username);
		pass.sendKeys(password);
		login.click();
		Thread.sleep(5000);
		return new HomePage();
	}

	public void multipleUserLogin(String username, String password) {
		email.sendKeys(username);
		pass.sendKeys(password);
		login.click();
	}
	public void switchToCreateAcc() {
		Log.info("swithing to create fb account...");
		createNewAcc.click();
	}

	public void switchToForgetPassword() throws InterruptedException {
		Thread.sleep(3000);
		frogetPass.click();
	}
	
	public void switchToFbPage() {
		createAPage.click();
	}
	
}
