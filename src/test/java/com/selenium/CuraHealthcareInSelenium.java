package com.selenium;

import org.testng.annotations.Test;

import com.POM.CuraPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class CuraHealthcareInSelenium extends Library
{
  @Test(priority=0)
  public void launchCuraHealthcareServiceWebPage() 
  {
	  CuraPOM cura = new CuraPOM();
	  driver.get(objProp.getProperty("CuraHealthCareURL"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  Assert.assertEquals(title, objProp.getProperty("CuraTitle"));
	  String serviceInfo = cura.contactInfo.getText();
	  System.out.println(serviceInfo);
  }
  
  @Test(dependsOnMethods = "launchCuraHealthcareServiceWebPage")
  public void toggleMenuContents()
  {
	  CuraPOM cura = new CuraPOM();
		cura.toggleBtn.click();
		for(int i=0;i<cura.toggleBtnMenu.size();i++)
		{
			System.out.println("Contents are: " +cura.toggleBtnMenu.get(i).getText());
		}
		driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		cura.toggleBtn.click();
  }
  
  @Test(dependsOnMethods = {"launchCuraHealthcareServiceWebPage","toggleMenuContents"})
  public void patientLogin() throws Throwable
  {
	  CuraPOM cura = new CuraPOM();
	  cura.makeAppointmtntBtn.click();
	  String pageContent = driver.getPageSource();
	  if(pageContent.contains(objProp.getProperty("PageContent")))
	  {
		  System.out.println("User landed on login page");
		  cura.userName.sendKeys("John Doe");
		  cura.password.sendKeys("ThisIsNotAPassword");
		  Thread.sleep(2000);
		  cura.loginBtn.click();
	  }
  }
  
  @Test(dependsOnMethods = {"launchCuraHealthcareServiceWebPage","toggleMenuContents",
		                    "patientLogin"})
  public void makeAppointment()
  {
	  CuraPOM cura = new CuraPOM();
	  String pageContent1 = driver.getPageSource();
	  if(pageContent1.contains(objProp.getProperty("PageContent1")))
	  {
		  System.out.println("Patient landed on make appointment page");
	  }
		  cura.facilityBtn.click();
		  for(int i=0;i<cura.facilityOptions.size();i++)
		  {
				System.out.println("Options avaliable are: " +cura.facilityOptions.get(i).getText());
		  }
		  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		  Select select = new Select(cura.facilityBtn);
		  select.selectByIndex(2);
		  cura.facilityBtn.click();
		  cura.checkBox.click();
		  cura.medicaidOption.click();
		  if(cura.medicareOption.isSelected())
		  {
			  System.out.println("Medicare is selected");
		  }
		  else if (cura.medicaidOption.isSelected()) 
		  {
			  System.out.println("Medicaid is selected");
		  }
		  else if (!cura.medicareOption.isSelected() && cura.medicaidOption.isSelected()) 
		  {
			  System.out.println("None is selected");
		  }
		  cura.DOA.sendKeys(objProp.getProperty("DateOfAppointment"));
		  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		  cura.commentText.sendKeys(objProp.getProperty("CommentText"));
		  //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		  //wait.until(ExpectedConditions.visibilityOfElementLocated((By) cura.makeAppointmtntBtn));
		  cura.bookAppointmentBtn.click();
		  String pageContent2 = driver.getPageSource();
		  if(pageContent2.contains(objProp.getProperty("AppointConfirmationText")))
		  {
			  System.out.println("Appointment has been book successfully");
		  }
		  cura.toggleBtn.click();
		  for(int i=0;i<cura.toggleBtnMenu.size();i++)
			{
				System.out.println("Contents are: " +cura.toggleBtnMenu.get(i).getText());
			}
		  cura.homeBtn.click();
		  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		  if(cura.homeBtn.isSelected())
		  {
			  String pageContent3 = driver.getPageSource();
			  if(pageContent3.contains(objProp.getProperty("PageContent1")))
			  {
				  System.out.println("Patient landed on make appointment page");
			  }
		  }
		  cura.toggleBtn.click();
		  cura.historyBtn.click();
		  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		  String url = driver.getCurrentUrl();
		  if(url.equalsIgnoreCase(cura.historyPage.getText()))
		  {
			  System.out.println("User landed on history page");
		  }
		  
		  int numberOfItems = cura.historyItems.size();
		  if(numberOfItems>0)
		  {
			  System.out.println("This page contains " +numberOfItems+ " history items");
		  }
		  cura.toggleBtn.click();
		  cura.profileBtn.click();
		  PageLoadTimeOut(Constants.PageLoadTimeOut);
		  String pageContent4 = driver.getPageSource();
		  if(pageContent4.contains("Profile"))
		  {
			  System.out.println("User landed on profile page");
		  }
		  cura.toggleBtn.click();
		  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		  cura.logoutBtn.click();
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
