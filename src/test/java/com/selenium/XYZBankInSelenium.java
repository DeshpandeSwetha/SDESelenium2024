package com.selenium;

import org.testng.annotations.Test;

import com.POM.SimpleTravelPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class XYZBankInSelenium extends Library
{
  @Test(priority=1)
  public void launchAgileTravelWebPage() 
  {
	  driver.get(objProp.getProperty("XYZBankUrl"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  Assert.assertEquals(title, objProp.getProperty("XYZBankTitle"));
  }
  
  @Test(priority=2)
  public void managerPage() throws Throwable
  {
	  SimpleTravelPOM simple = new SimpleTravelPOM();
	  simple.managerLogin.click();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  simple.addCustomerBtn.click();
	  if(simple.customerForm.isDisplayed())
	  {
		  simple.firstName.sendKeys(objProp.getProperty("FirstName"));
		  simple.lastName.sendKeys(objProp.getProperty("LastName"));
		  simple.pinCode.sendKeys(objProp.getProperty("PinCode"));
	  }
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  if(simple.addCustomerButton.isDisplayed())
	  {
		  simple.addCustomerButton.click();
	  }
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.ImplicitWaitTimeOut));
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert = driver.switchTo().alert();
	  String alertText = alert.getText();
	  System.out.println("AlertText is:" +alertText);
	  alert.accept();
	  simple.openAccountButton.click();
	  wait.until(ExpectedConditions.visibilityOfAllElements(simple.customerForm));
	  if(simple.customerForm.isDisplayed())
	  {
		  simple.customerNameBox.click();
		  selectRequiredValueFromDropDown(simple.customerNameOptions, objProp.getProperty("CustomerName"));
		  simple.currencyBox.click();
		  selectRequiredValueFromDropDown(simple.currencyOptions, objProp.getProperty("Currency"));
	  }
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  if(simple.addCustomerButton.isDisplayed())
	  {
		  simple.addCustomerButton.click();
	  }
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert1 = driver.switchTo().alert();
	  String alertText1 = alert1.getText();
	  System.out.println("AlertText is:" +alertText1);
	  alert.accept();
	  simple.customerButton.click();
	  int rowCount = simple.customerRows.size();
	  for(int i=1;i<=rowCount;i++)
	  {
		  String firstName = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']//tbody//tr["+i+"]/td[1]")).getText();
		  String lastName = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']//tbody//tr["+i+"]/td[2]")).getText();
		  String postCode = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']//tbody//tr["+i+"]/td[3]")).getText();
		  String accountNumber = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']//tbody//tr["+i+"]/td[4]")).getText();
		  System.out.println(firstName+" | "+lastName+" | "+postCode+" | "+accountNumber);
	  }
//	  for(WebElement rows : simple.customerRows)
//	  {
//		  System.out.println("Customer Details:" +rows.getText());
//	  }
	  simple.searchContent.sendKeys(objProp.getProperty("FirstName"));
	  Thread.sleep(5000);
	  //validate if the customer appears in the search list
	  WebElement customerResult = driver.findElement(By.xpath("//td[contains(text(),'"+objProp.getProperty("FirstName")+"')]"));
	  if(customerResult.isDisplayed())
	  {
		System.out.println("Customer found:" +customerResult.getText());
		simple.deleteButton.click();
		System.out.println("Customer deleted successfully");
	  }
	  else
	  {
		  System.out.println("Customer not found");
	  }
	  simple.homeButton.click();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("XYZBankTitle"));
//	  String actualUrl1= driver.getCurrentUrl();
//	  if(actualUrl1.equals(objProp.getProperty("expectedUrl1")))
//	  {
//		  System.out.println("URL Validation passed");
//		  for(WebElement buttons : simple.managerOperationsText)
//		  {
//			  System.out.println("Buttontext:" +buttons.getText());
//		  }
//	  }
//	  else
//	  {
//		  System.out.println("URL Validation failed");
//	  }
  }
   
  @Test(priority=3)
  public void customerLoginPage() throws Throwable
  {
	  SimpleTravelPOM simple = new SimpleTravelPOM();
	  simple.customerLogin.click();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  simple.selectCustomerBox.click();
	  Thread.sleep(3000);
	  selectRequiredValueFromDropDown(simple.selectCustomer, objProp.getProperty("CustomerName1"));
	  if(simple.loginButton.isDisplayed())
	  {
		  simple.loginButton.click();
	  }
	  String title2 = simple.customerNameCheck.getText();
	  Assert.assertEquals(title2, objProp.getProperty("CustomerName1"), "User landed on other page");
	  String name = driver.findElement(By.xpath("//strong[contains(.,'Welcome "+objProp.getProperty("CustomerName1")+" !!')]")).getText();
	  System.out.println(name);
	  simple.accountDropDownBox.click();
	  Thread.sleep(2000);
	  System.out.println("Number of accounts you currently have:" +simple.accountSelect.size());
//	  if(simple.accountSelect.size() > 1)
//	  {
//		  selectRequiredValueFromDropDown(simple.accountSelect, objProp.getProperty("AccountNumber1"));
//		  simple.accountDropDownBox.click();
//	  }
	  System.out.println(simple.divElement.getText());
	  System.out.println("Number of operations you can perform:" +simple.buttonList.size());
	  for(WebElement buttons : simple.buttonList)
	  {
		  System.out.println(buttons.getText());
	  }
	  if(simple.transactionButton.isDisplayed())
	  {
		simple.transactionButton.click();
	  }
	  int rowCount = simple.transactionRows.size();
	  try 
	  {
		boolean morePages = true;
		while(morePages)
		{
			for(WebElement rows :simple.transactionRows)
			{
				System.out.println(rows.getText());
			}
			if(simple.nextButton.isEnabled())
			{
				simple.nextButton.click();
			}
			else
			{
				morePages=false;
			}
		}
	  } catch (Exception e) 
	  {
		  System.out.println("No data avaliable");
	  }
//		  for(int i=1;i<=rowCount;i++)
//		  {
//			String date = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr["+i+"]/td[1]")).getText();
//			String amount = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr["+i+"]/td[2]")).getText();
//			String transactionType = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr["+i+"]/td[3]")).getText();
//			System.out.println(date+" | "+amount+" | "+transactionType);
//		  }
//	  }
//	  else
//	  {
//		  System.out.println("No data avaliable"); 
//	  }
	  simple.backButton.click();
	  if(simple.depositButton.isDisplayed())
	  {
		simple.depositButton.click();
	  }
	  simple.AmountBox1.click();
	  simple.AmountBox1.sendKeys(objProp.getProperty("DepositAmount"));
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  simple.deposit.click();
	  System.out.println("Deposit message:" +simple.message.getText());
	  System.out.println("Balance amount in your account: $" +simple.balanceAmount.getText());
	  if(simple.withdrawlButton.isDisplayed())
	  {
		simple.withdrawlButton.click();
	  }
//	  simple.AmountBox1.click();
//	  simple.AmountBox1.sendKeys(String.valueOf(objProp.getProperty("WithdrawAmount")));
	  try 
	  {
		  simple.AmountBox2.click();
		  int amount3 = 10000;
		  simple.AmountBox2.sendKeys(String.valueOf(amount3));
		  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		  simple.withdraw.click();
		  if(simple.message.isDisplayed())
		  {
			  System.out.println("Error message displayed:" +simple.message.getText());
		  }
		  else
		  {
			  System.out.println("Withdrawal was successful.");
		  } 
//		  int amount = Integer.parseInt(simple.balanceAmount.getText());
//		  int amount1 = Integer.parseInt(objProp.getProperty("WithdrawAmount"));
//		  if(amount1 < amount)
//		  {
//			  System.out.println("Deposit message:" +simple.message.getText());
//			  System.out.println("Balance amount in your account: $" +simple.balanceAmount.getText());
//		  }
//		  else
//		  {
//			  System.out.println("Warning message:" +simple.message.getText());  
//		  }
	  } catch (Exception e) 
	  {
		  //e.printStackTrace();
		  System.out.println("You're unable to withdraw the amount due to technical issues. Please try again later");
	  }
//	  for(WebElement elements : simple.divElement)
//	  {
//		  System.out.println(elements.getText());
//	  }
//	  String title2= driver.getCurrentUrl();
//	  if(title2.contains("customer"))
//	  {
//		  System.out.println("User landed on customer page");
//	  }
//	  else
//	  {
//		  System.out.println("User landed on wrong page");
//	  }
	  
  }
  
  @Test(priority=4)
  public void logoutOperation()
  {
	  SimpleTravelPOM simple = new SimpleTravelPOM();
	  if(simple.logoutButton.isDisplayed())
	  {
		simple.logoutButton.click();
	  }
	  simple.homeButton.click();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("XYZBankTitle"));
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
