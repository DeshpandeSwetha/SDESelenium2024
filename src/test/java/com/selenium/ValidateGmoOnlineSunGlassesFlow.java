package com.selenium;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.POM.GmoOnlinePOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateGmoOnlineSunGlassesFlow extends Library 
{
	@Test(priority = 0)
	public void ValidateLaunchOfGmoOnlineApplication() 
	{
		System.out.println("inside ValidateLaunchOfGmoOnlineApplication");
		driver.get(objProp.getProperty("GmoOnlineAppUrl"));
		PageLoadTimeOut(Constants.PageLoadTimeOut);
		String titleOfGmoOnlineApp = driver.getTitle();
		Assert.assertEquals(titleOfGmoOnlineApp, objProp.getProperty("TitleOfGmoOnlineHomePage"));
	}

	@Test(priority = 1,dependsOnMethods = {"ValidateLaunchOfGmoOnlineApplication"})
	public void ValidateGlacierSunGlassesProduct() throws InterruptedException 
	{
		GmoOnlinePOM objPOM = new GmoOnlinePOM(driver);
		objPOM.EnterGmoOnline.click();
		PageLoadTimeOut(Constants.PageLoadTimeOut);
		String titleOfOnlineCatalog = driver.getTitle();
		Assert.assertEquals(titleOfOnlineCatalog, objProp.getProperty("TitleOfOnlineCatalogPage"));
		objPOM.Glacier_Sun_Glasses.clear();
		Thread.sleep(3000);
		objPOM.Glacier_Sun_Glasses.sendKeys(Constants.Glacier_Sun_Glasses_Qty);
		Thread.sleep(3000);
		objPOM.PlaceAnOrder.click();
		PageLoadTimeOut(Constants.PageLoadTimeOut);
	}

	@Test(priority = 2,dependsOnMethods = {"ValidateLaunchOfGmoOnlineApplication","ValidateGlacierSunGlassesProduct"})
	public void ValidatePriceCalculationOnPlaceOrderPage() 
	{
		String titleOfPlaceOrder = driver.getTitle();
		SoftAssert objSoftAssert = new SoftAssert();
		objSoftAssert.assertEquals(titleOfPlaceOrder, objProp.getProperty("TitleOfPlaceOrderPage"));

		GmoOnlinePOM objPOM = new GmoOnlinePOM(driver);
		String unitPriceFromApp = objPOM.unitPriceFromApp.getText();
		System.out.println("unitPriceFromApp :" + unitPriceFromApp);
		String unitPriceFromAppWithoutDollar = unitPriceFromApp.substring(Constants.UnitPriceSubStringIndex);
		System.out.println("unitPriceFromAppWithoutDollar :" + unitPriceFromAppWithoutDollar);
		float floatValueOfUnitPrice = Float.parseFloat(unitPriceFromAppWithoutDollar);
		float calculatedValueOfUnitPrice = floatValueOfUnitPrice * Integer.parseInt(Constants.Glacier_Sun_Glasses_Qty);
		System.out.println("calculatedValueOfUnitPrice:" + calculatedValueOfUnitPrice);

		String totalPriceFromApp = objPOM.totalPriceFromApp.getText();
		System.out.println("totalPriceFromApp :" + totalPriceFromApp);
		String actualTotalPriceFromAppWithoutDollar = totalPriceFromApp.substring(Constants.UnitPriceSubStringIndex);
		System.out.println("actualTotalPriceFromAppWithoutDollar :" + actualTotalPriceFromAppWithoutDollar);
		float calculatedFloatValueOfTotalPriceFromApp = Float.parseFloat(actualTotalPriceFromAppWithoutDollar);
		System.out.println("calculatedFloatValueOfTotalPriceFromApp:" + calculatedFloatValueOfTotalPriceFromApp);
		Assert.assertEquals(calculatedValueOfUnitPrice, calculatedFloatValueOfTotalPriceFromApp);
		
		objSoftAssert.assertAll();
	}
	
	@Test(priority=3,dependsOnMethods = {"ValidateLaunchOfGmoOnlineApplication","ValidateGlacierSunGlassesProduct","ValidatePriceCalculationOnPlaceOrderPage"})
	public void ValidateGrandTotal()
	{
		GmoOnlinePOM objPOM = new GmoOnlinePOM(driver);
		String productTotalFromApp = objPOM.productTotalFromApp.getText();
		System.out.println("productTotalFromApp :" +productTotalFromApp);
		String productTotalFromAppWithoutDollar = productTotalFromApp.substring(Constants.UnitPriceSubStringIndex);
		System.out.println("productTotalFromAppWithoutDollar :" +productTotalFromAppWithoutDollar);
		float floatValueOfProductTotal = Float.parseFloat(productTotalFromAppWithoutDollar);
		System.out.println("floatValueOfProductTotal :" +floatValueOfProductTotal);
		
		String slaesTaxFromApp = objPOM.slaesTaxFromApp.getText();
		System.out.println("slaesTaxFromApp :" +slaesTaxFromApp);
		String slaesTaxFromAppWithoutDollar = slaesTaxFromApp.substring(Constants.UnitPriceSubStringIndex);
		System.out.println("slaesTaxFromAppWithoutDollar :" +slaesTaxFromAppWithoutDollar);
		float floatValueOfSlaesTax = Float.parseFloat(slaesTaxFromAppWithoutDollar);
		System.out.println("floatValueOfSlaesTax :" +floatValueOfSlaesTax);
		
		String shippingAndHandlingFromApp = objPOM.shippingAndHandlingFromApp.getText();
		System.out.println("shippingAndHandlingFromApp :" +shippingAndHandlingFromApp);
		String shippingAndHandlingFromAppWithoutDollar = shippingAndHandlingFromApp.substring(Constants.UnitPriceSubStringIndex);
		System.out.println("shippingAndHandlingFromAppWithoutDollar :" +shippingAndHandlingFromAppWithoutDollar);
		float floatValueOfShippingAndHandling = Float.parseFloat(shippingAndHandlingFromAppWithoutDollar);
		System.out.println("floatValueOfShippingAndHandling :" +floatValueOfShippingAndHandling);
		
		float calculatedValueOfGrandTotal = floatValueOfProductTotal+floatValueOfSlaesTax+floatValueOfShippingAndHandling;
		System.out.println("calculatedValueOfGrandTotal :" +calculatedValueOfGrandTotal);
		
		String grandTotalFromApp = objPOM.grandTotalFromApp.getText();
		System.out.println("grandTotalFromApp :" +grandTotalFromApp);
		String grandTotalFromAppWithoutDollar = grandTotalFromApp.substring(Constants.UnitPriceSubStringIndex);
		System.out.println("grandTotalFromAppWithoutDollar :" +grandTotalFromAppWithoutDollar);
		float floatValueOfGrandTotalFromApp = Float.parseFloat(grandTotalFromAppWithoutDollar);
		System.out.println("floatValueOfGrandTotal :" +floatValueOfGrandTotalFromApp);
		
		try 
		{
			Assert.assertEquals(floatValueOfGrandTotalFromApp,calculatedValueOfGrandTotal);
			System.out.println("floatValueOfGrandTotal & calculatedValueOfGrandTotal are equal");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() 
	{
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() 
	{
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() 
	{
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() 
	{
		System.out.println("inside beforeTest");
		LaunchBrowser();
	}

	@AfterTest
	public void afterTest() 
	{
		System.out.println("inside afterTest");
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
		System.out.println("inside afterSuite");
	}

}
