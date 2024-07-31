package com.selenium;

import org.testng.annotations.Test;

import com.POM.WindowPOM;
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

public class ValidateHandlingWindowsInSelenium extends Library
{
  @Test(priority=1)
  public void validateGuru99Website() 
  {
	  System.out.println("inside validateGuru99Website");
	  driver.get(objProp.getProperty("Guru99Website"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("Guru99Title"));
  }
  
  @Test(priority=2)
  public void validateNewWindowPage()
  {
	  WindowPOM objwin = new WindowPOM();
	  objwin.clickHereBtn.click();
	  //String parentWindow = driver.getWindowHandle();
	  Set<String> allWindows = driver.getWindowHandles();
	  System.out.println("number of windows :"+allWindows.size());
	  boolean flag = false;
	  for(String window : allWindows)
	  {
		  driver.switchTo().window(window);
		  String pageSource = driver.getPageSource();
		  if(pageSource.contains(objProp.getProperty("TextPresentInNewWindow")))
		  {
			  flag = true;
			  Assert.assertEquals(flag, true);
			  //Assert.assertTrue(flag, "TextPresentInNewWindow is no not validated");
		  }
	  }
	  objwin.emailTextBox.sendKeys(objProp.getProperty("EmailId"));
	  objwin.submitBtn.click();
  }
  
  @Test(priority=3)
  public void validateAccessPage()
  {
	  System.out.println("inside validateAccessPage");
	  //WindowPOM objwin = new WindowPOM();
	  boolean flag = false;
	  //String text = objwin.accessMessage.getText();
	  String pageSource = driver.getPageSource();
	  if(pageSource.contains(objProp.getProperty("AccessMessage")))
	  {
		  flag = true;
		  //Assert.assertEquals(flag, true);
		  Assert.assertTrue(flag, "Access is not granted");
	  }
	  
//	  if(text.contains(objProp.getProperty("AccessMessage")))
//	  {
//		  System.out.println("Access granted");
//	  }
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
	  driver.quit();
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
