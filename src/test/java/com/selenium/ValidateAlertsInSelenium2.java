package com.selenium;

import org.testng.annotations.Test;

import com.POM.HyrPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateAlertsInSelenium2 extends Library
{
  @Test(priority=1)
  public void ValidateHyrWebsiteLaunch() 
  {
	  System.out.println("inside ValidateHyrWebsiteLaunch");
	  driver.get(objProp.getProperty("HyrAlertsUrl"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("HyrTitle"));
  }
  
  @Test(priority=2)
  public void validateAlertBox() throws Exception
  {
	  System.out.println("inside validateAlertBox");
	  HyrPOM objhyr = new HyrPOM(driver);
	  scrollToElement(objhyr.headerText);
	  objhyr.alertBox.click();
	  Alert alertBox = driver.switchTo().alert();
	  Thread.sleep(3000);
	  String textOfAlertBox= alertBox.getText();
	  Assert.assertEquals(textOfAlertBox, objProp.getProperty("AlertBoxMessage"));
	  alertBox.accept();
	  String alertBoxText = objProp.getProperty("AlertBoxOutput");
	  Assert.assertEquals(alertBoxText, objhyr.alertBoxOutput.getText());
  }
  
  @Test(priority=3)
  public void validateConfirmAlertBox() throws Exception
  {
	  System.out.println("inside validateConfirmAlertBox");
	  HyrPOM objhyr = new HyrPOM(driver);
	  scrollToElement(objhyr.headerText);
	  objhyr.confirmBox.click();
	  Alert confirmalertBox = driver.switchTo().alert();
	  Thread.sleep(3000);
	  String textOfConfirmAlertBox= confirmalertBox.getText();
	  Assert.assertEquals(textOfConfirmAlertBox, objProp.getProperty("ConfirmBoxMessage"));
	  confirmalertBox.dismiss();
	  String confirmBoxText = objProp.getProperty("confirmBoxOutput");
	  Assert.assertEquals(confirmBoxText, objhyr.alertBoxOutput.getText());
  }
  
  @Test(priority=4)
  public void validatePromptAlertBox() throws Exception
  {
	  System.out.println("inside validatePromptAlertBox");
	  HyrPOM objhyr = new HyrPOM(driver);
	  scrollToElement(objhyr.headerText);
	  objhyr.promptBox.click();
	  Alert promptalertBox = driver.switchTo().alert();
	  Thread.sleep(3000);
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.ImplicitWaitTimeOut));
	  promptalertBox.sendKeys(objProp.getProperty("PromptBoxText"));
	  Thread.sleep(3000);
	  promptalertBox.accept();
	  String promptBoxText = objProp.getProperty("PromptBoxOutput");
	  Assert.assertEquals(promptBoxText, objhyr.alertBoxOutput.getText());
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
