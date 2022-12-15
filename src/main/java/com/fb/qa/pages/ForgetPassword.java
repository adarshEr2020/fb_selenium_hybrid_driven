package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.BaseClass;

public class ForgetPassword extends BaseClass {

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailEle;

	@FindBy(xpath = "//input[@name='pass']")
	WebElement passEle;

	@FindBy(linkText = "Log in")
	WebElement loginEle;

	@FindBy(xpath = "//a[text()='Forgotten account?']")
	WebElement forgetAcc;

	@FindBy(id = "identify_email")
	WebElement identifyEmail;

	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cencelEle;

	@FindBy(id = "did_submit")
	WebElement searchEle;

	public ForgetPassword() {
		PageFactory.initElements(driver, this);
	}

	public void loginFromForgtPage(String username, String password) throws InterruptedException {
		emailEle.sendKeys(username);
		Thread.sleep(3000);
		passEle.sendKeys(password);
		Thread.sleep(3000);
		loginEle.click();
	}

	public void switchToForgetAcc() throws InterruptedException {
		Thread.sleep(3000);
		forgetAcc.click();
	}

	public void forgetPassword(String username) throws InterruptedException {
		identifyEmail.sendKeys(username);
		Thread.sleep(3000);
		searchEle.submit();
//		searchEle.click();
//		cencelEle.click();
	}
}
