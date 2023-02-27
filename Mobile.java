package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Mobile {
	
	ChromeDriver driver =new ChromeDriver();
	
	
	@BeforeMethod
	public void login() {
		driver.get("https://dev140572.service-now.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void mobile() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("P-qQ7@umSYz8");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		driver.findElement(By.id("filter")).sendKeys("Service catalog");
		driver.findElement(By.xpath("//div[text()='Service Catalog']")).click();
		

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		driver.findElement(By.xpath("//strong[text()='iPhone 6s']")).click();
		
		Select dd1=new Select(driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']")));
		dd1.selectByVisibleText("Gold");
		
		Select dd2=new Select(driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]")));
		dd2.selectByVisibleText("128");
	
		//driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		
		String text = driver.findElement(By.xpath("//span[@aria-live='assertive']")).getText();
		System.out.println(text);
		
		WebElement num = driver.findElement(By.xpath("//b[text()='REQ0010045']"));
		System.out.println("Request number   "+num);
	
	}
	@AfterMethod
	public void closebrowser() {
		driver.quit();
		
	}
	
	
}
