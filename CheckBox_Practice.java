package com.practice.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBox_Practice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//check
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		System.out.println("This is checked");
		
		//this was vanishing fast and hence to see the selection, sleep has been added.
		Thread.sleep(2000);
		
		//uncheck
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		System.out.println("This is unchecked now");
		
		//to get the number of count of Checkbox present in the page
		// we can get this by finding the common element, like here "checkbox", is common.
		System.out.println("Total no of checkbox in the page is: "+ driver.findElements(By.cssSelector("input[type=\"checkbox\"]")).size());

	}

}