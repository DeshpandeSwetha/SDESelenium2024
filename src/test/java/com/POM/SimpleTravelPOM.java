package com.POM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class SimpleTravelPOM extends Library
{
	public SimpleTravelPOM() 
	{
        PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//button[normalize-space()='Customer Login']")
	public WebElement customerLogin;
	
	@FindBy(xpath ="//button[normalize-space()='Bank Manager Login']")
	public WebElement managerLogin;
	
	@FindBy(xpath ="//div[@class='center']/child::button")
	public List<WebElement> managerOperationsText;
	
	@FindBy(xpath ="//button[normalize-space()='Add Customer']")
	public WebElement addCustomerBtn;
	
	@FindBy(xpath ="//form[@name='myForm']")
	public WebElement customerForm;
	
	@FindBy(xpath ="//input[@placeholder='First Name']")
	public WebElement firstName;
	
	@FindBy(xpath ="//input[@placeholder='Last Name']")
	public WebElement lastName;
	
	@FindBy(xpath ="//input[@placeholder='Post Code']")
	public WebElement pinCode;
	
	@FindBy(xpath ="//button[@type='submit']")
	public WebElement addCustomerButton;
	
	@FindBy(xpath ="//button[normalize-space()='Open Account']")
	public WebElement openAccountButton;
	
	@FindBy(xpath ="//select[@id='userSelect']")
	public WebElement customerNameBox;
	
	@FindBy(xpath ="//select[@id='userSelect']/option")
	public List<WebElement> customerNameOptions;
	
	@FindBy(xpath ="//select[@id='currency']")
	public WebElement currencyBox;
	
	@FindBy(xpath ="//select[@id='currency']/option")
	public List<WebElement> currencyOptions;
	
	@FindBy(xpath ="//button[normalize-space()='Customers']")
	public WebElement customerButton;
	
	@FindBy(xpath ="//input[@placeholder='Search Customer']")
	public WebElement searchContent;
	
	@FindBy(xpath ="//table/tbody/tr")
	public List<WebElement> customerRows;
	
	@FindBy(xpath ="//button[.='Delete']")
	public WebElement deleteButton;
	
	@FindBy(xpath ="//button[normalize-space()='Home']")
	public WebElement homeButton;
	
	@FindBy(xpath ="//select[@id='userSelect']")
	public WebElement selectCustomerBox;
	
	@FindBy(xpath ="//select[@id='userSelect']/option")
	public List<WebElement> selectCustomer;
	
	@FindBy(xpath ="//button[normalize-space()='Login']")
	public WebElement loginButton;
	
	@FindBy(xpath ="//span[@class='fontBig ng-binding']")
	public WebElement customerNameCheck;
	
	@FindBy(xpath ="//div[@class='borderM box padT20 ng-scope']/child::div[2]")
	public WebElement divElement;
	
	@FindBy(xpath ="//select[@id='accountSelect']")
	public WebElement accountDropDownBox;
	
	@FindBy(xpath ="//select[@id='accountSelect']/option")
	public List<WebElement> accountSelect;
	
	@FindBy(xpath ="//button[normalize-space()='Transactions']")
	public WebElement transactionButton;
	
	@FindBy(xpath ="//button[normalize-space()='Deposit']")
	public WebElement depositButton;
	
	@FindBy(xpath ="//button[normalize-space()='Withdrawl']")
	public WebElement withdrawlButton;
	
	@FindBy(xpath ="//div[@class='borderM box padT20 ng-scope']/child::div[3]/button")
	public List<WebElement> buttonList;
	
	@FindBy(xpath ="//input[@placeholder='amount']")
	public WebElement AmountBox1;
	
	@FindBy(xpath ="//input[@ng-model='amount']")
	public WebElement AmountBox2;
	
	@FindBy(xpath ="//button[.='Deposit']")
	public WebElement deposit;
	
	@FindBy(xpath ="//span[@class='error ng-binding']")
	public WebElement message;
	
	@FindBy(xpath ="//div[@class='borderM box padT20 ng-scope']/child::div[2]/child::strong[2]")
	public WebElement balanceAmount;
	
	@FindBy(xpath ="//button[.='Withdraw']")
	public WebElement withdraw;
	
	@FindBy(xpath ="//button[normalize-space()='Back']")
	public WebElement backButton;
	
	@FindBy(xpath ="//button[normalize-space()='Reset']")
	public WebElement resetButton;
	
	@FindBy(xpath ="//table[@class='table table-bordered table-striped']/tbody/tr")
	public List<WebElement> transactionRows;
	
	@FindBy(xpath ="//button[normalize-space()='>']")
	public WebElement nextButton;
	
	@FindBy(xpath ="//button[normalize-space()='Logout']")
	public WebElement logoutButton;
	
}