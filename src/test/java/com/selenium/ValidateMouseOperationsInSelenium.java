package com.selenium;

import org.testng.annotations.Test;

import com.POM.MouseOperationsPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateMouseOperationsInSelenium extends Library
{
  @Test(priority=1)
  public void ValidateMouseOperationsWebsiteLaunch() 
  {
	  System.out.println("inside ValidateMouseOperationsWebsiteLaunch");
	  driver.get(objProp.getProperty("MouseOperation_RightClick"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("JQuery_Title"));
  }
  
  @Test(priority=2)
  public void validateRightClickOperation() throws Exception
  {
	System.out.println("inside validateRightClickOperation");
	MouseOperationsPOM objMouse = new MouseOperationsPOM();
	Actions ac = new Actions(driver);
	ac.contextClick(objMouse.rightClickBtn).build().perform();
	objMouse.clickOnCopy.click();
	Alert al = driver.switchTo().alert();
	Thread.sleep(3000);
	String textOflAlert= al.getText();
	Assert.assertEquals(textOflAlert, objProp.getProperty("CopyOptionAlertText"));
	al.accept();
  }
  
  @Test(priority=3)
  public void validateDoubleClickOperation() throws Exception
  {
	  System.out.println("inside validateDoubleClickOperation");
	  driver.navigate().to(objProp.getProperty("MouseOperation_DoubleClick"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("DoubleClickTitle"));
	  MouseOperationsPOM objMouse = new MouseOperationsPOM();
	  scrollToElement(objMouse.iFrame);
	  driver.switchTo().frame(objMouse.iFrame);
	  Thread.sleep(3000);
	  Actions ac = new Actions(driver);
	  ac.doubleClick(objMouse.blueColorBox).build().perform();
	  driver.switchTo().defaultContent();
  }
  
  @Test(priority=4)
  public void validateDragAndDrop()
  {
	  System.out.println("inside validateDragAndDrop");
	  driver.navigate().to(objProp.getProperty("MouseOperation_DragandDrop"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("DragAndDrop_Title"));
	  MouseOperationsPOM objMouse = new MouseOperationsPOM();
	  scrollToElement(objMouse.dragAndDropFrame);
	  driver.switchTo().frame(objMouse.dragAndDropFrame);
	  Actions ac = new Actions(driver);
	  //ac.clickAndHold(objMouse.draggable);
	  //ac.moveToElement(objMouse.droppable).build().perform();
	  ac.dragAndDrop(objMouse.draggable, objMouse.droppable).build().perform();
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
