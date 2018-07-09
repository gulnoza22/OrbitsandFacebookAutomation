package com.careerbuilder;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingOrbitz {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url="https://www.orbitz.com";
		driver.get(url);
		// Flying from Houston
   		 driver.findElement(By.id("package-origin-hp-package")).clear();
	     driver.findElement(By.id("package-origin-hp-package")).sendKeys("New York");
		
		//To JFK airport 
		driver.findElement(By.id("package-destination-hp-package")).clear();
		driver.findElement(By.id("package-destination-hp-package")).sendKeys("JFK");
		//Deaprting date
		driver.findElement(By.id("package-departing-hp-package")).clear();
		driver.findElement(By.id("package-departing-hp-package")).sendKeys("07/10/2018");
		//Returning date
		driver.findElement(By.id("package-returning-hp-package")).clear();
		driver.findElement(By.id("package-returning-hp-package")).sendKeys("07/20/2018");
		
		//Selecting room number
		Select button1= new Select(driver.findElement(By.id("package-rooms-hp-package")));
		button1.selectByVisibleText("3");
		// Selecting adults number
		Select button2= new Select(driver.findElement(By.id("package-1-adults-hp-package")));
		button2.selectByIndex(2);
		// selecting kids number
		Select button3= new Select(driver.findElement(By.id("package-1-children-hp-package")));
		button3.selectByValue("1");
		//To  check box for booking hotel
		WebElement element= driver.findElement(By.id("partialHotelBooking-hp-package"));
		element.click();
		//Selecting preferred class->Business or Economy...
		Select button4= new Select(driver.findElement(By.id("package-advanced-preferred-class-hp-package")));
		button4.selectByIndex(2);
		
		driver.findElement(By.id("search-button-hp-package")).click();
		
		Thread.sleep(5000);
		driver.close();
	}

}
