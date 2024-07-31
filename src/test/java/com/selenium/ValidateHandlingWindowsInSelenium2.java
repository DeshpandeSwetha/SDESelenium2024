package com.selenium;

import org.testng.annotations.Test;

import com.POM.WindowPOM2;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateHandlingWindowsInSelenium2 extends Library
{
  @Test(priority=1)
  public void validateHyrWindowsWebsite() 
  {
	  System.out.println("inside validateHyrTutorialsWebsite");
	  driver.get(objProp.getProperty("HyrWindowsUrl"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("HyrWindowsTitle"));
  }
  
  @Test(priority=2,enabled=false)
  public void validateNewWindow() throws Exception
  {
	  System.out.println("inside validateNewWindow");
	  WindowPOM2 objwin1 = new WindowPOM2();
	  scrollToElement(objwin1.openNewWindowBtn);
	  objwin1.openNewWindowBtn.click();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  Set<String> allWindows1 = driver.getWindowHandles();
	  System.out.println("number of windows :"+allWindows1.size());
	  boolean flag = false;
	  for(String window : allWindows1)
	  {
		  driver.switchTo().window(window);
		  String pageSource = driver.getPageSource();
		  if(pageSource.contains(objProp.getProperty("HyrWindowText1")))
		  {
			  flag = true;
			  Assert.assertEquals(flag, true);
			  String newWinowTitle = driver.getTitle();
			  //Assert.assertEquals(newWinowTitle, objProp.getProperty("BacicControlPageTitle"));
			  if(newWinowTitle.contains(objProp.getProperty("BacicControlPageTitle")))
			  {
				 System.out.println("inside window 1"); 
			  }
		  }
	  }
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  scrollToElement(objwin1.scrollTillBasicControl);
	  driver.close();
  }
  
  @Test(priority=3,enabled=false)
  public void validateMultipleWindow() throws Exception
  {
	  System.out.println("inside validateMultipleWindow");
	  WindowPOM2 objwin1 = new WindowPOM2();
	  objwin1.openNewWindowBtn2.click();
	  Set<String> allWindows = driver.getWindowHandles();
	  System.out.println("number of windows :"+allWindows.size());
	  boolean flag = false;
	  for(String window : allWindows)
	  {
		  driver.switchTo().window(window);
		  String pageSource = driver.getPageSource();
		  if(pageSource.contains(objProp.getProperty("HyrWindowText1")))
		  {
			  flag = true;
			  Assert.assertEquals(flag, true);
			  //Assert.assertTrue(flag, "TextPresentInNewWindow is no not validated");
		  }
	  }
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  scrollToElement(objwin1.scrollTillAlertsDemo);
	  driver.close();
  }
  
  @Test(priority=4,enabled=false)
  public void validateMultipleWindows() throws Exception
  {
	  System.out.println("inside validateMultipleWindows");
	  WindowPOM2 objwin1 = new WindowPOM2();
	  objwin1.openMultipleWindowBtn.click();
	  String parentWindow = driver.getWindowHandle();
	  Set<String> allWindows = driver.getWindowHandles();
	  System.out.println("number of windows :"+allWindows.size());
	  boolean flag = false;
	  for(String window : allWindows)
	  {
		  driver.switchTo().window(window);
		  String title = driver.getTitle();
		  System.out.println("Title of window is:"+title);
		  if(title.equalsIgnoreCase(objProp.getProperty("BacicControlPageTitle")))
		  {
			  String pageSource = driver.getPageSource();
			  //driver.manage().window().maximize();
			  scrollToElement(objwin1.scrollTillBasicControl);
			  if(pageSource.contains(objwin1.scrollTillBasicControl.getText()))
			  {
				  flag = true;
				  Assert.assertEquals(flag, true); 
			  }
			  driver.close();
		  }
		  else if(title.equalsIgnoreCase(objProp.getProperty("XpathPageTitle")))
		  {
			  String pageSource = driver.getPageSource();
			  //driver.manage().window().maximize();
			  scrollToElement(objwin1.scrollTillXpathPractice);
			  if(pageSource.contains(objwin1.scrollTillXpathPractice.getText()))
			  {
				  flag = true;
				  Assert.assertEquals(flag, true); 
			  }
			  driver.close();
		  }
	  } 
	  driver.switchTo().window(parentWindow);
	  Assert.assertEquals(driver.getTitle(), objProp.getProperty("HyrWindowsTitle"));
  }
  
  @Test(priority=5)
  public void validateMultipleTabs()
  {
	  System.out.println("inside validateMultipleTabs");
	  WindowPOM2 objwin2 = new WindowPOM2();
	  objwin2.openMultipleTabsBtn.click();
	  String parentWindow = driver.getWindowHandle();
	  Set<String> allWindows = driver.getWindowHandles();
	  System.out.println("number of windows :"+allWindows.size());
	  boolean flag = false;  
	  for(String window : allWindows)
	  {
		  driver.switchTo().window(window);
		  String title = driver.getTitle();
		  System.out.println("Title of window is:"+title);
		  if(title.equalsIgnoreCase(objProp.getProperty("BacicControlPageTitle")))
		  {
			  String pageSource = driver.getPageSource();
			  if(pageSource.contains(objwin2.scrollTillBasicControl.getText()))
			  {
				  flag = true;
				  Assert.assertEquals(flag, true);
			  }
			  driver.close();
		  }
		  if(title.equalsIgnoreCase(objProp.getProperty("HyrTitle")))
		  {
			  String pageSource1 = driver.getPageSource();
			  if(pageSource1.contains(objwin2.scrollTillAlertsDemo.getText()))
			  {
				  flag = true;
				  Assert.assertEquals(flag, true);
			  }
			  driver.close();
		  }
	  }
	  driver.switchTo().window(parentWindow);
	  Assert.assertEquals(driver.getTitle(), objProp.getProperty("HyrWindowsTitle"));
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
	  } 
	  catch (IOException e) 
	  {
		e.printStackTrace();
	  }
  }

  @AfterSuite
  public void afterSuite() 
  {
	  
  }

}
