package com.BDD;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.POM.TravelPOM;
import com.Utility.Constants;
import com.Utility.Library;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AgileTravelStepDefinition extends Library 
{
	@Given("Browser is launched")
	public void browser_is_launched() 
	{
	    LaunchBrowser();
	}
	@Given("User is on Agile Travel website")
	public void user_is_on_agile_travel_website() 
	{
		driver.get(objProp.getProperty("AgileTravelUrl"));
		PageLoadTimeOut(Constants.PageLoadTimeOut);
		String title=driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		Assert.assertEquals(title, objProp.getProperty("AgileTravelTitle"));
	}
	@Given("User enters username and password")
	public void user_enters_username_and_password() 
	{
		TravelPOM travel = new TravelPOM();
		travel.username.sendKeys(objProp.getProperty("TravelUserName"));
		driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
		travel.password.sendKeys(objProp.getProperty("TravelPassword"));
	}
	@Given("User clicks on remember checkbox me")
	public void user_clicks_on_remember_checkbox_me() 
	{
		TravelPOM travel = new TravelPOM();
		travel.rememberMeCheckBox.click();
	}
	@Then("user clicks on sign in button")
	public void user_clicks_on_sign_in_button() 
	{
		TravelPOM travel = new TravelPOM();
		travel.signInBtn.click();
	}
	@Then("User is on select flight page")
	public void user_is_on_select_flight_page() 
	{
		TravelPOM travel = new TravelPOM();
		PageLoadTimeOut(Constants.PageLoadTimeOut);
		String flightText = travel.selectFlightText.getText();
		Assert.assertEquals(flightText, objProp.getProperty("SelectFlightText"));
	}
	@When("User clicks on trip type")
	public void user_clicks_on_trip_type() 
	{
		TravelPOM travel = new TravelPOM();
		travel.oneWayRadio.click();
		  if(travel.oneWayRadio.isSelected())
		  {
			  travel.fromTxtBox.click();
//			  for(int i=0;i<travel.fromTxtOptions.size();i++)
//			  {
//					System.out.println("Options avaliable are: " +travel.fromTxtOptions.get(i).getText());
//			  }
			  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
			  Select select = new Select(travel.fromTxtBox);
			  select.selectByVisibleText(objProp.getProperty("FromPlace"));
			  
			  travel.toTxtBox.click();
//			  for(int i=0;i<travel.toTxtOptions.size();i++)
//			  {
//					System.out.println("Options avaliable are: " +travel.toTxtOptions.get(i).getText());
//			  }
			  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
			  Select select1 = new Select(travel.toTxtBox);
			  select1.selectByVisibleText(objProp.getProperty("ToPlace"));
			  travel.toTxtBox.click();
			  travel.departingDateBox.sendKeys(objProp.getProperty("DepartingDate"));
			  travel.departingMonthAndYearBox.sendKeys(objProp.getProperty("DepartingMonthAndYear"));
			  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
//			  for(WebElement row : travel.rows)
//			  {
//				  for(WebElement column : travel.cells)
//				  {
//					  System.out.print(column.getText() + " | ");
//				  }
//				  System.out.println();
//				  break;
//			  }
			  
			  
			  
//			  for(int i=0;i<travel.rows.size();i++)
//			  {
//				  String flightTime = null;
//				  String flightNumber=null;
//				  String flightName=null;
//				  flightTime = travel.cells.get(0).getText();
//				  flightNumber = travel.cells.get(1).getText();
//				  flightName = travel.cells.get(2).getText();
//				  System.out.println("Flight Time: " + flightTime);
//			      System.out.println("Flight Number: " + flightNumber);
//		          System.out.println("Airline: " + flightName);
//		          System.out.println("-------------------------");
//				  if(flightTime.equals(objProp.getProperty("FlightTime")))
//				  {
//					  travel.checkBox1.click();
//					  break;
//				  }
//			  }
		  }
		  else
		  {
			  travel.fromTxtBox.click();
//			  for(int i=0;i<travel.fromTxtOptions.size();i++)
//			  {
//					System.out.println("Options avaliable are: " +travel.fromTxtOptions.get(i).getText());
//		      }
			  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
			  Select select = new Select(travel.fromTxtBox);
			  select.selectByVisibleText(objProp.getProperty("FromPlace"));
			  
			  travel.toTxtBox.click();
//			  for(int i=0;i<travel.toTxtOptions.size();i++)
//			  {
//					System.out.println("Options avaliable are: " +travel.toTxtOptions.get(i).getText());
//			  }
			  driver.manage().timeouts().implicitlyWait(Constants.ImplicitWaitTimeOut, TimeUnit.SECONDS);
			  Select select1 = new Select(travel.toTxtBox);
			  select1.selectByVisibleText(objProp.getProperty("ToPlace"));
			  travel.toTxtBox.click();
			  travel.departingDateBox.sendKeys(objProp.getProperty("DepartingDate"));
			  travel.departingMonthAndYearBox.sendKeys(objProp.getProperty("DepartingMonthAndYear"));
			  travel.returnDateBox.sendKeys(objProp.getProperty("ReturnDate"));
			  travel.returnMonthAndYearBox.sendKeys(objProp.getProperty("ReturnMonthAndYear"));
		  }
	}
	@Then("User clicks on continue button")
	public void user_clicks_on_continue_button() 
	{
		TravelPOM travel = new TravelPOM();
		travel.continueBtn.click();
	}
	@Then("User is on passenger page")
	public void user_is_on_passenger_page() 
	{
		TravelPOM travel = new TravelPOM();
		String passengerText = travel.passengerText.getText();
		Assert.assertEquals(passengerText, objProp.getProperty("PassengerPageDetail"));
	}
	@Then("User enters first name and last name")
	public void user_enters_first_name_and_last_name() 
	{
		TravelPOM travel = new TravelPOM();
		travel.passengerFirstName.sendKeys(objProp.getProperty("PassengerFirstName"));
		travel.passengerLastName.sendKeys(objProp.getProperty("PassengerLastName"));
	}
	@Then("User clicks on next button")
	public void user_clicks_on_next_button() 
	{
		TravelPOM travel = new TravelPOM();
		travel.nextBtn.click(); 
	}
	@Then("user is on payment page")
	public void user_is_on_payment_page() 
	{
		TravelPOM travel = new TravelPOM();
		String paymentText = travel.paymentText.getText();
		Assert.assertEquals(paymentText, objProp.getProperty("PaymentDetail"));
	}
	@When("card type is selected")
	public void card_type_is_selected() 
	{
		TravelPOM travel = new TravelPOM();
		travel.visaCard.click();
		Assert.assertTrue(true, "Another card type is clicked");
	}
	@When("user enters card number")
	public void user_enters_card_number() 
	{
		TravelPOM travel = new TravelPOM();
		travel.cardNumber.sendKeys(objProp.getProperty("CardNumber"));
	}
	@When("user selects expiry date")
	public void user_selects_expiry_date() 
	{
		TravelPOM travel = new TravelPOM();
		selectRequiredValueFromDropDown(travel.expiryDate, objProp.getProperty("ExpiryDate"));
		selectRequiredValueFromDropDown(travel.expiryYear, objProp.getProperty("ExpiryYear"));
	}
	@When("user clicks on pay now button")
	public void user_clicks_on_pay_now_button() 
	{
		TravelPOM travel = new TravelPOM();
		travel.payNowBtn.click();
	}
	@Then("display confirmation message")
	public void display_confirmation_message() 
	{
		TravelPOM travel = new TravelPOM();
		System.out.println(travel.confirmationText.getText());
		System.out.println(travel.bookingNumber.getText());
		System.out.println(travel.travelPlaces.getText());
		System.out.println(travel.passengerDetails.getText());
	}
	@Then("user clicks on sign off link")
	public void user_clicks_on_sign_off_link() 
	{
		TravelPOM travel = new TravelPOM();
		travel.signOff.click();  
	}
}