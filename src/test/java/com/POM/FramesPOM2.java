package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class FramesPOM2 extends Library
{
    public FramesPOM2()
    {
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//iframe[@id='frm1']")
    public WebElement iFrame1;
    
    @FindBy(xpath="//select[@id='course']")
    public WebElement dropdown1;
    
    @FindBy(xpath="//b[contains(.,'Course Name:')]")
    public WebElement courseName;
    
    @FindBy(xpath="//iframe[@id='frm2']")
    public WebElement iFrame2;
    
    @FindBy(xpath="//h1[contains(.,'Basic Controls in HTML')]")
    public WebElement scrollTillElement;
    
    @FindBy(xpath="//input[@id='firstName']")
    public WebElement firstName;
    
    @FindBy(xpath="//input[@id='lastName']")
    public WebElement lastName;
    
    @FindBy(xpath="//input[@id='malerb']")
    public WebElement maleOption;
    
    @FindBy(xpath="//input[@id='femalerb']")
    public WebElement femailOption;
    
    @FindBy(xpath="//input[@id='englishchbx']")
    public WebElement englishCheckBox;
    
    @FindBy(xpath="//input[@id='hindichbx']")
    public WebElement hindiCheckBox;
    
    @FindBy(xpath="//input[@id='email']")
    public WebElement emailTextBox;
    
    @FindBy(xpath="//input[@id='password']")
    public WebElement passwordTextBox;
    
    @FindBy(xpath="//button[@id='registerbtn']")
    public WebElement registerBtn;
    
    @FindBy(xpath="//button[@id='clearbtn']")
    public WebElement clearBtn;
    
    @FindBy(xpath="//label[@id='msg']")
    public WebElement confirmMessage;
    
    @FindBy(xpath="//iframe[@id='frm3']")
    public WebElement iFrame3;
}