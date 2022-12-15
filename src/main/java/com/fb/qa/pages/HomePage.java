package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.BaseClass;

public class HomePage extends BaseClass{
	@FindBy(xpath = "//span[text()='Friends']")
	WebElement friendEle;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public void switchToFriedPage() {
		friendEle.click();
	}
}
