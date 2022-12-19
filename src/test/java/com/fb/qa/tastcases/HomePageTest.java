package com.fb.qa.tastcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.BaseClass;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(com.fb.qa.listener.ListnerTest.class)
public class HomePageTest extends BaseClass {
	LoginPage loginPage;
	public HomePage homePage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initiazations();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	@Test
	@Description("Fiends page...")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("friend page : 2")
	@Story("After login user able to see friends... ")
	public void friendPageTest() {
		try {
			loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homePage.switchToFriedPage();
	}
}
