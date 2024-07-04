package com.selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.Utility.Library;

public class GmoOnline extends Library
{
	public static void main(String[] args) throws InterruptedException 
	{
		driver = new ChromeDriver();
		driver.get("https://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.name("bSubmit")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.findElement(By.name("QTY_GLASSES")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("QTY_GLASSES")).sendKeys("3");
		Thread.sleep(3000);
		
		driver.findElement(By.name("bSubmit")).click();
		String titleOfPlaceOrderPage = driver.getTitle();
		Assert.assertEquals(titleOfPlaceOrderPage, "Place Order");
		
		String unitPriceFromApp = driver.findElement(By.xpath("//table[@cellpadding='4' and @border='1']/tbody/tr[2]/td[4]")).getText();
		System.out.println("unitPriceFromApp:"+unitPriceFromApp);
		String actualUnitPriceFromAppWithoutDollar = unitPriceFromApp.substring(2);
		System.out.println("actualUnitPriceFromAppWithoutDollar:"+actualUnitPriceFromAppWithoutDollar);
		float floatUnitPrice = Float.parseFloat(actualUnitPriceFromAppWithoutDollar);
		float calculateValueOfUnitPrice = floatUnitPrice*3;
		System.out.println("calculateValueOfUnitPrice:"+calculateValueOfUnitPrice);
		
		String totalPriceFromApp = driver.findElement(By.xpath("//table[@cellpadding='4' and @border='1']/tbody/tr[2]/td[5]")).getText();
		System.out.println("totalPriceFromApp:"+totalPriceFromApp);
		String totalUnitPriceFromAppWithoutDollar = totalPriceFromApp.substring(2);
		System.out.println("totalUnitPriceFromAppWithoutDollar:"+totalUnitPriceFromAppWithoutDollar);
		float floatTotalPrice = Float.parseFloat(totalUnitPriceFromAppWithoutDollar);
		System.out.println("floatTotalPrice:"+floatTotalPrice);
		
		Assert.assertEquals(calculateValueOfUnitPrice, floatTotalPrice);
		//driver.close();
	}
}