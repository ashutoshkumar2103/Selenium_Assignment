// 1. Select any Checkbox.
// 2. Grab the label of the selected checkbox.
// 3. Select the option in the dropdown. Here option to select should come from the step 2.
// 4. Enter the step 2 grabbed label text


package com.practice.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckboxDropdownAlert {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.findElement(By.id("checkBoxOption2")).click();
		
		// Grabbing the label of the selected checkbox.
//		String option2 = driver.findElement(By.id("checkBoxOption2")).getAttribute("value");
		String option2 = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println(option2);
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropdown);

		select.selectByVisibleText(option2);
		
		driver.findElement(By.id("name")).sendKeys(option2);
		
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		
//		Spilting the alert text through comma and extracting the first part of the text as we need to get Options2 from the alert text.
		String extractText = alertText.split(",")[0];
		
//		Checking it by printing if the alert text contains the option2 text in the extracted text.
		System.out.println(extractText);
		
		String exactText = extractText.split(" ")[1];
		System.out.println(exactText);
		
		driver.switchTo().alert().accept();
	}
}