package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class MouseOperationsPOM extends Library
{
    public MouseOperationsPOM()
    {
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//span[contains(.,'right click me')]")
    public WebElement rightClickBtn;
    
    @FindBy(xpath="//span[text()='Copy']")
    public WebElement clickOnCopy;
    
    @FindBy(xpath="//iframe")
    public WebElement iFrame;
    
    @FindBy(xpath="//span[contains(text(),'Double click the block')]/preceding-sibling::div")
    public WebElement blueColorBox;
    
    @FindBy(xpath="//iframe")
    public WebElement dragAndDropFrame;
    
    @FindBy(xpath="//div[@id='draggable']")
    public WebElement draggable;
    
    @FindBy(xpath="//div[@id='droppable']")
    public WebElement droppable;
}