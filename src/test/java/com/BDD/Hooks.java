package com.BDD;

import com.Utility.Library;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Library 
{
	@Before
	public static void setUp() throws Throwable
	{
		ReadPropertiesFiles();
	}
	
	@After
	public static void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
}