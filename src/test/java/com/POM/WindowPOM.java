package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class WindowPOM extends Library
{
	public WindowPOM() 
	{
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(.,'Click Here')]")
	public WebElement clickHereBtn;
	
	@FindBy(xpath="//input[@name='emailid']")
	public WebElement emailTextBox;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	public WebElement submitBtn;
	
	@FindBy(xpath="//h2[.='Access details to demo site.']")
	public WebElement accessMessage;
}