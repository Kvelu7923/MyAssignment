package salceforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class Baseclss {
	ChromeDriver driver=new ChromeDriver();	
@BeforeMethod	
	public  void Login() throws InterruptedException {		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.name("Login")).click();		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");	
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//input[@id='input-124']")).sendKeys("dashboard");
		driver.findElement(By.xpath("//mark[text()='Dashboard']")).click();
		
	}
}
