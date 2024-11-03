package com.POM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class DataDrivenPOM2 extends Library
{
	public DataDrivenPOM2() 
	{
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	public WebElement firstName;
	
	@FindBy(id="last_name")
	public WebElement lastName;
	
	@FindBy(id="user_email")
	public WebElement userEmail;
	
	@FindBy(id="user_pass")
	public WebElement userPassword;
	
	@FindBy(xpath = "(//span[@class='arrowDown'])[1]")
	public WebElement downArrow;
	
	@FindBy(xpath = "(//span[@class='arrowUp'])[1]")
	public WebElement upArrow;
	
	@FindBy(xpath = "//div[@id='date_box_1623131781_field']//input[1]")
	public WebElement dob_textBox;
	
	@FindBy(xpath = "(//input[contains(@aria-label,'Year')])[1]")
	public WebElement dob_year;
	
	@FindBy(xpath = "(//div[@class='flatpickr-days'])[1]/child::div/child::span")
	public List<WebElement> seletDays;
	
	@FindBy(xpath = "(//select[@aria-label='Month'])[1]")
	public WebElement dob_month;
	
	@FindBy(xpath = "(//select[@aria-label='Month'])[1]/child::option")
	public List<WebElement> listOfMonths;
	
	@FindBy(id = "radio_1623131945_yes")
	public WebElement radio_yes;
	
	@FindBy(id = "radio_1623131945_no")
	public WebElement radio_no;
	
	@FindBy(id = "textarea_1623132039")
	public WebElement textArea;
	
	@FindBy(xpath = "//div[@id='date_box_1623197344_field']//input[1]")
	public WebElement appointment_textBox;
	
	@FindBy(xpath = "(//input[contains(@aria-label,'Year')])[2]")
	public WebElement doa_year;
	
	@FindBy(xpath = "(//select[@aria-label='Month'])[2]")
	public WebElement doa_month;
	
	@FindBy(xpath = "(//select[@aria-label='Month'])[2]/option")
	public List<WebElement> alistOfMonths;
	
	@FindBy(xpath = "(//div[@class='flatpickr-days'])[2]/div/span")
	public List<WebElement> aseletDays;
	
	@FindBy(xpath = "//input[@id='timepicker_1641276686']")
	public WebElement timePicker;
	
	@FindBy(xpath = "//div[@class='ui-timepicker-wrapper']/ul/li")
	public List<WebElement> timePickerOptions;
	
	@FindBy(xpath = "//label[text()='Date of birth']")
	public WebElement dateOfBirthText;
}