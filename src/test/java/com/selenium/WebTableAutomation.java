package com.selenium;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableAutomation {
    public static void main(String[] args) 
    {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Navigate to the practice web table page
        driver.get("https://cosmocode.io/automation-practice-webtable/");

        // Locate the web table
        WebElement table = driver.findElement(By.xpath("//table[@id='countries']"));

        // Find all the rows of the table (each row is a <tr> element)
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Iterate through each row
        for (int i = 0; i < rows.size(); i++) 
        {
            // Find all the columns for the current row (each column is a <td> or <th> element)
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

            // If the current row contains header (first row), it may have <th> elements
            if (cols.isEmpty()) 
            {
                cols = rows.get(i).findElements(By.tagName("th"));
            }

            // Iterate through each column in the current row
            for (int j = 0; j < cols.size(); j++)
            {
                // Get the text of each cell and print it
                String cellText = cols.get(j).getText();
                System.out.print(cellText + "\t");  // Print cell data separated by a tab
            }

            // Print a new line after each row
            System.out.println();
        }

        // Close the browser
        driver.quit();
    }
}
