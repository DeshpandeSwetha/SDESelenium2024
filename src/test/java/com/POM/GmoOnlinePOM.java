package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmoOnlinePOM 
{
	public WebDriver driver;
	
	public GmoOnlinePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="bSubmit")
	public WebElement EnterGmoOnline;
	
	@FindBy(name="QTY_GLASSES")
	public WebElement Glacier_Sun_Glasses;
	
	@FindBy(name="bSubmit")
	public WebElement PlaceAnOrder;
	
	@FindBy(xpath="//table[@cellpadding='4' and @border='1']/tbody/tr[2]/td[4]")
	public WebElement unitPriceFromApp;
	
	@FindBy(xpath="//table[@cellpadding='4' and @border='1']/tbody/tr[2]/td[5]")
	public WebElement totalPriceFromApp;
	
	@FindBy(xpath="//table[@cellpadding='4' and @border='1']/tbody/tr[4]/td[2]")
	public WebElement slaesTaxFromApp;
	
	@FindBy(xpath="//table[@cellpadding='4' and @border='1']/tbody/tr[5]/td[2]")
	public WebElement shippingAndHandlingFromApp;
	
	@FindBy(xpath="//table[@cellpadding='4' and @border='1']/tbody/tr[6]/td[2]")
	public WebElement grandTotalFromApp;
	
	@FindBy(xpath="//table[@cellpadding='4' and @border='1']/tbody/tr[3]/td[3]")
	public WebElement productTotalFromApp;
}
