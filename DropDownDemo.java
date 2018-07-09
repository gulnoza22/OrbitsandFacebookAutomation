package com.careerbuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		// https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/";
		driver.get(url);
		
		// first select tag
		WebElement selectTag= driver.findElement(By.name("my_html_select_box"));
		// second select object from select tag
		Select list= new Select(selectTag);
        // list.getFirstSelectedOption();
		// getFirstSelectedOption()--> it selects first drop down value
		
		// print the selected value:
        WebElement selected = list.getFirstSelectedOption();
        //print the first selected option text
//        System.out.println(selected.getText());
        System.out.println(list.getFirstSelectedOption().getText());
        
        
        //print all the available options value
        // returns a list of all the options by method getOptions() ->(selected and not selected everything)
        List<WebElement> options = list.getOptions();
        System.out.println("------------");
       for (WebElement webElement : options) {
		System.out.println(webElement.getText());
	}
       System.out.println("----------------");
        // selectByVisibleText("Bucharest")<-- by this method you can select any the visible text inside drop down
       list.selectByVisibleText("Bucharest");
       System.out.println("selected: "+ list.getFirstSelectedOption().getText());
//       // select using the index
//       // count starts from 0
         list.selectByIndex(2);
//       // select using value
//        list.selectByValue("hjgfd");
         System.out.println("selected: "+list.getFirstSelectedOption().getText());
//       
       System.out.println("*********************");
//       
       Select secondList = new Select(driver.findElement(By.cssSelector("select[multiple='yes']")));
      secondList.deselectByVisibleText("New York");
       secondList.deselectByVisibleText("Madrid");
       List<WebElement> allSelectedOptions = secondList.getAllSelectedOptions();
//       
       for (WebElement webElement :allSelectedOptions ) {
		System.out.println(webElement.getText());
	}
       System.out.println(allSelectedOptions.size());
       secondList.deselectAll();
       System.out.println(allSelectedOptions.size());
//       
       Thread.sleep(8000);
//       driver.close();
	}

}
