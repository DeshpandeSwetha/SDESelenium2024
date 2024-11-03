package com.selenium;

import org.testng.annotations.Test;

import com.POM.FileUploadPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class validateFileUpload extends Library
{
  @Test(priority=1)
  public void ValidateFileUpload() throws InterruptedException 
  {
	  driver.get(objProp.getProperty("FileUploadUrl"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("FileUploadTitle"));
	  FileUploadPOM objFileUpload = new FileUploadPOM(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	  
	  String filename = "D:\\8AM_Scripts\\32 Star Clipart - Star Images Free.jfif";
	  objFileUpload.clickBrowseBtn.sendKeys(filename);
	  Thread.sleep(3000);
	 // WebDriverWait wait = new WebDriverWait(driver,30);
	 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
	  //objFileUpload.removeBtn.click();
	  if(objFileUpload.imageUploaded.isDisplayed())
	  {
		  Assert.assertTrue(true, "Image Uploaded");
	  }
	  else
	  {
		  Assert.assertTrue(false, "Image not uploaded");
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
	  driver.quit();
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
