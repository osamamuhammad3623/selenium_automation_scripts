package default_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Swag_Labs_Automation {
	
	WebDriver driver = new ChromeDriver();
	
	public void login() {
		/*
		 * login Variables
		 * */
		String username = "standard_user";
		String password = "secret_sauce";

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
	}
		
	public void add_product_to_cart() {
		// click on first product to go to its page
		driver.findElement(By.xpath("//a[@id='item_4_title_link']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
	}
	
	public void checkout() {
		/*
		 * checkout variables
		 * */
		String f_name = "osama";
		String l_name = "muhammad";
		int postal_code = 56411;
		
		driver.get("https://www.saucedemo.com/cart.html");
		driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']")).click();
		driver.findElement(By.id("first-name")).sendKeys(f_name);
		driver.findElement(By.id("last-name")).sendKeys(l_name);
		driver.findElement(By.id("postal-code")).sendKeys(String.valueOf(postal_code));
		driver.findElement(By.id("continue")).click();
		// confirm the purchase
		driver.findElement(By.id("finish")).click();
	}
	
	public void logout() {
		driver.findElement(By.id("react-burger-menu-btn")).click();
		// wait until Logout button is displayed on screen
		WebElement logout_btn = driver.findElement(By.id("logout_sidebar_link"));
		while (!logout_btn.isDisplayed());
		logout_btn.click();
	}
	
	
	public void purchase_flow() {
		login();
		add_product_to_cart();
		checkout();
		logout();
	}
}
