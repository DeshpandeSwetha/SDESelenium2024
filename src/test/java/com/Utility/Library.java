package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Library 
{
	public static WebDriver driver;
	public static Properties objProp;
	
	public static ExtentHtmlReporter ExtHtmlReporter;
	public static ExtentReports ExtReports;
	public static ExtentTest ExtTest;
	
	public void StartExtentReport() 
	{
		File objFile = new File(System.getProperty("user.dir")+"//test-output//ExtentReportV4.html");
		ExtentHtmlReporter objExtentHtmlReporter = new ExtentHtmlReporter(objFile);
		objExtentHtmlReporter.config().setDocumentTitle("Automation Report");
		objExtentHtmlReporter.config().setReportName("Extent Report");
		objExtentHtmlReporter.config().setTheme(Theme.STANDARD);
		ExtReports = new ExtentReports();
		ExtReports.attachReporter(objExtentHtmlReporter);
		
		ExtReports.setSystemInfo("TesterName", "Swetha");
		ExtReports.setSystemInfo("Broswer", objProp.getProperty("browser"));
		ExtReports.setSystemInfo("Environment", objProp.getProperty("Environment"));
	}
	
	public void UpdatingResultInExtentReport(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			ExtTest.log(Status.PASS, "Test Case Passed is "+result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			ExtTest.log(Status.FAIL, "Test Case Failed is "+result.getName());
			ExtTest.log(Status.FAIL, "Test Case Failed due to "+result.getThrowable());
			try 
			{
				ExtTest.addScreenCaptureFromPath(TakeScreenShot(result.getName()));
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			ExtTest.log(Status.SKIP, "Test Case Skipped is "+result.getName());
		}
	}
	
	public static String TakeScreenShot(String testcaseName) throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyy/MM/dd/HH-mm-ss").format(new Date());
		String destination = System.getProperty("user.dir") + "//ScreenShots//" + dateName + testcaseName+"captured.jpeg";
		FileUtils.copyFile(src, new File(destination));
		return destination;
	}
	
	public void FlushReport()
	{
		ExtReports.flush();
	}
	
	public static void ReadPropertiesFiles() throws IOException
	{
		try 
		{
			File ObjFile = new File(System.getProperty("user.dir")+"//src//test//resources//Config.Properties");
			FileInputStream ObjFileInput = new FileInputStream(ObjFile);
			objProp = new Properties();
			objProp.load(ObjFileInput);
			System.out.println(objProp.getProperty("browser"));
			//System.out.println(objProp.getProperty("GmoOnlineAppUrl"));
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void LaunchBrowser()
	{
		String browserFromPropFile = objProp.getProperty("browser");
		switch (browserFromPropFile.toLowerCase()) 
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Please provide browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.ImplicitWaitTimeOut));
	}
	
	public void PageLoadTimeOut(int seconds)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}
	
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	
	public int randomInteger()
	{
		Random random = new Random();
		int x = random.nextInt(32);
		//int x = (int) (Math.random()*32);
		if(x==0)
		{
			x=1;
		}
		System.out.println("Random number generated is:"+x);
		return x;
	}
	
}