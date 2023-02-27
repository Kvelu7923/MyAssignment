package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewCaller {
	ChromeDriver driver =new ChromeDriver();
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
		driver.findElement(By.id("filter")).sendKeys("Callers");
		driver.findElement(By.xpath("//div[text()='Callers']")).click();
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("kathir");
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys("kvelu7923@gmail.com");
		driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("(+91) 733909-5673");
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("A");
		driver.findElement(By.xpath("(//button[@value='sysverb_insert'])[2]")).click();
		
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).sendKeys("kathir A",Keys.ENTER);
		
		String created = driver.findElement(By.xpath("//td[text()='kathir']")).getText();
		System.out.println("Newly Created"+created);
		
		
		

	}
	@AfterMethod
	public void closebrowser() {
		driver.quit();
		
	}
}
