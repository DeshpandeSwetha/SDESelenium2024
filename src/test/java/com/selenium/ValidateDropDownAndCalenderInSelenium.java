package com.selenium;
import org.testng.annotations.Test;

import com.POM.DropDownPOM;
import com.Utility.Constants;
import com.Utility.Library;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateDropDownAndCalenderInSelenium extends Library
{
  @Test(priority=1)
  public void validateDemoQaWebsite() 
  {
	  System.out.println("inside validateDemoQaWebsite");
	  driver.get(objProp.getProperty("DemoQaWebsiteLink"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("TitleOfDemoQA"));
  }
  
  @Test(priority=2)
  public void validateDropDownOperation()
  {
	  System.out.println("inside validateDropDownOperation");
	  DropDownPOM objDropDown = new DropDownPOM();
	  scrollToElement(objDropDown.scrollTillGender);
	  objDropDown.dateOfBirth.click();
	  
	  Select select1 = new Select(objDropDown.monthSelect);
	  select1.selectByVisibleText(objProp.getProperty("SelectMonth"));
	  
	  Select select2 = new Select(objDropDown.yearSelect);
	  select2.selectByVisibleText(objProp.getProperty("SelectYear"));
	  
	  List<WebElement> calenderDays = objDropDown.selectDates;
	  for(int i=0;i<=calenderDays.size()-1;i++)
	  {
		  String dayFromCalender = calenderDays.get(i).getText();
		  if(dayFromCalender.equalsIgnoreCase(objProp.getProperty("SelectDate")))
		  {
			  calenderDays.get(i).click();
			  break;
		  }
	  }
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
  }

  @BeforeClass
  public void beforeClass() 
  {
	  
  }

  @AfterClass
  public void afterClass() 
  {
	  
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("inside before Test");  
	  LaunchBrowser();
  }

  @AfterTest
  public void afterTest() 
  {
	  //driver.quit();
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("inside beforeSuite");
	  try 
	  {
		ReadPropertiesFiles();
	  } catch (IOException e) 
	  {
		e.printStackTrace();
	  }
  }

  @AfterSuite
  public void afterSuite() 
  {
	  
  }

}
