package com.selenium;

import org.testng.annotations.Test;
import org.testng.asserts.IAssert;

import com.POM.FramesPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateFramesInSelenium extends Library
{
  @Test(priority=0)
  public void ValidateFramesInDemoAutomationTesting() 
  {
	  System.out.println("inside ValidateFramesInDemoAutomationTesting");
	  driver.get(objProp.getProperty("FramesURL"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("TitleOfFrames"));
  }
  
  @Test(priority=1)
  public void ValidateTextBoxInsideSingleFrame()
  {
	  System.out.println("inside ValidateTextBoxInsideSingleFrame");
	  FramesPOM objFramesPOM = new FramesPOM();
	  driver.switchTo().frame(objFramesPOM.singleFrame);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();",objFramesPOM.inputTextBox );
	  objFramesPOM.inputTextBox.sendKeys("SingleFrameText");
	  String text = objProp.getProperty("SingleFrameText");
	  Assert.assertEquals(text, objProp.getProperty("SingleFrameText"));
	  driver.switchTo().defaultContent();
  }
  
  @Test(priority=2)
  public void ValidateTextBoxInNestedFrames()
  {
	  FramesPOM objFramesPOM = new FramesPOM();
	  objFramesPOM.multipleIFrame.click();
	  driver.switchTo().frame(objFramesPOM.nestedOuterIFrame);
	  driver.switchTo().frame(objFramesPOM.nestedInnerIFrame);
	  //JavascriptExecutor js = (JavascriptExecutor) driver;
	  //js.executeScript("arguments[0].scrollIntoView();",objFramesPOM.inputTextBox );
	  objFramesPOM.inputTextBox.sendKeys("IframeWithInIframeText");
	  String text = objProp.getProperty("IframeWithInIframeText");
	  Assert.assertEquals(text, objProp.getProperty("IframeWithInIframeText"));
	  driver.switchTo().defaultContent();
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
	  driver.close();
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
