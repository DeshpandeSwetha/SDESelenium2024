package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPOM
{
	public WebDriver driver;

	public FileUploadPOM(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='input-4']")
	public WebElement clickBrowseBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Remove']")
	public WebElement removeBtn;
	
	@FindBy(xpath = "//img[@title='32 Star Clipart _ Star Images Free.jfif'][1]")
	public WebElement imageUploaded;
}
