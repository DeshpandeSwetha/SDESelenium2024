package com.selenium;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;

import com.POM.GmoOnlinePOM;
import com.Utility.Constants;
import com.Utility.Library;

public class GmoOnlinewithPOMandPropertiesFile extends Library
{

	public static void main(String[] args) throws IOException 
	{
		ReadPropertiesFiles();
		LaunchBrowser();
		driver.get(objProp.getProperty("GmoOnlineAppUrl"));
		
		GmoOnlinePOM objGmoOnlinePOM = new GmoOnlinePOM(driver);
		objGmoOnlinePOM.EnterGmoOnline.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		objGmoOnlinePOM.Glacier_Sun_Glasses.clear();
		objGmoOnlinePOM.Glacier_Sun_Glasses.sendKeys(Constants.Glacier_Sun_Glasses_Qty);
		objGmoOnlinePOM.PlaceAnOrder.click();
		
		String titleOfPlaceOrderPage = driver.getTitle();
		Assert.assertEquals(titleOfPlaceOrderPage, "Place Order");
		
		String unitPriceFromApp = objGmoOnlinePOM.unitPriceFromApp.getText();
		System.out.println("unitPriceFromApp :" +unitPriceFromApp);
		String unitPriceFromAppWithoutDollar = unitPriceFromApp.substring(Constants.UnitPriceSubStringIndex);
		System.out.println("unitPriceFromAppWithoutDollar :" +unitPriceFromAppWithoutDollar);
		float floatValueOfUnitPrice = Float.parseFloat(unitPriceFromAppWithoutDollar);
		float calculatedValueOfUnitPrice = floatValueOfUnitPrice*Integer.parseInt(Constants.Glacier_Sun_Glasses_Qty);
		System.out.println("calculatedValueOfUnitPrice:" +calculatedValueOfUnitPrice);
		
		String totalPriceFromApp = objGmoOnlinePOM.totalPriceFromApp.getText();
		System.out.println("totalPriceFromApp :" +totalPriceFromApp);
		//String totalPriceFromAppWithoutDollar = totalPriceFromApp.substring(2);
		//Float totalPriceFromAppWithoutDollarinFloat = Float.parseFloat(totalPriceFromAppWithoutDollar);
		String actualTotalPriceFromAppWithoutDollar = totalPriceFromApp.substring(Constants.UnitPriceSubStringIndex);
		System.out.println("actualTotalPriceFromAppWithoutDollar :" +actualTotalPriceFromAppWithoutDollar);
		float calculatedFloatValueOfTotalPriceFromApp = Float.parseFloat(actualTotalPriceFromAppWithoutDollar);
		System.out.println("calculatedFloatValueOfTotalPriceFromApp:" +calculatedFloatValueOfTotalPriceFromApp);
		
		Assert.assertEquals(calculatedValueOfUnitPrice, calculatedFloatValueOfTotalPriceFromApp);
		
		driver.close();
	}
}
