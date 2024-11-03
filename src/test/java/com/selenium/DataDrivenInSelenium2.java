package com.selenium;
import org.testng.annotations.Test;

import com.POM.DataDrivenPOM2;
import com.Utility.Constants;
import com.Utility.Library;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DataDrivenInSelenium2 extends Library 
{
	public HashMap<String, String> ExcelDataHashMap = new HashMap<String, String>();
	@Test(priority = 1)
	public void validateAppointmentRegistrationUrl() 
	{
		System.out.println("inside validateAppointmentRegistrationUrl");
		ExtTest = ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		driver.get(objProp.getProperty("AppointmentRegistrationUrl"));
		PageLoadTimeOut(Constants.PageLoadTimeOut);
		String title = driver.getTitle();
		if(title.contains(objProp.getProperty("AppointmentTitle")))
		{
			System.out.println("User landed on the exact page");
		}	
		//Assert.assertEquals(title, objProp.getProperty("TitleOfDemoQA"));
	}
	
	@Test(priority=2)
	public void validateRegistrationPage()
	{
		System.out.println("inside validateRegistrationPage");
		ExtTest = ExtReports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
		try 
		{
			File objFile = new File(System.getProperty("user.dir")+"//src//test//resources//TestData//DemoQADetails.xlsx");
			FileInputStream objInputstream = new FileInputStream(objFile);
			XSSFWorkbook objXSSFWorkbook = new XSSFWorkbook(objInputstream);
			XSSFSheet objXSSFSheet = objXSSFWorkbook.getSheet("Sheet2");
			int row_count = objXSSFSheet.getLastRowNum();
			System.out.println("Number of rows:"+row_count);
			DataDrivenPOM2 objDataDriven = new DataDrivenPOM2();
			
			for(int i=1;i<=row_count;i++)
			{
				//System.out.println("Data from row:"+i);
				ExcelDataHashMap = ReadExcelData(i, objXSSFSheet);
				//System.out.println("First name is:"+ExcelDataHashMap.get("First Name"));
				
				objDataDriven.firstName.clear();
				objDataDriven.firstName.sendKeys(ExcelDataHashMap.get("First Name"));
				
				objDataDriven.lastName.clear();
				objDataDriven.lastName.sendKeys(ExcelDataHashMap.get("Last Name"));
				
				objDataDriven.userEmail.clear();
				objDataDriven.userEmail.sendKeys(ExcelDataHashMap.get("Email"));
				
				objDataDriven.userPassword.clear();
				objDataDriven.userPassword.sendKeys(ExcelDataHashMap.get("Password"));
				
				//scrollToElement(objDataDriven.dateOfBirthText);
				objDataDriven.dob_textBox.click();
				objDataDriven.dob_month.click();
				selectRequiredValueFromDropDown(objDataDriven.listOfMonths, ExcelDataHashMap.get("Month"));
				objDataDriven.dob_year.clear();
				objDataDriven.dob_year.sendKeys(ExcelDataHashMap.get("Year"));
				
				List<WebElement> allDays = objDataDriven.seletDays;
				for(int j=0;j<=allDays.size()-1;j++)
				{
					String dayFromCalender = allDays.get(j).getText();
					if(dayFromCalender.equalsIgnoreCase(ExcelDataHashMap.get("Day")))
					{
						allDays.get(j).click();
						break;
					}
				}
//				//allDays.clear();
//				allDays.get(i).click();
				//objDataDriven.dateOfBirthText.click();
				
				scrollToElement(objDataDriven.dateOfBirthText);
				if(ExcelDataHashMap.get("Facility Taken").equalsIgnoreCase("yes"))
				{
					objDataDriven.radio_yes.click();
					objDataDriven.textArea.clear();
					objDataDriven.textArea.sendKeys(ExcelDataHashMap.get("Reason for Facility Taken"));
				}else
				{
					objDataDriven.radio_no.click();
				}
				
				//scrollToElement(objDataDriven.appointment_textBox);
				objDataDriven.appointment_textBox.click();
				objDataDriven.doa_month.click();
				selectRequiredValueFromDropDown(objDataDriven.alistOfMonths, ExcelDataHashMap.get("Month1"));
				objDataDriven.doa_year.clear();
				objDataDriven.doa_year.sendKeys(ExcelDataHashMap.get("Year1"));
				
				
				List<WebElement> allDay = objDataDriven.aseletDays;
				for(int x=0;x<=allDay.size()-1;x++)
				{
					String dayFromCalender2 = allDay.get(x).getText();
					if(dayFromCalender2.equalsIgnoreCase(ExcelDataHashMap.get("Day1")))
					{
						allDay.get(x).click();
						break;
					}
				}
				
				scrollToElement(objDataDriven.textArea);
				objDataDriven.timePicker.clear();
				objDataDriven.timePicker.click();
				selectRequiredValueFromDropDown(objDataDriven.timePickerOptions, ExcelDataHashMap.get("Time for Appointment"));
				
				FileOutputStream objFileOutput = new FileOutputStream(objFile);
				WriteForExcelFile(i,objXSSFSheet);
				objXSSFWorkbook.write(objFileOutput);
			}
			
			objXSSFWorkbook.close();
			objInputstream.close();
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