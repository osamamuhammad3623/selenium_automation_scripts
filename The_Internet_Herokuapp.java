package default_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class The_Internet_Herokuapp {
	
	WebDriver driver = new ChromeDriver();
	
	public void add_elements(int n) {
		driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
		
		WebElement btn = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
		for (int i=0; i< n; i++)
			btn.click();
	}
	
//	public void remove_element(int index) {
//		driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
//		
//		List<WebElement> buttons = driver.findElements(By.linkText("Delete"));
//		buttons.get(index).click();
//	}
	

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
	
	
	public void dropdown_menu(String option) {
		driver.get("http://the-internet.herokuapp.com/dropdown");
		
		WebElement menu = driver.findElement(By.id("dropdown"));
		Select options = new Select(menu);
		options.selectByVisibleText(option);
	}
	
	public void js_alerts(String type) {
		
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		String alert_xpath = "";
		if (type.equals("Alert")) {
			alert_xpath = "//button[@onclick='jsAlert()']";
		}else if (type.equals("Confirm")) {
			alert_xpath = "//button[@onclick='jsConfirm()']";
		}else if (type.equals("Prompt")) {
			alert_xpath = "//button[@onclick='jsPrompt()']";
		}
		
		driver.findElement(By.xpath(alert_xpath)).click();
		
		if (type.equals("Alert")) {
			driver.switchTo().alert().accept();
		}else if (type.equals("Confirm")) {
			driver.switchTo().alert().accept(); // or dismiss
		}else if (type.equals("Prompt")) {
			driver.switchTo().alert().sendKeys("It's me!");
			driver.switchTo().alert().accept();
		}
	}
	
	
}
