package com.selenium;

import org.testng.annotations.Test;

import com.POM.AutoPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestAutomationInSelenium extends Library
{
  @Test(priority=1)
  public void launchAgileTravelWebPage() 
  {
	  driver.get(objProp.getProperty("TestAutomationSiteUrl"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  Assert.assertEquals(title, objProp.getProperty("TestAutomationTitle"));
  }
  
  @Test(priority=2)
  public void validateForm()
  {
	    AutoPOM auto = new AutoPOM();
		auto.userName.sendKeys(objProp.getProperty("UserName"));
		auto.email.sendKeys(objProp.getProperty("UserEmail"));
		auto.phone.sendKeys(objProp.getProperty("UserPhoneNumber"));
		auto.address.sendKeys(objProp.getProperty("UserAddress"));
		if(objProp.getProperty("Gender").equalsIgnoreCase("female"))
		{
			auto.female.click();
		}
		else
		{
			auto.male.click();
		}
		
		switch (objProp.getProperty("Day")) 
		{
		case "Sunday":
			auto.sunday.click();
			break;
		case "Monday":
			auto.monday.click();
			break;
		case "Tuesday":
			auto.tuesday.click();
			break;
		case "Wednesday":
			auto.wednesday.click();
			break;
		case "Thursday":
			auto.thursday.click();
			break;
		case "Friday":
			auto.friday.click();
			break;
		case "Saturday":
			auto.saturday.click();
			break;

		default: System.out.println("None of the days are selected");
			break;
		}
		auto.country.click();
		driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated((By) auto.countryOptions));
		selectRequiredValueFromDropDown(auto.countryOptions,objProp.getProperty("Country") );
		Select select = new Select(auto.colors);
		select.selectByVisibleText(objProp.getProperty("Colors"));
		driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		Select select1 = new Select(auto.animals);
		select1.selectByVisibleText(objProp.getProperty("Animal"));
		scrollToElement(auto.datePicker1);
		auto.datePicker1.click();
		driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		//select month & year
		while(true)
		{
			String currentMonth = auto.month1.getText();
			String currentYear = auto.year1.getText();
			
			if(currentMonth.equalsIgnoreCase(objProp.getProperty("Month")) && currentYear.equals(objProp.getProperty("Year")))
			{
				break;
			}
			auto.nextBtn.click();
		}
		for(WebElement dt : auto.allDates)
		{
			if(dt.getText().equals(objProp.getProperty("Date")))
			{
				dt.click();
				break;
			}
		}
		auto.datePicker2.click();
    	driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
    	auto.monthBox.click();
    	driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
    	selectRequiredValueFromDropDown(auto.monthText, objProp.getProperty("Month2"));
    	auto.yearBox.click();
    	selectRequiredValueFromDropDown(auto.yearNumber, objProp.getProperty("Year2"));
    	for(WebElement dt2 : auto.allDates)
    	{
    		if(dt2.getText().equals(objProp.getProperty("Date2")))
    		{
    			dt2.click();
    			break;
    		}
    	}
    	auto.submitBtn.click();
		if(auto.submitBtn.isEnabled())
		{
			String text = auto.resultText.getText();
			System.out.println("Result displayed is:" +text);
		}
  }
  
  @Test(priority=3,enabled = false)
  public void ajaxValidation()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.scrollTillPost);
	  auto.ajaxLink.click();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
//	  String text = driver.getTitle();
//	  Assert.assertEquals(text, objProp.getProperty("GUIAndAjaxText"));
	  scrollToElement(auto.inputBox1);
	  auto.inputBox1.sendKeys(objProp.getProperty("Input1"));
	  auto.checkBox1.click();
	  auto.toggleInputBox2Btn.click();
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.visibilityOf(auto.inputBox2));
	  if(auto.inputBox2.isDisplayed())
	  {
		  auto.inputBox2.sendKeys(objProp.getProperty("Input2"));  
	  }
	  else
	  {
		  System.out.println("Status:" +auto.statusLabel.getText());
	  }
	  auto.toggleCheckBox2Btn.click();
	  wait.until(ExpectedConditions.visibilityOf(auto.checkBox2));
	  if(auto.checkBox2.isDisplayed())
	  {
		  auto.checkBox2.click();
	  }
	  else
	  {
		  System.out.println("Status:" +auto.statusLabel.getText());
	  }
	  auto.loadAjaxContentBtn.click();
	  wait.until(ExpectedConditions.visibilityOf(auto.ajaxMessage));
	  System.out.println("Ajax Message:" +auto.ajaxMessage1.getText().concat(" ").concat(auto.ajaxMessage2.getText()));
	  driver.navigate().back();
	  scrollToElement(auto.startOfPage);
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("TestAutomationTitle"));
  }
  
  @Test(priority=4)
  public void validateWikiPage()
  {
	  AutoPOM auto = new AutoPOM();
	  auto.wikiSearchBox.sendKeys(objProp.getProperty("WikiSearchText"));
	  auto.wikiSearchIcon.click();
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.ImplicitWaitTimeOut));
	  wait.until(ExpectedConditions.visibilityOfAllElements(auto.wikiSearchResult));
	  for(int i=0;i<auto.wikiSearchResult.size();i++)
	  {
		  System.out.println("Result list are:" +auto.wikiSearchResult.get(i).getText());  
	  }
	  auto.wikiSearchForMoreLink.click();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  Set<String> allWindowHandles = driver.getWindowHandles();
	  String window1 = (String) allWindowHandles.toArray()[0];
	  String window2 = (String) allWindowHandles.toArray()[1];
	  driver.switchTo().window(window2);
	  String wikiContent = driver.getCurrentUrl();
	  if(wikiContent.contains(objProp.getProperty("WikiPageText")))
	  {
		  System.out.println("User is on wikipedia page");
	  }
	  driver.close();
	  driver.switchTo().window(window1);
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("TestAutomationTitle"));
  }
  
  @Test(priority=5)
  public void validateDynamicButton()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.dynamicButtonText);
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  if(auto.startBtn.isDisplayed())
	  {
		  System.out.println("Start button is displayed");
		  //auto.startBtn.click();
	  }
	  else
	  {
		  System.out.println("Start button is not displayed");
	  }
	  if(auto.startBtn.isEnabled())
	  {
		  System.out.println("Start button is enabled and is clickable");
	  }
	  else
	  {
		  System.out.println("Start button is not enabled");
	  }
	  String actualBtnText1 = auto.startBtn.getText();
	  Assert.assertEquals(actualBtnText1, objProp.getProperty("DynamicBtn1"));
	  auto.startBtn.click();
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  if(auto.stopBtn.isDisplayed())
	  {
		  System.out.println("Stop button is displayed");
		  //auto.startBtn.click();
	  }
	  else
	  {
		  System.out.println("Stop button is not displayed");
	  }
	  if(auto.stopBtn.isEnabled())
	  {
		  System.out.println("Stop button is enabled and is clickable");
	  }
	  else
	  {
		  System.out.println("Stop button is not enabled");
	  }
	  String actualBtnText2 = auto.stopBtn.getText();
	  Assert.assertEquals(actualBtnText2, objProp.getProperty("DynamicBtn2"));
	  auto.stopBtn.click();
  }
  
  @Test(priority=6)
  public void validateAlertsAndPopups()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.dynamicButtonText);
	  auto.simpleAlertBtn.click();
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.ImplicitWaitTimeOut));
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert1 = driver.switchTo().alert();
	  String alertText1 = alert1.getText();
	  System.out.println("Alert Text:" +alertText1);
	  alert1.accept();
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  
	  auto.confirmAlertBtn.click();
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert2 = driver.switchTo().alert();
	  String alertText2 = alert2.getText();
	  System.out.println("Prompt Alert Text:" +alertText2);
	  alert2.dismiss();
	  wait.until(ExpectedConditions.visibilityOf(auto.alertDisplayText));
	  System.out.println("Alert display text:" +auto.alertDisplayText.getText());
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  
	  auto.promptAlertBtn.click();
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert3 = driver.switchTo().alert();
	  alert3.sendKeys(objProp.getProperty("PromptAlertText"));
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  alert3.accept();
	  wait.until(ExpectedConditions.visibilityOf(auto.alertDisplayText));
	  System.out.println("Alert display text:" +auto.alertDisplayText.getText());
	  
	  auto.newTabBtn.click();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  Set<String> allWindowHandles = driver.getWindowHandles();
	  String window1 = (String) allWindowHandles.toArray()[0];
	  String window2 = (String) allWindowHandles.toArray()[1];
	  driver.switchTo().window(window2);
	  String openCartContent = driver.getCurrentUrl();
	  if(openCartContent.contains(objProp.getProperty("OpenCartText")))
	  {
		  System.out.println("User is on OpenCart website");
	  }
	  driver.close();
	  driver.switchTo().window(window1);
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("TestAutomationTitle"));
  }
  
  @Test(priority=7)
  public void validateMouseHover()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.mouseHoverText);
	  Actions action = new Actions(driver);
	  action.moveToElement(auto.pointMeBtn);
//	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.ImplicitWaitTimeOut));
//	  wait.until(ExpectedConditions.visibilityOfAllElements(auto.dropDownContent));
	  selectRequiredValueFromDropDown(auto.dropDownContent, objProp.getProperty("MobileText"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("TestAutomationTitle"));
  }
  
  @Test(priority=8)
  public void validateDoubleClickOperation()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.doubleClickText);
	  Actions action = new Actions(driver);
	  action.doubleClick(auto.copyTextBtn).perform();
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  String copiedText = auto.textBox2.getAttribute("value");
	  Assert.assertEquals(copiedText, objProp.getProperty("ExpectedText"), "Test Failed: Text is not copied correctly");
  }
  
  @Test(priority=9)
  public void validateDragAndDrop()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.dragAndDropText);
	  Actions actions = new Actions(driver);
	  actions.dragAndDrop(auto.source, auto.target).perform();
	  Assert.assertEquals(auto.dropText.getText(), "Dropped!", "Test Failed: Drag and drop unsuccessful");
  }
  
  @Test(priority=10)
  public void validateSliderOperation()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.sliderText);
	  Actions actions = new Actions(driver);
	  //actions.dragAndDropBy(auto.sliderHandle, 75, 266).perform();
	  actions.clickAndHold(auto.sliderHandle).moveByOffset(10, 100).release().perform();
  }
  
  @Test(priority=11)
  public void validateDropDown()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.dropDownText);
	  auto.dropDownTextBox.click();
	  int numberOfDropDownValues = auto.dropDownList.size();
		for(int i=0;i<=numberOfDropDownValues-1;i++)
		{
			String individualDropDownValue = auto.dropDownList.get(i).getText();
			System.out.println("Drop down elements are:" +individualDropDownValue);
		}
		System.out.println("----------------------------------------");
		selectRequiredValueFromDropDown(auto.dropDownList, "Item 53");
  }
  
  @Test(priority=12)
  public void validateLaptopLinks()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.laptopLinkText);
	  for (WebElement element : auto.listOfLaptops) 
	  {
		    System.out.println(element.getText());
	  }
	  System.out.println("----------------------------------------");
	  auto.appleLink.click();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
//	  String title1=driver.getTitle();
//	  Assert.assertEquals(title1, objProp.getProperty("AppleTitle"));
	  driver.navigate().back();
	  auto.lenovoLink.click();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
//	  String title2=driver.getTitle();
//	  Assert.assertEquals(title2, objProp.getProperty("LenovoTitle"));
	  driver.navigate().back();
	  auto.dellLink.click();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
//	  String title3=driver.getTitle();
//	  Assert.assertEquals(title3, objProp.getProperty("LenovoTitle"));
	  driver.navigate().back();
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("TestAutomationTitle")); 
  }
  
  @Test(priority=13)
  public void validateBrokenLinks()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.brokenLinkText);
	  System.out.println("Totla broken links found:" +auto.brokenLinks.size());
	  for (WebElement allBrokenLinks : auto.brokenLinks) 
	  {
		  System.out.println(allBrokenLinks.getText());
	  }
	  System.out.println("----------------------------------------");
	  //loop through each link and check if it is broken or not
	  for (WebElement allBrokenLinks : auto.brokenLinks) 
	  {
		  String url = allBrokenLinks.getAttribute("href");
		  //skip if the link does not have href attribute or if it is empty
		  if(url==null || url.isEmpty())
		  {
			  System.out.println("Link is empty or has no href attribute");
			  continue;
		  }
		  //check if the link is broken
		  try 
		  {
			  HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			  connection.setRequestMethod("HEAD");
			  connection.connect();
			  int responseCode = connection.getResponseCode();
			  
			  if(responseCode>=400)
			  {
				  System.out.println("Broken link:" +url+ "-Response Code:" +responseCode);
			  }
			  else
			  {
				  System.out.println("Valid link:" +url+ "-Response Code:" +responseCode);
			  }
		  } catch (IOException e) 
		  {
			  System.out.println("Error checking link:" +url+ "-Exception:" +e.getMessage());
		  }
	  }
  }
  
  @Test(priority=14)
  public void validateUploadFileOperation()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.uploadFileText);
	  auto.chooseFile.sendKeys("D:\\8AM_Scripts\\Sample_File_1.txt");
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  auto.uploadSingleFileBtn.click();
	  System.out.println("File status:" +auto.fileStatus.getText());
	  System.out.println("----------------------------------------");
	  String filePath1 = "D:\\8AM_Scripts\\Sample_File_1.txt";
      String filePath2 = "D:\\8AM_Scripts\\Sample_File_2.txt";
	  auto.chooseFiles.sendKeys(filePath1 + "\n" + filePath2);
	  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
	  auto.uploadMultipleFilesBtn.click();
	  System.out.println("File status:" +auto.filesStatus.getText());
	  System.out.println("----------------------------------------");
  }
  
  @Test(priority=15)
  public void validateStaticWebTable()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.staticTableText);
	  System.out.println("Number of rows in the table:" +auto.tableRows.size());
	  System.out.println("Number of columns in the table:" +auto.tableColumns.size());
	  
	  System.out.println("Data from the table.........");
	  for(int r=2;r<=auto.tableRows.size();r++)
	  {
		  for(int c=1;c<=auto.tableColumns.size();c++)
		  {
			  String data = driver.findElement(By.xpath("//table[@name='BookTable']//tbody/tr["+r+"]/td["+c+"]")).getText();
			  System.out.println(data+" | ");
		  }
		  System.out.println();
	  }
	  System.out.println("----------------------------------------");	  
	  //loop through each row
//	  for(int i=0;i<auto.tableRows.size();i++)
//	  {
//		  //print each cell text
//		  for(int j=0;j<auto.tableCells.size();j++)
//		  {
//			  System.out.println(auto.tableCells.get(j).getText() + " | ");
//		  }
//		  System.out.println();
//	  }
  }
  
  @Test(priority=16)
  public void validateDynamicWebTable()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.dynamicTableText);
	  System.out.println("Number of rows in the table:" +auto.dynamictableRows.size());
	  System.out.println("Number of columns in the table:" +auto.dynamictableColumns.size());
	  
	  System.out.println("Data from the table.........");
	  for(int r=1;r<=auto.dynamictableRows.size();r++)
	  {
		  for(int c=1;c<=auto.dynamictableColumns.size();c++)
		  {
			  String data = driver.findElement(By.xpath("//table[@id='taskTable']//tr["+r+"]/td["+c+"]")).getText();
			  System.out.println(data+" | ");
		  }
		  System.out.println();
	  }
	  System.out.println("----------------------------------------");
	  System.out.println("Dynamic values are:");
	  System.out.println(auto.displayDynamicValues.getText());
	  System.out.println("----------------------------------------");
	  //loop through each row
//	  for(int i=0;i<auto.dynamictableRows.size();i++)
//	  {
//		  //print each cell text
//		  for(int j=0;j<auto.dynamictableCells.size();j++)
//		  {
//			  System.out.println(auto.dynamictableCells.get(j).getText() + " | ");
//		  }
//		  System.out.println();
//	  }
  }
  
  @Test(priority=17)
  public void validatePaginationWebTable()
  {
	  AutoPOM auto = new AutoPOM();
	  scrollToElement(auto.paginationTableText);
	  int totalPages = auto.pages.size();
	  for(int p=1;p<=totalPages;p++)
	  {
		  if(p>1)
		  {
			  WebElement activePage = driver.findElement(By.xpath("//ul[@id='pagination']//*[text()="+p+"]"));
			  activePage.click();
			  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		  }
		  //reading data from the page
		  int rowCount = auto.paginationTableRows.size();
		  for(int i=1;i<=rowCount;i++)
		  {
			  String productId = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]/td[1]")).getText();
			  String productName = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]/td[2]")).getText();
			  String productPrice = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]/td[3]")).getText();
			  driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]/td[4]/input")).click();
			  System.out.println(productId+" | "+productName+" | "+productPrice);
		  }
	  }	  
	  //loop through each pagination number and print data
//	  while(true)
//	  {
//		  for(WebElement rows : auto.paginationTableRows)
//		  {
//			  for(WebElement cells : auto.paginationtableCells)
//			  {
//				  System.out.println(cells.getText() + " | ");
//			  }
//			  System.out.println();
//		  }
//		  //to find all page links in pagination
//		  int currentPage = 1;
		  //navigate to next page if avaliable
//		  if(currentPage < auto.pages.size())
//		  {
//			  auto.pages.get(currentPage).click();
//			  currentPage++;
//		  }
//		  else
//		  {
//			  break;
//		  }
//	  }
  }
  
@BeforeMethod
  public void beforeMethod() 
  {
	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
  }

  @BeforeClass
  public void beforeClass() 
  {
	  
  }

  @AfterClass
  public void afterClass() 
  {
	  
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("inside before Test");  
	  LaunchBrowser();
  }

  @AfterTest
  public void afterTest() 
  {
      //driver.close();
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("inside beforeSuite");
	  try 
	  {
		ReadPropertiesFiles();
	  } catch (IOException e) 
	  {
		e.printStackTrace();
	  }
  }

  @AfterSuite
  public void afterSuite() 
  {
	  
  }

}
