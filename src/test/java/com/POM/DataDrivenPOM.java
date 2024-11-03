package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class DataDrivenPOM extends Library
{
	public DataDrivenPOM() 
	{
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstName")
	public WebElement DemoSiteFirstName;
	
	@FindBy(id="lastName")
	public WebElement DemoSiteLastName;
	
	@FindBy(id="userEmail")
	public WebElement DemoSiteEmailId;
	
	@FindBy(xpath="//input[@value='Male']")
	public WebElement DemoSiteMaleOption;
	
	@FindBy(xpath="//input[@value='Female']")
	public WebElement DemoSiteFemaleOption;
	
	@FindBy(xpath="//input[@value='Other']")
	public WebElement DemoSiteOtherOption;
	
	@FindBy(id="userNumber")
	public WebElement DemoSiteMobileNumber;
	
	@FindBy(id="")
	public WebElement DemoSiteSubjects;
	
	@FindBy(xpath="//input[@id='hobbies-checkbox-1']")
	public WebElement DemoSiteSportsCheckBox;
	
	@FindBy(xpath="//input[@id='hobbies-checkbox-2']")
	public WebElement DemoSiteReadingCheckBox;
	
	@FindBy(xpath="//input[@id='hobbies-checkbox-3']")
	public WebElement DemoSiteMusicCheckBox;
	
	@FindBy(xpath="//textarea[@id='currentAddress']")
	public WebElement DemoSiteAddress;
	
	@FindBy(id="state")
	public WebElement DemoSiteState;
	
	@FindBy(xpath="")
	public WebElement DemoSiteAllState;
	
	@FindBy(id="")
	public WebElement DemoSiteCity;
	//16:29
}