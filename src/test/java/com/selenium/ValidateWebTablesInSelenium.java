package com.selenium;

import org.testng.annotations.Test;

import com.POM.WebTablePOM;
import com.Utility.Constants;
import com.Utility.Library;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateWebTablesInSelenium extends Library 
{
	@Test(priority = 1)
	public void validateWebTableUrl() 
	{
		System.out.println("inside validateWebTableUrl");
		ExtTest = ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.get(objProp.getProperty("WebTableUrl"));
		PageLoadTimeOut(Constants.PageLoadTimeOut);
		String title = driver.getTitle();
		Assert.assertEquals(title, objProp.getProperty("WebTableTitle"));
	}

	@Test(priority = 2)
	public void validateWebTableContentBasedOnLastName() 
	{
		System.out.println("inside validateWebTableContentBasedOnLastName");
		ExtTest = ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		WebTablePOM objtable = new WebTablePOM();
		scrollToElement(objtable.webTable);
		List<WebElement> lastNames = objtable.allLastNames;
		System.out.println("Number of last names:" + lastNames.size());
		HashMap<String, String> PersonDetails = new HashMap<String, String>();
		int numberOfPages = objtable.allNavigationBtns.size() - 4;
		for (int page = 1; page <= numberOfPages; page++) 
		{
			System.out.println("we are at Page number: " + page);
			for (int row = 0; row <= lastNames.size()-1; row++) 
			{
				String LastName = lastNames.get(row).getText();
				System.out.println("Last name at " + row + " is: " + LastName);
				if (LastName.equalsIgnoreCase(objProp.getProperty("PersonLastName"))) 
				{
					row = row + 1;
					String firstName = driver
							.findElement(By.xpath("//table[@id='example']/tbody/tr[" + row + "]/td[2]")).getText();
					String position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + row + "]/td[4]"))
							.getText();
					String office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + row + "]/td[5]"))
							.getText();
					String startDate = driver
							.findElement(By.xpath("//table[@id='example']/tbody/tr[" + row + "]/td[6]")).getText();
					String salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + row + "]/td[7]"))
							.getText();
					PersonDetails.put("FirstName", firstName);
					PersonDetails.put("LastName", LastName);
					PersonDetails.put("Position", position);
					PersonDetails.put("Office", office);
					PersonDetails.put("Start Date", startDate);
					PersonDetails.put("Salary", salary);
					break;
				}
			}
			if (PersonDetails.isEmpty()) 
			{
				objtable.nextPageBtn.click();
			} else if (!PersonDetails.isEmpty()) 
			{
				break;
			}
		}
		for (Map.Entry<String, String> map : PersonDetails.entrySet()) 
		{
			System.out.println(map.getKey() + ":" + map.getValue());
		
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
