package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ServiceCategories {

	ChromeDriver driver = new ChromeDriver();

	@BeforeMethod
	public void launch() {
		driver.get("https://dev140572.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void login() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("P-qQ7@umSYz8");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		driver.findElement(By.id("filter")).sendKeys("service categories");
		driver.findElement(By.xpath("//div[text()='My Service Categories']")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		
		WebElement element = driver.findElement(By.xpath("//input[@name='sys_display.IO:7406637b47701100ba13a5554ee49012']"));
		element.clear();
		element.sendKeys("IT");
		
		driver.findElement(By.xpath("//button[@name='submit_button']")).click();
		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();	
	}
	
	@AfterMethod
	public void closebrowser() throws InterruptedException {
	Thread.sleep(5000);
		driver.quit();
		
	}
}