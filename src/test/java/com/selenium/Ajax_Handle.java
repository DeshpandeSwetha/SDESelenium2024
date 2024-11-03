package com.selenium;

import org.testng.annotations.Test;

import com.Utility.Constants;
import com.Utility.Library;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Ajax_Handle extends Library 
{
	
	@DataProvider(name="search-data")
	public Object[][] dataProviderTest()
	{
		return new Object[][] {{"selenium webdriver tutorial"},{"auto s"}};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(priority = 1)
	public void Search_Test() 
	{
		System.out.println("inside validateAutomationDemoQaSiteTableUrl");
		ExtTest = ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.get(objProp.getProperty("AutomationDemoQaSite"));
		PageLoadTimeOut(Constants.PageLoadTimeOut);
		String title = driver.getTitle();
		Assert.assertEquals(title, objProp.getProperty("TitleOfDemoQA"));
	}
	
	

	@BeforeMethod
	public void beforeMethod() {

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
        UpdatingResultInExtentReport(result);
	}

	@BeforeClass
	public void beforeClass() {
        StartExtentReport();
	}

	@AfterClass
	public void afterClass() {
        FlushReport();
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside before Test");
		LaunchBrowser();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		try {
			ReadPropertiesFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {

	}

}
