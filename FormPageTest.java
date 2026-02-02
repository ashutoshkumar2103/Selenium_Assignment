package com.practice.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormPageTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice");
		
		driver.findElement(By.xpath("//form //input[@name=\"name\"]")).sendKeys("Ashutosh Kumar");
		driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys("ashuatif14347@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Ashu@123");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		WebElement selectDropdown  = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(selectDropdown);
		dropdown.selectByVisibleText("Male");
		driver.findElement(By.cssSelector("input[id$='inlineRadio1']")).click();
		//sleep method to see the entry of date
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name=\"bday\"]")).sendKeys("21-01-1998");
		
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		
	}

}
