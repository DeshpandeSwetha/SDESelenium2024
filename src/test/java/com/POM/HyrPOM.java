package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HyrPOM 
{
	public WebDriver driver;
	
	public HyrPOM(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(.,'AlertsDemo')]")
	public WebElement headerText;
	
	@FindBy(xpath="//button[@id='alertBox']")
	public WebElement alertBox;
	
	@FindBy(xpath="//div[@id='output']")
	public WebElement alertBoxOutput;
	
	@FindBy(xpath="//button[@id='confirmBox']")
	public WebElement confirmBox;
	
	@FindBy(xpath="//button[@id='promptBox']")
	public WebElement promptBox;
}