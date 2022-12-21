package com.fb.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static Logger Log = Logger.getLogger(BaseClass.class);
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream ip;

	public ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter spark = new ExtentSparkReporter("test-output/test-reports/ExtentReport.html");
	ExtentTest test;

	public BaseClass() {
		prop = new Properties();
		try {
			ip = new FileInputStream(
					"E:\\ADARSH Current data\\facebook\\src\\main\\java\\com\\fb\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initiazations() {
		Log.info("Starting the server...");
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("title of the web page: " + title);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public String takeScreenShot(WebDriver driver) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		File desFile = new File(".//fb_screenshot// "+System.currentTimeMillis()+".png");
		String abosolutePath  =  desFile.getAbsolutePath();
		try {
			FileHandler.copy(srcFile, desFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return abosolutePath;
	}
}
