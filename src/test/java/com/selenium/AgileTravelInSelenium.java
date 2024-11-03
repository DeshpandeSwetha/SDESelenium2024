package com.selenium;

import org.testng.annotations.Test;

import com.POM.TravelPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AgileTravelInSelenium extends Library
{
  @Test(priority=0)
  public void launchAgileTravelWebPage() 
  {
	  driver.get(objProp.getProperty("AgileTravelUrl"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  Assert.assertEquals(title, objProp.getProperty("AgileTravelTitle"));
  }
  
  @Test(priority=1,dependsOnMethods = {"launchAgileTravelWebPage"})
  public void loginPage()
  {
	  TravelPOM travel = new TravelPOM();
	  travel.username.sendKeys(objProp.getProperty("TravelUserName"));
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  travel.password.sendKeys(objProp.getProperty("TravelPassword"));
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  travel.rememberMeCheckBox.click();
	  travel.signInBtn.click();
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  //String pageContent1 = driver.getPageSource();
	  //Assert.assertEquals(pageContent1, objProp.getProperty("SignedInText"));
//	  if(pageContent1.contains(objProp.getProperty("SignedInText")))
//	  {
//		  System.out.println("User has signed in successfully");
//	  }
  }
  
  @Test(priority=2,dependsOnMethods = {"launchAgileTravelWebPage","loginPage"})
  public void flightDetails()
  {
	  TravelPOM travel = new TravelPOM();
	  String flightText = travel.selectFlightText.getText();
	  Assert.assertEquals(flightText, objProp.getProperty("SelectFlightText"));
	  travel.oneWayRadio.click();
	  if(travel.oneWayRadio.isSelected())
	  {
		  travel.fromTxtBox.click();
//		  for(int i=0;i<travel.fromTxtOptions.size();i++)
//		  {
//				System.out.println("Options avaliable are: " +travel.fromTxtOptions.get(i).getText());
//		  }
		  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		  Select select = new Select(travel.fromTxtBox);
		  select.selectByVisibleText(objProp.getProperty("FromPlace"));
		  
		  travel.toTxtBox.click();
//		  for(int i=0;i<travel.toTxtOptions.size();i++)
//		  {
//				System.out.println("Options avaliable are: " +travel.toTxtOptions.get(i).getText());
//		  }
		  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		  Select select1 = new Select(travel.toTxtBox);
		  select1.selectByVisibleText(objProp.getProperty("ToPlace"));
		  travel.toTxtBox.click();
		  travel.departingDateBox.sendKeys(objProp.getProperty("DepartingDate"));
		  travel.departingMonthAndYearBox.sendKeys(objProp.getProperty("DepartingMonthAndYear"));
		  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
//		  for(WebElement row : travel.rows)
//		  {
//			  for(WebElement column : travel.cells)
//			  {
//				  System.out.print(column.getText() + " | ");
//			  }
//			  System.out.println();
//			  break;
//		  }
		  
		  
		  
//		  for(int i=0;i<travel.rows.size();i++)
//		  {
//			  String flightTime = null;
//			  String flightNumber=null;
//			  String flightName=null;
//			  flightTime = travel.cells.get(0).getText();
//			  flightNumber = travel.cells.get(1).getText();
//			  flightName = travel.cells.get(2).getText();
//			  System.out.println("Flight Time: " + flightTime);
//		      System.out.println("Flight Number: " + flightNumber);
//	          System.out.println("Airline: " + flightName);
//	          System.out.println("-------------------------");
//			  if(flightTime.equals(objProp.getProperty("FlightTime")))
//			  {
//				  travel.checkBox1.click();
//				  break;
//			  }
//		  }
		  travel.continueBtn.click();
	  }
	  else
	  {
		  travel.fromTxtBox.click();
//		  for(int i=0;i<travel.fromTxtOptions.size();i++)
//		  {
//				System.out.println("Options avaliable are: " +travel.fromTxtOptions.get(i).getText());
//	      }
		  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		  Select select = new Select(travel.fromTxtBox);
		  select.selectByVisibleText(objProp.getProperty("FromPlace"));
		  
		  travel.toTxtBox.click();
//		  for(int i=0;i<travel.toTxtOptions.size();i++)
//		  {
//				System.out.println("Options avaliable are: " +travel.toTxtOptions.get(i).getText());
//		  }
		  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		  Select select1 = new Select(travel.toTxtBox);
		  select1.selectByVisibleText(objProp.getProperty("ToPlace"));
		  travel.toTxtBox.click();
		  travel.departingDateBox.sendKeys(objProp.getProperty("DepartingDate"));
		  travel.departingMonthAndYearBox.sendKeys(objProp.getProperty("DepartingMonthAndYear"));
		  travel.returnDateBox.sendKeys(objProp.getProperty("ReturnDate"));
		  travel.returnMonthAndYearBox.sendKeys(objProp.getProperty("ReturnMonthAndYear"));
		  travel.continueBtn.click();
	  }  
  }
  
  @Test(priority=3,dependsOnMethods = {"launchAgileTravelWebPage","loginPage","flightDetails"})
  public void passengerDetails()
  {
	  TravelPOM travel = new TravelPOM();
	  String passengerText = travel.passengerText.getText();
	  Assert.assertEquals(passengerText, objProp.getProperty("PassengerPageDetail"));
//	  String contentDetail = driver.getPageSource();
//	  if(contentDetail.contains(objProp.getProperty("PassengerPageDetail")))
//	  {
//		  System.out.println("User landed on Passenger Details page");
//	  }
	  travel.passengerFirstName.sendKeys(objProp.getProperty("PassengerFirstName"));
	  travel.passengerLastName.sendKeys(objProp.getProperty("PassengerLastName"));
	  travel.nextBtn.click();
  }
  
  @Test(priority=4,dependsOnMethods = {"launchAgileTravelWebPage","loginPage","flightDetails","passengerDetails"})
  public void paymentDetails()
  {
	  TravelPOM travel = new TravelPOM();
	  String paymentText = travel.paymentText.getText();
	  Assert.assertEquals(paymentText, objProp.getProperty("PaymentDetail"));
//	  String payText = driver.getPageSource();
//	  if(payText.contains(objProp.getProperty("PaymentDetail")))
//	  {
//		  System.out.println("User landed on Payment page");
//	  }
	  //System.out.println(travel.totalAmount.getText());
	  travel.visaCard.click();
//	  if(travel.visaCard.isSelected())
//	  {
//		  System.out.println("Visa option is selected");
//	  }
//	  else
//	  {
//		  System.out.println("Other option got selected");
//	  }
	  travel.cardNumber.sendKeys(objProp.getProperty("CardNumber"));
	  selectRequiredValueFromDropDown(travel.expiryDate, objProp.getProperty("ExpiryDate"));
	  selectRequiredValueFromDropDown(travel.expiryYear, objProp.getProperty("ExpiryYear"));
	  travel.payNowBtn.click();
  }
  
  @Test(priority=5,dependsOnMethods={"launchAgileTravelWebPage","loginPage","flightDetails","passengerDetails","paymentDetails"})
  public void confirmMessage()
  {
	  TravelPOM travel = new TravelPOM();
	  //System.out.println(travel.entireMessage.getText());
	  System.out.println(travel.confirmationText.getText());
	  System.out.println(travel.bookingNumber.getText());
	  System.out.println(travel.travelPlaces.getText());
	  System.out.println(travel.passengerDetails.getText());
  }
  
  @Test(priority=6,dependsOnMethods={"launchAgileTravelWebPage","loginPage","flightDetails","passengerDetails","paymentDetails","confirmMessage"})
  public void signOff()
  {
	  TravelPOM travel = new TravelPOM();
	  travel.signOff.click();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
//	  String text = driver.getPageSource();
//	  if(text.contains(objProp.getProperty("SignedOutText")))
//	  {
//		  System.out.println("User has been signed out successfully");
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
