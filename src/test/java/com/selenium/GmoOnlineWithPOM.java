package com.selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.POM.GmoOnlinePOM;
import com.Utility.Library;

public class GmoOnlineWithPOM extends Library
{
	public static void main(String[] args) throws InterruptedException 
	{
		driver = new ChromeDriver();
		driver.get("https://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		GmoOnlinePOM objGmoOnlinePOM = new GmoOnlinePOM(driver);
		objGmoOnlinePOM.EnterGmoOnline.click();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		objGmoOnlinePOM.Glacier_Sun_Glasses.clear();
		Thread.sleep(3000);
		objGmoOnlinePOM.Glacier_Sun_Glasses.sendKeys("3");
		Thread.sleep(3000);
		objGmoOnlinePOM.PlaceAnOrder.click();
		
		String titleOfPlaceOrderPage = driver.getTitle();
		Assert.assertEquals(titleOfPlaceOrderPage, "Place Order");
		String unitPriceFromApp = objGmoOnlinePOM.unitPriceFromApp.getText();
		System.out.println("unitPriceFromApp:"+unitPriceFromApp);
		String actualUnitPriceFromAppWithoutDollar = unitPriceFromApp.substring(2);
		System.out.println("actualUnitPriceFromAppWithoutDollar:"+actualUnitPriceFromAppWithoutDollar);
		float floatUnitPrice = Float.parseFloat(actualUnitPriceFromAppWithoutDollar);
		float calculateValueOfUnitPrice = floatUnitPrice*3;
		System.out.println("calculateValueOfUnitPrice:"+calculateValueOfUnitPrice);
		
		String totalPriceFromApp = objGmoOnlinePOM.totalPriceFromApp.getText();
		System.out.println("totalPriceFromApp:"+totalPriceFromApp);
		String totalUnitPriceFromAppWithoutDollar = totalPriceFromApp.substring(2);
		System.out.println("totalUnitPriceFromAppWithoutDollar:"+totalUnitPriceFromAppWithoutDollar);
		float floatTotalPrice = Float.parseFloat(totalUnitPriceFromAppWithoutDollar);
		System.out.println("floatTotalPrice:"+floatTotalPrice);
		
		Assert.assertEquals(calculateValueOfUnitPrice, floatTotalPrice);
		driver.close();
	}
}