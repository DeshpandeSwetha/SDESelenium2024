package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class WindowPOM2 extends Library
{
	public WindowPOM2() 
	{
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='newWindowBtn']")
	public WebElement openNewWindowBtn;
	
	@FindBy(xpath="//h1[normalize-space()='Basic Controls']")
	public WebElement scrollTillBasicControl;
	
	@FindBy(xpath="//button[@id='newTabBtn']")
	public WebElement openNewWindowBtn2;
	
	@FindBy(xpath="//h1[contains(.,'AlertsDemo')]")
	public WebElement scrollTillAlertsDemo;
	
	@FindBy(xpath="//button[contains(.,'Open Multiple Windows')]")
	public WebElement openMultipleWindowBtn;
	
	@FindBy(xpath="//h1[@class='post-title entry-title']")
	public WebElement scrollTillXpathPractice;
	
	@FindBy(xpath="//button[@id='newTabsBtn']")
	public WebElement openMultipleTabsBtn;
}
