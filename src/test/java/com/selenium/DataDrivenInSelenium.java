package com.selenium;

import org.testng.annotations.Test;

import com.Utility.Constants;
import com.Utility.Library;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DataDrivenInSelenium extends Library 
{
	public HashMap<String, String> TestDataHashMap = new HashMap<String, String>();
	@Test(priority = 1)
	public void validateAutomationDemoQaSiteTableUrl() 
	{
		System.out.println("inside validateAutomationDemoQaSiteTableUrl");
		ExtTest = ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.get(objProp.getProperty("AutomationDemoQaSite"));
		PageLoadTimeOut(Constants.PageLoadTimeOut);
		String title = driver.getTitle();
		Assert.assertEquals(title, objProp.getProperty("TitleOfDemoQA"));
	}
	
	@Test(priority=2)
	public void validateDataDrivenInExcel()
	{
		System.out.println("inside validateDataDrivenInExcel");
		ExtTest = ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		try 
		{
			File objFile = new File(System.getProperty("user.dir")+"//src//test//resources//TestData//DemoQA Details.xlsx");
			FileInputStream ObjInputstream = new FileInputStream(objFile);
			XSSFWorkbook objXSSFWorkbook = new XSSFWorkbook(ObjInputstream);
			XSSFSheet objXSSFSheet = objXSSFWorkbook.getSheet("Sheet1");
			int numberOfRows = objXSSFSheet.getLastRowNum();
			System.out.println("Number of rows:"+numberOfRows);
			for(int row=1;row<=numberOfRows;row++)
			{
				System.out.println("Data from row:"+row);
				TestDataHashMap = ReadExcelTestData(row,objXSSFSheet);
				System.out.println("First name is:"+TestDataHashMap.get("FirstName"));
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
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
		// driver.quit();
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
