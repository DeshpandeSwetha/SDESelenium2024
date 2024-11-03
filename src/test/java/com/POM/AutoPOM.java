package com.POM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class AutoPOM extends Library
{
	public AutoPOM() 
	{
        PageFactory.initElements(driver, this);
	}

	@FindBy(id ="name")
	public WebElement userName;
	
	@FindBy(id ="email")
	public WebElement email;
	
	@FindBy(id ="phone")
	public WebElement phone;
	
	@FindBy(id ="textarea")
	public WebElement address;
	
	@FindBy(id ="male")
	public WebElement male;
	
	@FindBy(id ="female")
	public WebElement female;
	
	@FindBy(xpath ="//input[@class='form-check-input' and contains(@type, 'checkbox')]")
	public List<WebElement> checkboxes;
	
	@FindBy(xpath ="//input[@id='sunday']")
	public WebElement sunday;
	
	@FindBy(xpath ="//input[@id='monday']")
	public WebElement monday;
	
	@FindBy(xpath ="//input[@id='tuesday']")
	public WebElement tuesday;
	
	@FindBy(xpath ="//input[@id='wednesday']")
	public WebElement wednesday;
	
	@FindBy(xpath ="//input[@id='thursday']")
	public WebElement thursday;
	
	@FindBy(xpath ="//input[@id='thursday']")
	public WebElement friday;
	
	@FindBy(xpath ="//input[@id='saturday']")
	public WebElement saturday;
	
	@FindBy(xpath ="//select[@id='country']")
	public WebElement country;
	
	@FindBy(xpath ="//select[@id='country']/option")
	public List<WebElement> countryOptions;
	
	@FindBy(id = "colors")
	public WebElement colors;
	
	@FindBy(id = "animals")
	public WebElement animals;
	
	@FindBy(xpath ="//input[@id='datepicker']")
	public WebElement datePicker1;
	
	@FindBy(xpath ="//span[@class='ui-datepicker-month']")
	public WebElement month1;
	
	@FindBy(xpath ="//span[@class='ui-datepicker-year']")
	public WebElement year1;
	
	@FindBy(xpath ="//span[@class='ui-icon ui-icon-circle-triangle-e']")
	public WebElement nextBtn;
	
	@FindBy(xpath ="//table[@class='ui-datepicker-calendar']/tbody/tr/td/a")
	public List<WebElement> allDates;
	
	@FindBy(xpath ="//input[@id='txtDate']")
	public WebElement datePicker2;
	
	@FindBy(xpath ="//select[@aria-label='Select month']")
	public WebElement monthBox;
	
	@FindBy(xpath ="//select[@aria-label='Select month']/option")
	public List<WebElement> monthText;
	
	@FindBy(xpath ="//select[@aria-label='Select year']")
	public WebElement yearBox;
	
	@FindBy(xpath ="//select[@aria-label='Select year']/option")
	public List<WebElement> yearNumber;
	
	@FindBy(xpath ="//button[@class='submit-btn']")
	public WebElement submitBtn;
	
	@FindBy(xpath ="//div[@id='result']")
	public WebElement resultText;
	
	@FindBy(xpath ="//div[@class='feed-links']")
	public WebElement scrollTillPost;
	
	@FindBy(xpath ="//a[normalize-space()='GUI Elements & AJAX']")
	public WebElement ajaxLink;
	
	@FindBy(id = "input1")
	public WebElement inputBox1;
	
	@FindBy(id = "input2")
	public WebElement inputBox2;
	
	@FindBy(id = "checkbox1")
	public WebElement checkBox1;
	
	@FindBy(id = "checkbox2")
	public WebElement checkBox2;
	
	@FindBy(xpath = "//button[@id='toggleInput']")
	public WebElement toggleInputBox2Btn;
	
	@FindBy(xpath = "//button[@id='toggleCheckbox']")
	public WebElement toggleCheckBox2Btn;
	
	@FindBy(xpath = "//button[@id='loadContent']")
	public WebElement loadAjaxContentBtn;
	
	@FindBy(xpath = "//span[@id='statusLabel']")
	public WebElement statusLabel;
	
	@FindBy(xpath = "//div[@id='ajaxContent']")
	public WebElement ajaxMessage;
	
	@FindBy(xpath = "//div[@id='ajaxContent']/h2")
	public WebElement ajaxMessage1;
	
	@FindBy(xpath = "//div[@id='ajaxContent']/p")
	public WebElement ajaxMessage2;
	
	@FindBy(xpath = "//div[@id='header-inner']")
	public WebElement startOfPage;
	
	@FindBy(id = "Wikipedia1_wikipedia-search-input")
	public WebElement wikiSearchBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement wikiSearchIcon;
	
	@FindBy(xpath ="//div[@id='Wikipedia1_wikipedia-search-results']//div")
	public List<WebElement> wikiSearchResult;
	
	@FindBy(xpath = "//a[contains(.,'More »')]")
	public WebElement wikiSearchForMoreLink;
	
	@FindBy(xpath = "//img[@alt='Wikipedia']")
	public WebElement wikiText;
	
	@FindBy(xpath = "//h2[normalize-space()='Dynamic Button']")
	public WebElement dynamicButtonText;
	
	@FindBy(xpath = "//button[normalize-space()='START']")
	public WebElement startBtn;
	
	@FindBy(xpath = "//button[normalize-space()='STOP']")
	public WebElement stopBtn;
	
	@FindBy(id = "alertBtn")
	public WebElement simpleAlertBtn;
	
	@FindBy(id = "confirmBtn")
	public WebElement confirmAlertBtn;
	
	@FindBy(id = "promptBtn")
	public WebElement promptAlertBtn;
	
	@FindBy(xpath = "//p[@id='demo']")
	public WebElement alertDisplayText;
	
	@FindBy(xpath = "//button[normalize-space()='New Tab']")
	public WebElement newTabBtn;
	
	@FindBy(xpath = "//h2[normalize-space()='Mouse Hover']")
	public WebElement mouseHoverText;
	
	@FindBy(xpath = "//button[normalize-space()='Point Me']")
	public WebElement pointMeBtn;
	
	@FindBy(xpath ="//div[@class='dropdown-content']")
	public List<WebElement> dropDownContent;
	
	@FindBy(xpath = "//h2[normalize-space()='Double Click']")
	public WebElement doubleClickText;
	
	@FindBy(xpath = "//button[normalize-space()='Copy Text']")
	public WebElement copyTextBtn;
	
	@FindBy(id="field2")
	public WebElement textBox2;
	
	@FindBy(xpath = "//h2[normalize-space()='Drag and Drop']")
	public WebElement dragAndDropText;
	
	@FindBy(xpath = "//p[normalize-space()='Drag me to my target']")
	public WebElement source;
	
	@FindBy(xpath = "//div[@id='droppable']")
	public WebElement target;
	
	@FindBy(xpath = "//div[@id='droppable']/p")
	public WebElement dropText;
	
	@FindBy(xpath = "//h2[normalize-space()='Slider']")
	public WebElement sliderText;
	
	@FindBy(xpath = "//div[@id='slider-range']")
	public WebElement sliderHandle;
	
	@FindBy(xpath = "//h2[normalize-space()='Scrolling DropDown']")
	public WebElement dropDownText;
	
	@FindBy(xpath = "//input[@id='comboBox']")
	public WebElement dropDownTextBox;
	
	@FindBy(xpath ="//div[@id='dropdown']/div")
	public List<WebElement> dropDownList;
	
	@FindBy(xpath = "//h4[normalize-space()='Laptop Links']")
	public WebElement laptopLinkText;
	
	@FindBy(xpath = "//div[@id='laptops']/a")
	public List<WebElement> listOfLaptops;
	
	@FindBy(xpath = "//a[@id='apple']")
	public WebElement appleLink;
	
	@FindBy(xpath = "//a[@id='lenovo']")
	public WebElement lenovoLink;
	
	@FindBy(xpath = "//a[@id='dell']")
	public WebElement dellLink;
	
	@FindBy(xpath = "//h4[normalize-space()='Broken Links']")
	public WebElement brokenLinkText;
	
	@FindBy(xpath = "//div[@id='broken-links']/a")
	public List<WebElement> brokenLinks;
	
	@FindBy(xpath = "//h2[normalize-space()='Upload Files']")
	public WebElement uploadFileText;
	
	@FindBy(xpath = "//input[@id='singleFileInput']")
	public WebElement chooseFile;
	
	@FindBy(xpath = "//button[normalize-space()='Upload Single File']")
	public WebElement uploadSingleFileBtn;
	
	@FindBy(xpath = "//p[@id='singleFileStatus']")
	public WebElement fileStatus;
	
	@FindBy(xpath = "//input[@id='multipleFilesInput']")
	public WebElement chooseFiles;
	
	@FindBy(xpath = "//button[normalize-space()='Upload Multiple Files']")
	public WebElement uploadMultipleFilesBtn;
	
	@FindBy(xpath = "//p[@id='multipleFilesStatus']")
	public WebElement filesStatus;
	
	@FindBy(xpath = "//h2[normalize-space()='Static Web Table']")
	public WebElement staticTableText;
	
	@FindBy(xpath = "//table[@name='BookTable']")
	public WebElement staticWebTable;
	
	@FindBy(xpath = "//table[@name='BookTable']/tbody/tr")
	public List<WebElement> tableRows;
	
	@FindBy(xpath = "//table[@name='BookTable']/tbody/tr/th")
	public List<WebElement> tableColumns;
	
	@FindBy(xpath = "//table[@name='BookTable']/tbody/tr/td")
	public List<WebElement> tableCells;
	
	@FindBy(xpath = "//h2[normalize-space()='Dynamic Web Table']")
	public WebElement dynamicTableText;
	
	@FindBy(xpath = "//table[@id='taskTable']")
	public WebElement dynamicWebTable;
	
	@FindBy(xpath = "//table[@id='taskTable']/tbody/tr")
	public List<WebElement> dynamictableRows;
	
	@FindBy(xpath = "//table[@id='taskTable']/thead/tr/th")
	public List<WebElement> dynamictableColumns;
	
	@FindBy(xpath = "//table[@id='taskTable']/tbody/tr/td")
	public List<WebElement> dynamictableCells;
	
	@FindBy(xpath = "//div[@id='displayValues']")
	public WebElement displayDynamicValues;
	
	@FindBy(xpath = "//h2[normalize-space()='Pagination Web Table']")
	public WebElement paginationTableText;
	
	@FindBy(xpath = "//table[@id='productTable']/tbody")
	public WebElement paginationTable;
	
	@FindBy(xpath = "//table[@id='productTable']//tbody//tr")
	public List<WebElement> paginationTableRows;
	
	@FindBy(xpath = "//table[@id='productTable']/tbody/tr/td")
	public List<WebElement> paginationtableCells;
	
	@FindBy(xpath = "//ul[@id='pagination']/li/a")
	public List<WebElement> pages;
	
	
	
}