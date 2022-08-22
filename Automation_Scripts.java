package default_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * A class that contains a one-method scripts
 * */

public class Automation_Scripts {
	
	WebDriver driver = new ChromeDriver(); 
	
	public void SIS_Automation(String id, String password) {
		// go to Login page
		driver.get("https://eng.asu.edu.eg/login");
		
		// enter credentials
		String univeristy_email = id + "@eng.asu.edu.eg";
		driver.findElement(By.id("email")).sendKeys(univeristy_email);
		driver.findElement(By.name("password")).sendKeys(password);
		 
		// click on Login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// go to My account page [dashboard]
		driver.findElement(By.linkText("My Account")).click();
		
		// go to My Courses page
		driver.findElement(By.linkText("My Courses")).click();	
	}
	
	
	public void Dorms_Automation(String national_id, String password) {
		driver.manage().window().maximize();
		// go to sign in page
		driver.get("https://alzahraa.mans.edu.eg/studentLogin");
		
		// enter credential
		driver.findElement(By.name("txtStudentID")).sendKeys(national_id);
		driver.findElement(By.name("txtStudentPassword")).sendKeys(password);
		
		// click on submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//i[@class='feather-grid']")).click();
		while(!driver.findElement(By.id("getResult")).isDisplayed());
		driver.findElement(By.id("getResult")).click();

	}
}
