package default_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class The_Internet_Herokuapp {
	
	WebDriver driver = new ChromeDriver();
	
	public void add_elements(int n) {
		driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
		driver.manage().window().maximize();
		
		WebElement btn = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
		for (int i=0; i< n; i++)
			btn.click();
	}
	

	public void check_checkbox(int box) {
		/*
		 * Check-box 1 is unchecked by default
		 * Check-box 2 is checked by default
		 * */
		if (box !=1 && box!=2) {return;}
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		
		String xpath_string = "(//input[@type='checkbox'])";
		String final_xpath = xpath_string + "[" + String.valueOf(box) + "]";
		driver.findElement(By.xpath(final_xpath)).click();
	}
	
	
	
}
