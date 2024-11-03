package com.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class GreenKartPOM extends Library
{
	public GreenKartPOM() 
	{
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='products']/div")
	public List<WebElement> products;
	
	@FindBy(xpath = "//div[@class='products']/div/h4")
	public List<WebElement> productNames;
	
	@FindBy(xpath = "//div[@class='product-action']/button")
	public WebElement addToCartBtn;
	
	@FindBy(xpath = "//img[@alt='Cart']")
	public WebElement clickAddToCartIcon;
	
	@FindBy(xpath = "//button[contains(.,'PROCEED TO CHECKOUT')]")
	public WebElement clickProceedToCheckoutBtn;
	
	@FindBy(xpath = "//input[@placeholder='Enter promo code']")
	public WebElement textBox;
	
	@FindBy(xpath = "//button[@class='promoBtn']")
	public WebElement applyNowBtn;
	
	@FindBy(xpath = "//button[contains(.,'Place Order')]")
	public WebElement placeOrderBtn;
	
	@FindBy(xpath = "//span[@class='promoInfo']")
	public WebElement promoCodeAppliedText;
	
	@FindBy(xpath = "//div[@class='wrapperTwo']//div//select")
	public WebElement selectCountryDropDown;
	
	@FindBy(xpath = "//div[@class='wrapperTwo']//div//select/option")
	public List<WebElement> selectCountry;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement clickOnCheckBox;
	
	@FindBy(xpath = "//label")
	public WebElement countryPageDisplayed;
	
	@FindBy(xpath = "//button")
	public WebElement clickOnProceed;
	
	@FindBy(xpath = "//img[@alt='Cart']/following-sibling::span")
	public WebElement cartCount;
}