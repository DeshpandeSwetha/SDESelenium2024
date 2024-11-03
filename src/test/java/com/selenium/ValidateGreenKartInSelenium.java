package com.selenium;

import org.testng.annotations.Test;

import com.POM.GreenKartPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
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

public class ValidateGreenKartInSelenium extends Library
{
  @Test(priority=0)
  public void ValidateLaunchAlertsOnDemoQA() 
  {
	  driver.get(objProp.getProperty("GreenKartURL"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  Assert.assertEquals(title, objProp.getProperty("GreenKartTitle"));
  }
  
  @Test
  public void displayVegesList()
  {
	  GreenKartPOM greenkart = new GreenKartPOM();
	  System.out.println("Number of vegetables avaliable:" +greenkart.products.size());
	  for(int i=0; i<greenkart.products.size();i++)
	  { 
		  String[] veges = greenkart.productNames.get(i).getText().split("-");
		  String formatedNames = veges[0].trim();
		  System.out.println("Vegetable Names: " +formatedNames);
//		  List<String> itemsneeded = Arrays.asList(vegesToAdd);
//		  if(itemsneeded.contains(formatedNames))
//		  {
//				  driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
//				  break;
//		  }
	  }
//	  
//	// Array of vegetable names to add to the cart
//      String[] vegesToAdd = {"Broccoli", "Cauliflower", "Beetroot"};
//
//      // Add the specified vegetables to the cart
//      addItemsToCart(driver, vegesToAdd);

  }
  
  @Test
  public void addVegesToCart()
  {
	  String[] vegesToAdd = {"Potato", "Beetroot"};
	  
	  for (String vegetable : vegesToAdd) 
	  {
          addToCart(driver, vegetable);
      }
  }
  
  @Test
  public void proceedToCheckoutPage()
  {
	  GreenKartPOM greenkart = new GreenKartPOM();
	  greenkart.clickAddToCartIcon.click();
	  greenkart.clickProceedToCheckoutBtn.click();
	  
	  greenkart.textBox.sendKeys("rahulshettyacademy");
	  greenkart.applyNowBtn.click();
	  //driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.ImplicitWaitTimeOut));
	  wait.until(ExpectedConditions.visibilityOf(greenkart.promoCodeAppliedText));
	  greenkart.placeOrderBtn.click();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(Constants.ImplicitWaitTimeOut));
	  wait1.until(ExpectedConditions.visibilityOf(greenkart.countryPageDisplayed));
	  greenkart.selectCountryDropDown.click();
	  List<WebElement> allOptions = greenkart.selectCountry;
	  //String option1="India";
	  for(int i=0;i<allOptions.size();i++)
	  {
		  if(allOptions.get(i).getText().contains(objProp.getProperty("SelectCountry")))
		  {
			  allOptions.get(i).click();
		  }
	  }
	  //Select select = new Select(greenkart.selectCountry);
	  //select.selectByValue(objProp.getProperty("SelectCountry"));
	  greenkart.clickOnCheckBox.click();
	  greenkart.clickOnProceed.click();
//	  WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(Constants.ImplicitWaitTimeOut));
//	  wait2.until(ExpectedConditions.visibilityOf(greenkart.cartCount));
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("GreenKartTitle"));

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
