package com.POM;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class TravelPOM extends Library
{
	public TravelPOM() 
	{
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="username")
	public WebElement username;
	
	@FindBy(id ="password")
	public WebElement password;
	
	@FindBy(id ="remember_me")
	public WebElement rememberMeCheckBox;
	
	@FindBy(name ="commit")
	public WebElement signInBtn;
	
	@FindBy(xpath ="//h2")
	public WebElement selectFlightText;
	
	@FindBy(xpath ="//input[@value='return']")
	public WebElement returnRadio;
	
	@FindBy(xpath ="//input[@value='oneway']")
	public WebElement oneWayRadio;
	
	@FindBy(xpath ="//select[@name='fromPort']")
	public WebElement fromTxtBox;
	
	@FindBy(xpath ="//select[@name='toPort']/child::option")
	public List<WebElement> fromTxtOptions;
	
	@FindBy(xpath ="//select[@name='toPort']")
	public WebElement toTxtBox;
	
	@FindBy(xpath ="//select[@name='toPort']/child::option")
	public List<WebElement> toTxtOptions;
	
	@FindBy(xpath ="//select[@id='departDay']")
	public WebElement departingDateBox;
	
	@FindBy(xpath ="//select[@id='departDay']/child::option")
	public List<WebElement> departingDateOptions;
	
	@FindBy(xpath ="//select[@id='departMonth']")
	public WebElement departingMonthAndYearBox;
	
	@FindBy(xpath ="//select[@id='departMonth']/child::option")
	public List<WebElement> departingMonthAndYearOptions;
	
	@FindBy(xpath ="//select[@id='returnDay']")
	public WebElement returnDateBox;
	
	@FindBy(xpath ="//select[@id='returnDay']/child::option")
	public List<WebElement> returnDateOptions;
	
	@FindBy(xpath ="//select[@id='returnMonth']")
	public WebElement returnMonthAndYearBox;
	
	@FindBy(xpath ="//select[@id='returnMonth']/child::option")
	public List<WebElement> returnMonthAndYearOptions;
	
	@FindBy(xpath ="//input[@value='Continue']")
	public WebElement continueBtn;
	
	@FindBy(id ="flights")
	public WebElement flightTable;
	
	@FindBy(xpath ="//table[@id='flights']/tbody/tr")
	public List<WebElement> rows;
	
	@FindBy(xpath ="//table[@id='flights']/tbody/tr/td")
	public List<WebElement> cells;
	
	@FindBy(xpath ="//tbody/tr[1]/th/input")
	public WebElement checkBox1;
	
	@FindBy(xpath ="//tbody/tr[2]/th/input")
	public WebElement checkBox2;
	
	@FindBy(xpath ="//tbody/tr[3]/th/input")
	public WebElement checkBox3;
	
	@FindBy(xpath ="//h2")
	public WebElement passengerText;
	
	@FindBy(name ="passengerFirstName")
	public WebElement passengerFirstName;
	
	@FindBy(name ="passengerLastName")
	public WebElement passengerLastName;
	
	@FindBy(xpath ="//input[@value='Next']")
	public WebElement nextBtn;
	
	@FindBy(xpath ="//h2")
	public WebElement paymentText;
	
	@FindBy(xpath ="//div[2]")
	public WebElement totalAmount;
	
	@FindBy(xpath ="//input[@value='visa']")
	public WebElement visaCard;
	
	@FindBy(xpath ="//input[@name='card_number']")
	public WebElement cardNumber;
	
	@FindBy(xpath = "//select[@name='expiry_month']/option")
	public List<WebElement> expiryDate;
	
	@FindBy(xpath = "//select[@name='expiry_year']/option")
	public List<WebElement> expiryYear;
	
	@FindBy(xpath ="//input[@value='Pay now']")
	public WebElement payNowBtn;
	
	@FindBy(xpath ="//div[@id='confirmation']/h2")
	public WebElement confirmationText;
	
	@FindBy(xpath ="//div[@id='confirmation']/p[1]")
	public WebElement bookingNumber;
	
	@FindBy(xpath ="//div[@id='confirmation']/div/p")
	public WebElement flightTrip;
	
	@FindBy(xpath ="//div[@id='confirmation']//div[1]")
	public WebElement travelPlaces;
	
	@FindBy(xpath ="//label")
	public WebElement passengerDetails;
	
	@FindBy(xpath ="//a[normalize-space()='Sign off']")
	public WebElement signOff;
	
}