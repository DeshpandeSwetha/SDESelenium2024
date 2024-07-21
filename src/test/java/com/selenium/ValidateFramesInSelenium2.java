package com.selenium;

import org.testng.annotations.Test;

import com.POM.FramesPOM2;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateFramesInSelenium2 extends Library
{
  @Test(priority=1)
  public void validateHyrLaunch() 
  {
	  System.out.println("inside validateHyrLaunch");
	  driver.get(objProp.getProperty("HyrFramesUrl"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("HyrFramesTitle"));
  }
  
  @Test(priority=2)
  public void validateIFrame1()
  {
	  FramesPOM2 objFrames = new FramesPOM2();
	  scrollToElement(objFrames.iFrame1);
	  driver.switchTo().frame(objFrames.iFrame1);
	  System.out.println("inside validateIFrame1");
	  objFrames.dropdown1.click();
	  Select s1 = new Select(objFrames.dropdown1);
	  s1.selectByIndex(1);
	  WebElement text = s1.getFirstSelectedOption();
	  String selectedOption = text.getText();
	  System.out.println("Selected option: "+selectedOption);
	  driver.switchTo().defaultContent();
	  System.out.println("inside default page");
  }
  
  @Test(priority=3)
  public void valiadteIFrame2()
  {
	  FramesPOM2 objFrames = new FramesPOM2();
	  scrollToElement(objFrames.iFrame2);
	  driver.switchTo().frame(objFrames.iFrame2);
	  System.out.println("inside valiadteIFrame2");
	  scrollToElement(objFrames.scrollTillElement);
	  objFrames.firstName.sendKeys(objProp.getProperty("FirstName"));
	  objFrames.lastName.sendKeys(objProp.getProperty("LastName"));
	  WebElement radio1 = objFrames.maleOption;							
      WebElement radio2 = objFrames.femailOption;
      radio1.click();
      radio2.click();
      if(radio1.isSelected())
      {
    	  System.out.println("Male option is selected");
      }
      else
      {
    	  System.out.println("Female option is selected");
      }
      objFrames.englishCheckBox.click();
      objFrames.hindiCheckBox.click();
      objFrames.emailTextBox.sendKeys(objProp.getProperty("EmailAddress"));
      objFrames.passwordTextBox.sendKeys(objProp.getProperty("Password"));
      WebElement register = objFrames.registerBtn;
      register.click();
     // WebElement clear = objFrames.clearBtn;
     // clear.click();
      scrollToElement(objFrames.passwordTextBox);
      String confirmMessage = objFrames.confirmMessage.getText();
      if(register.isSelected())
      {
    	  if(confirmMessage.contains(objProp.getProperty("ConfirmMessageText")))
          {
        	  System.out.println("Registration Successfully Completed");
          }
    	  else
    	  {
    		  System.out.println("Registration not successfully completed");
    	  }
      }
      //else if (clear.isSelected()) 
     // {
	//	System.out.println("Everything is cleared");
	  //}
      driver.switchTo().defaultContent();
	  System.out.println("inside default page");
  }
  
  @Test(priority=4)
  public void validateIFrame3()
  {
	  FramesPOM2 objFrames = new FramesPOM2();
	  scrollToElement(objFrames.iFrame3);
	  driver.switchTo().frame(objFrames.iFrame3);
	  System.out.println("inside validateIFrame3");
	  validateIFrame1();
	  valiadteIFrame2();
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
	  //driver.close();
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
