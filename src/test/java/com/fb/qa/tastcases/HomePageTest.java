package com.fb.qa.tastcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.BaseClass;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;

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
	public void friendPageTest() {
		try {
			loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homePage.switchToFriedPage();
	}
}
