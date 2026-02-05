package com.practice.assignment;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPagePractice {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/LoginPagepractise");
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String username = "", password = "";

		String findTextElemnent = driver.findElement(By.cssSelector(".text-center.text-white")).getText();

		String extractedText[] = findTextElemnent.split(" ");

		for(int i = 0; i < extractedText.length; i++) {
			String cleanWord = extractedText[i].replace(")", "");
			if(cleanWord.equalsIgnoreCase("rahulshettyacademy")) {
				username = cleanWord;
			}
			else if(cleanWord.equalsIgnoreCase("Learning@830$3mK2")) {
				password = cleanWord;
			}
		}
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='user']")).click();
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn"))).click();
		
		WebElement selectDropdown = driver.findElement(By.cssSelector("select[data-style$='btn-info']"));
		Select dropdown = new Select(selectDropdown);
		dropdown.selectByVisibleText("Consultant");
		
		driver.findElement(By.id("terms")).click();;
		driver.findElement(By.id("signInBtn")).click();;
		
//		going to next page
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".zmdi.zmdi-shopping-cart")));
		
		List<WebElement> totalProduct = driver.findElements(By.cssSelector(".zmdi.zmdi-shopping-cart"));
		
		for(int i=1; i <= totalProduct.size(); i++) {
			System.out.println("hello");
			driver.findElement(By.cssSelector(".zmdi.zmdi-shopping-cart")).click();
		}

		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
//		going to next page
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country"))).sendKeys("Noida");
		driver.findElement(By.cssSelector("label[for='checkbox2']")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		System.out.println(driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success"))).getText());
	}
}
