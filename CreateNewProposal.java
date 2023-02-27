package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewProposal {
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
		driver.findElement(By.id("filter")).sendKeys("proposal");
		driver.findElement(By.xpath("//div[text()='My Proposals']")).click();
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("proposal");
		driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
		
	}
	@AfterMethod
	public void closebrowser() throws InterruptedException {
	Thread.sleep(5000);
		driver.quit();
		
	}
}
