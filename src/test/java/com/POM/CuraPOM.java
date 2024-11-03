package com.POM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class CuraPOM extends Library
{
	public CuraPOM() 
	{
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//div[@class='col-lg-10 col-lg-offset-1 text-center']")
	public WebElement contactInfo;
	
	@FindBy(xpath ="//a[@id='menu-toggle']")    
	public WebElement toggleBtn;
	
	@FindBy(xpath ="//nav[@id='sidebar-wrapper']//li")
	public List<WebElement> toggleBtnMenu;

	@FindBy(xpath ="//a[@id='btn-make-appointment']")
	public WebElement makeAppointmtntBtn;
	
	@FindBy(xpath ="//input[@id='txt-username']")
	public WebElement userName;
	
	@FindBy(xpath ="//input[@id='txt-password']")
	public WebElement password;
	
	@FindBy(xpath ="//button[@id='btn-login']")
	public WebElement loginBtn;
	
	@FindBy(id ="combo_facility")
	public WebElement facilityBtn;
	
	@FindBy(xpath ="//select[@id='combo_facility']/option")
	public List<WebElement> facilityOptions;
	
	@FindBy(id ="chk_hospotal_readmission")
	public WebElement checkBox;
	
	@FindBy(id ="radio_program_medicare")
	public WebElement medicareOption;
	
	@FindBy(id ="radio_program_medicaid")
	public WebElement medicaidOption;
	
	@FindBy(id ="radio_program_none")
	public WebElement noneOption;
	
	@FindBy(xpath ="//input[@id='txt_visit_date']")
	public WebElement DOA;
	
	@FindBy(id ="txt_comment")
	public WebElement commentText;
	
	@FindBy(id ="btn-book-appointment")
	public WebElement bookAppointmentBtn;
	
	@FindBy(xpath ="//div[@class='col-xs-12 text-center']")
	public WebElement appointmentConfirmationText;
	
	@FindBy(xpath ="//a[normalize-space()='Home']")
	public WebElement homeBtn;
	
	@FindBy(xpath ="//a[normalize-space()='History']")
	public WebElement historyBtn;
	
	@FindBy(xpath ="//a[normalize-space()='Profile']")
	public WebElement profileBtn;
	
	@FindBy(xpath ="//a[normalize-space()='Logout']")
	public WebElement logoutBtn;
	
	@FindBy(xpath ="//h2")    
	public WebElement historyPage;
	
	@FindBy(xpath ="//body/section[@id='history']/div[@class='container']/div[2]")
	public List<WebElement> historyItems;
}