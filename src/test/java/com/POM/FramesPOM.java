package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class FramesPOM extends Library 
{
	public FramesPOM() 
	{
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="SingleFrame")
	public WebElement singleFrame;
	
	@FindBy(xpath="//input[@type='text']")
	public WebElement inputTextBox;
	
	@FindBy(xpath="//a[contains(text(),'Iframe with in an Iframe')]")
	public WebElement multipleIFrame;
	
	@FindBy(xpath="//iframe[@src='MultipleFrames.html']")
	public WebElement nestedOuterIFrame;
	
	@FindBy(xpath="//iframe[@src='SingleFrame.html']")
	public WebElement nestedInnerIFrame;
}