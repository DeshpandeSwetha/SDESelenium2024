package com.POM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class DropDownPOM extends Library
{
	public DropDownPOM() 
	{
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Gender')]")
	public WebElement scrollTillGender;
	
	@FindBy(xpath="//input[@id='dateOfBirthInput']")
	public WebElement dateOfBirth;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	public WebElement monthSelect;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	public WebElement yearSelect;
	
	@FindBy(xpath="//div[@class='react-datepicker__month']/div/div")
	public List<WebElement> selectDates;
}